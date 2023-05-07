package ru.vacationpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vacationpay.services.VacationPayService;
import ru.vacationpay.services.exceptions.IncorrectInputUserInformationException;

@RestController
public class VacationPayController {
    private final VacationPayService vacationPayService;

    @Autowired
    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping("/calculate")
    public int calculateSalary() throws IncorrectInputUserInformationException {
        return  vacationPayService.calculateVacationPay(vacationPayService.getInformation());
    }
}