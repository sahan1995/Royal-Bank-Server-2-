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
import org.springframework.web.client.RestTemplate;

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

        RestTemplate restTemplate = new RestTemplate();
        try{
            restTemplate.put("http://192.168.1.101:8080/api/v1/account/doTransaction/?type=withdraw&accno="+widthdrawDTO.getBankAccountDTO().getAccountNumber()+"&amount="+widthdrawDTO.getAmount(),null);
        }catch (Exception e){
            restTemplate.put("http://192.168.1.101:8083/api/v1/account/doTransaction/?type=withdraw&accno="+widthdrawDTO.getBankAccountDTO().getAccountNumber()+"&amount="+widthdrawDTO.getAmount(),null);
        }



//        To be Implement
    }
}
