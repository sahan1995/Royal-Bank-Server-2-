package lk.royalBank.service.impl;

import lk.royalBank.dto.DepositDTO;
import lk.royalBank.service.DepositService;
import org.json.HTTP;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepositServiceImpl implements DepositService {

    @Override
    public void depositMoney(DepositDTO depositDTO) {

    }
}
