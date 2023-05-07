package ru.vacationpay.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VacationPayUserInformation {
    private Integer averageTwelveMonthsSalary;
    private Integer qtyOfWeekendsDay;
    private LocalDate weekendStarted;
    private LocalDate weekendEnded;

    public int calculateVacationPay() {
        return 0;
    }
}