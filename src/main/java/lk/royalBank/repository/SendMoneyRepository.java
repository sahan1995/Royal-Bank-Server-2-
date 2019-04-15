package lk.royalBank.repository;

import lk.royalBank.entity.SendMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMoneyRepository extends JpaRepository<SendMoney,Integer> {
}
