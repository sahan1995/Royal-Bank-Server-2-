package lk.royalBank.controller;

import lk.royalBank.dto.WidthdrawDTO;
import lk.royalBank.service.WidthrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/withdraw")
public class WithdrawController {

    @Autowired
    private WidthrawService widthrawService;

    @PostMapping
    public void save(@RequestBody WidthdrawDTO widthdrawDTO){

        widthrawService.widthrawMoney(widthdrawDTO);
    }


    @GetMapping
    public WidthdrawDTO widthdrawDTO(){
        return new WidthdrawDTO();
    }




}
