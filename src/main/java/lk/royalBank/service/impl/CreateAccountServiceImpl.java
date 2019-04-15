package lk.royalBank.service.impl;

import lk.royalBank.dto.BankAccountDTO;
import lk.royalBank.dto.ClientDTO;
import lk.royalBank.dto.CreateAccountDTO;
import lk.royalBank.dto.UserDTO;
import lk.royalBank.repository.ClientRepository;
import lk.royalBank.service.ClientService;
import lk.royalBank.service.CreateAccountService;
import lk.royalBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateAccountServiceImpl implements CreateAccountService {
    @Autowired
    ClientService  clientService;

    @Autowired
    private UserService userService;

    private ClientRepository clientRepository;
    @Override
    public void createAccount(CreateAccountDTO createAccountDTO) {


        ClientDTO clientDTO = createAccountDTO.getClientDTO();
        clientService.addClient(clientDTO.getClientID(),clientDTO);
        UserDTO userDTO = new UserDTO(clientDTO.getUserName(),clientDTO.getPassword(),"Client",clientDTO.getClientID());
        userService.addUser(clientDTO.getUserName(),userDTO);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://192.168.1.101:8083/api/v1/account/"+createAccountDTO.getBankAccountDTO().getAccountNumber(),createAccountDTO.getBankAccountDTO(),null);
    }
}
