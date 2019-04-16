package lk.royalBank.service;

import lk.royalBank.dto.DepositDTO;

import java.io.IOException;
import java.net.MalformedURLException;

public interface DepositService {

    void depositMoney(DepositDTO depositDTO);

}
