package lk.royalBank.service.impl;

import lk.royalBank.dto.BankAccountDTO;
import lk.royalBank.dto.ClientDTO;
import lk.royalBank.entity.BankAccount;
import lk.royalBank.entity.Branch;
import lk.royalBank.entity.Client;
import lk.royalBank.entity.Employee;
import lk.royalBank.repository.ClientRepository;
import lk.royalBank.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
//    @Autowired
//    BankAccountService bankAccountService;
    @Override
    public void addClient(String clientID, ClientDTO clientDTO) {
        if(!clientID.equals(clientDTO.getClientID())){
            throw new RuntimeException("ID's are Not Same");
        }
        System.out.println("Client ");
        Client client = new Client();
        Branch branch = new Branch();
        Employee employee = new Employee();
        BeanUtils.copyProperties(clientDTO,client);
        BeanUtils.copyProperties(clientDTO.getBranchDTO(),branch);
        BeanUtils.copyProperties(clientDTO.getEmployeeDTO(),employee);
        client.setBranch(branch);
        client.setEmployee(employee);
        System.out.println(client);
        clientRepository.save(client);


    }

    @Override
    public ClientDTO findByID(String clientID) {
        if(clientRepository.findById(clientID).isPresent()){
            Client client = clientRepository.findById(clientID).get();
            ClientDTO clientDTO = new ClientDTO();
            List<BankAccount> bankAccounts = client.getBankAccounts();
            List<BankAccountDTO> accountDTOS = new ArrayList<>();

            bankAccounts.forEach(acc->{
                BankAccountDTO bankAccountDTO = new BankAccountDTO();
                BeanUtils.copyProperties(acc,bankAccountDTO);
                accountDTOS.add(bankAccountDTO);
            });
            BeanUtils.copyProperties(client,clientDTO);
            clientDTO.setBankAccountDTOS(accountDTOS);
            return clientDTO;
        }
        throw new RuntimeException("User Not Found ");
    }
}
