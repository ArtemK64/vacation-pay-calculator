package ru.vacationpay.services;

import org.junit.Test;
import ru.vacationpay.models.VacationPay;
import ru.vacationpay.services.exceptions.IncorrectInputUserInformationException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationPayServiceTest {
    @Test
    public void calculateVacationPay() throws IncorrectInputUserInformationException {
        VacationPayService vacationPayService = new VacationPayService();
        assertEquals(vacationPayService.calculateVacationPay(
                new VacationPay(30000,
                        14,
                        LocalDate.of(2023, Month.JANUARY, 1),
                        LocalDate.of(2023, Month.JANUARY, 14))), 19376);
        assertEquals(vacationPayService.calculateVacationPay(new VacationPay(
                50000,
                10,
                LocalDate.of(2023, Month.FEBRUARY, 1),
                LocalDate.of(2023, Month.FEBRUARY, 10))), 23070);
    }

    @Test
    public void qtyOfDaysOfWeekendDayByYear() {
        VacationPayService vacationPayService = new VacationPayService();
        assertEquals(vacationPayService.qtyOfDaysOfWeekendDayByYear(2019, DayOfWeek.SATURDAY), 52);
        assertEquals(vacationPayService.qtyOfDaysOfWeekendDayByYear(2020, DayOfWeek.SUNDAY), 52);
        assertEquals(vacationPayService.qtyOfDaysOfWeekendDayByYear(2021, DayOfWeek.SATURDAY), 52);
        assertEquals(vacationPayService.qtyOfDaysOfWeekendDayByYear(2022, DayOfWeek.SUNDAY), 52);
        assertEquals(vacationPayService.qtyOfDaysOfWeekendDayByYear(2023, DayOfWeek.SUNDAY), 53);
    }
}