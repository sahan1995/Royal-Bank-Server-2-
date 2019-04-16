package lk.royalBank.controller;

import lk.royalBank.dto.DepositDTO;
import lk.royalBank.entity.ATMcard;
import lk.royalBank.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/deposits")
public class DepositController {

    @Autowired
    DepositService depositService;
    @GetMapping
   public DepositDTO DepositDTO() throws IOException {
//        depositService.depositMoney(null);
        return new DepositDTO();
    }

    @PostMapping
    public void depositMoney(@RequestBody DepositDTO depositDTO){
        depositService.depositMoney(depositDTO);
        System.out.println(depositDTO);
    }
}
