package ru.vacationpay.services;

import org.springframework.stereotype.Service;
import ru.vacationpay.models.VacationPay;
import ru.vacationpay.services.exceptions.IncorrectInputUserInformationException;

import java.time.*;

@Service
public class VacationPayService {
    public VacationPay getInformation() {
        return new VacationPay(
                30000,
                14,
                LocalDate.of(2023, Month.JANUARY, 1),
                LocalDate.of(2023, Month.JANUARY, 14)
        );
    }

    public final int calculateVacationPay(VacationPay vacationPay) throws IncorrectInputUserInformationException {
        int qtyOfVacationDays = Period.between(
                vacationPay.getVacationStarted(), vacationPay.getVacationEnded()).getDays() + 1;

        if (vacationPay.getAverageTwelveMonthsSalary() < 0 ||
                vacationPay.getQtyOfVacationDays() < 0 ||
                qtyOfVacationDays < 0 || qtyOfVacationDays != vacationPay.getQtyOfVacationDays()) {
            throw new IncorrectInputUserInformationException("Incorrect input user information");
        }

        int year = vacationPay.getVacationStarted().getYear();
        int qtyOfwWorkDays = qtyOfDaysOfWeekendDayByYear(year, DayOfWeek.SATURDAY) +
                qtyOfDaysOfWeekendDayByYear(year, DayOfWeek.SUNDAY);
        int dailySalary = vacationPay.getAverageTwelveMonthsSalary() * 12 / (Year.of(year).length() - qtyOfwWorkDays);
        return dailySalary * qtyOfVacationDays;
    }

    public final int qtyOfDaysOfWeekendDayByYear(int year, DayOfWeek dayOfWeek) {
        LocalDate dayOfYear = LocalDate.of(year, Month.JANUARY, 1);
        int count = 0;

        while (dayOfYear.getYear() == year) {
            if (dayOfYear.getDayOfWeek() == dayOfWeek) {
                count++;
                dayOfYear = dayOfYear.plus(Period.ofDays(7));
            } else {
                dayOfYear = dayOfYear.plus(Period.ofDays(1));
            }
        }
        return count;
    }
}