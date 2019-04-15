package lk.royalBank.service.impl;

import lk.royalBank.dto.BankAccountDTO;
import lk.royalBank.dto.ClientDTO;
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
}
