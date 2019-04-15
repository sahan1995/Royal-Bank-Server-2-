package lk.royalBank.service.impl;

import lk.royalBank.dto.SendMoneyDTO;
import lk.royalBank.entity.BankAccount;
import lk.royalBank.entity.SendMoney;
import lk.royalBank.repository.SendMoneyRepository;
import lk.royalBank.service.SendMoneyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SendMoneyServiceImpl implements SendMoneyService {

    @Autowired
    private SendMoneyRepository sendMoneyRepository;

    @Override
    public void SendMoney(SendMoneyDTO sendMoneyDTO) {

        SendMoney sendMoney = new SendMoney();
        BankAccount bankAccount = new BankAccount();

        BeanUtils.copyProperties(sendMoneyDTO,sendMoney);
        BeanUtils.copyProperties(sendMoneyDTO.getBankAccountDTO(),bankAccount);
        sendMoney.setBankAccount(bankAccount);

        sendMoneyRepository.save(sendMoney);

//                To be Implement

    }
}
