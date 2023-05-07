package ru.vacationpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vacationpay.models.VacationPayUserInformation;
import ru.vacationpay.services.VacationPayService;

@RestController
public class VacationPayController {
    private final VacationPayService vacationPayService;

    @Autowired
    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping("/calculate")
    public VacationPayUserInformation calculateSalary() {
        return vacationPayService.getInformation();
    }
}