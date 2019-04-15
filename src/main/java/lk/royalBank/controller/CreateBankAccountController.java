package lk.royalBank.controller;

import lk.royalBank.dto.ATMcardDTO;
import lk.royalBank.dto.CreateAccountDTO;
import lk.royalBank.service.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/createaccount")
public class CreateBankAccountController {
    @Autowired
    private CreateAccountService createAccountService;

    @PostMapping
    public void createNewAccount(@RequestBody CreateAccountDTO createAccountDTO){
        createAccountService.createAccount(createAccountDTO);
    }

    @GetMapping
    public ATMcardDTO test(){
        return new ATMcardDTO();
    }
}
