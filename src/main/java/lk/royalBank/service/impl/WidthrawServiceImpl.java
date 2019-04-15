package lk.royalBank.service.impl;

import lk.royalBank.dto.WidthdrawDTO;
import lk.royalBank.entity.BankAccount;
import lk.royalBank.entity.Withdraw;
import lk.royalBank.repository.WidthdrawRepository;
import lk.royalBank.service.WidthrawService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WidthrawServiceImpl implements WidthrawService {

    @Autowired
    private WidthdrawRepository widthdrawRepository;
    @Override
    public void widthrawMoney(WidthdrawDTO widthdrawDTO) {
        Withdraw widthdraw = new Withdraw();
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(widthdrawDTO, widthdraw);
        BeanUtils.copyProperties(widthdrawDTO.getBankAccountDTO(),bankAccount);
        widthdraw.setBankAccount(bankAccount);

        widthdrawRepository.save(widthdraw);

//        To be Implement
    }
}
