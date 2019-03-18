package lk.royalBank.repository;

import lk.royalBank.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit,Integer> {
}
