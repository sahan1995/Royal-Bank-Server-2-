package lk.royalBank.controller;

import lk.royalBank.dto.ClientDTO;
import lk.royalBank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/clients")
public class ClientController {


    @Autowired
    private ClientService clientService;



    @GetMapping(value = "/{ID}")
    public ClientDTO findByID(@PathVariable("ID") String clientID){
        return  clientService.findByID(clientID);
    }
}
