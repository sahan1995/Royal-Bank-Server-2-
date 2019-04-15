package lk.royalBank.service;

import lk.royalBank.dto.BankAccountDTO;
import lk.royalBank.dto.ClientDTO;

public interface ClientService {

    void addClient(String clientID, ClientDTO clientDTO);
}
