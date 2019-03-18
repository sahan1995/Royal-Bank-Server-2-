package lk.royalBank.controller;

import lk.royalBank.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/deposits")
public class DepositController {

    @Autowired
    DepositService depositService;
    @GetMapping
    void Test() throws IOException {
        depositService.depositMoney(null);
    }
}
