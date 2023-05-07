package ru.vacationpay.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VacationPay {
    private Integer averageTwelveMonthsSalary;
    private Integer qtyOfVacationDays;
    private LocalDate vacationStarted;
    private LocalDate vacationEnded;
}