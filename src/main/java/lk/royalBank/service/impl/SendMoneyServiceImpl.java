package lk.royalBank.service.impl;

import lk.royalBank.dto.BankAccountDTO;
import lk.royalBank.dto.DepositDTO;
import lk.royalBank.dto.SendMoneyDTO;
import lk.royalBank.dto.WidthdrawDTO;
import lk.royalBank.entity.BankAccount;
import lk.royalBank.entity.SendMoney;
import lk.royalBank.repository.SendMoneyRepository;
import lk.royalBank.service.DepositService;
import lk.royalBank.service.SendMoneyService;
import lk.royalBank.service.WidthrawService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
//@Transactional
public class SendMoneyServiceImpl implements SendMoneyService {

    @Autowired
    private SendMoneyRepository sendMoneyRepository;

    @Autowired
    private WidthrawService widthrawService;

    @Autowired
    private DepositService depositService;
    @Override
    public void SendMoney(SendMoneyDTO sendMoneyDTO) {

        SendMoney sendMoney = new SendMoney();
        BankAccount bankAccount = new BankAccount();

        BeanUtils.copyProperties(sendMoneyDTO,sendMoney);
        BeanUtils.copyProperties(sendMoneyDTO.getBankAccountDTO(),bankAccount);
        sendMoney.setBankAccount(bankAccount);
        sendMoneyRepository.save(sendMoney);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateandtime = formatter.format(date);
        String name = sendMoneyDTO.getBankAccountDTO().getClientDTO().getFname()+" "+sendMoneyDTO.getBankAccountDTO().getClientDTO().getLname();
        WidthdrawDTO withdrawDTO = new WidthdrawDTO(dateandtime, sendMoneyDTO.getAmount(), "Send Transaction Withdraw", name);
        withdrawDTO.setBankAccountDTO(sendMoneyDTO.getBankAccountDTO());
        widthrawService.widthrawMoney(withdrawDTO);

        RestTemplate restTemplate = new RestTemplate();
        try {

            BankAccountDTO bankAccountDTO = restTemplate.getForEntity("http://192.168.1.101:8080/api/v1/account/" + sendMoneyDTO.getDepositAccount(), BankAccountDTO.class).getBody();
            DepositDTO depositDTO = new DepositDTO(dateandtime, sendMoneyDTO.getAmount(), name, "Send Transaction Deposit");
            depositDTO.setBankAccountDTO(bankAccountDTO);
            depositService.depositMoney(depositDTO);


        }catch (Exception e){

            BankAccountDTO bankAccountDTO = restTemplate.getForEntity("http://192.168.1.101:8083/api/v1/account/" + sendMoneyDTO.getDepositAccount(), BankAccountDTO.class).getBody();
            DepositDTO depositDTO = new DepositDTO(dateandtime, sendMoneyDTO.getAmount(), name, "Send Transaction Deposit");
            depositDTO.setBankAccountDTO(bankAccountDTO);
            depositService.depositMoney(depositDTO);


        }


//                To be Implement

    }
}
