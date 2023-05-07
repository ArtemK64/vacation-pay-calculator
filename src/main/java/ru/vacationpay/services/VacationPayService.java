package ru.vacationpay.services;

import org.springframework.stereotype.Service;
import ru.vacationpay.models.VacationPayUserInformation;

import java.time.LocalDate;
import java.time.Month;

@Service
public class VacationPayService {
    public VacationPayUserInformation getInformation() {
        return new VacationPayUserInformation(
                30000,
                14,
                LocalDate.of(2023, Month.JANUARY, 1),
                LocalDate.of(2023, Month.JANUARY, 14)
        );
    }
}
