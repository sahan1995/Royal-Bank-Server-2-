package lk.royalBank.controller;

import lk.royalBank.dto.SendMoneyDTO;
import lk.royalBank.service.SendMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/sendmoney")
public class SendMoneyController {

    @Autowired
    private SendMoneyService sendMoneyService;
    @GetMapping
    public SendMoneyDTO send(){
        return new SendMoneyDTO();
    }

    @PostMapping
    public void sendMoney(@RequestBody SendMoneyDTO sendMoneyDTO){
        System.out.println(sendMoneyDTO);
        sendMoneyService.SendMoney(sendMoneyDTO);
    }
}
