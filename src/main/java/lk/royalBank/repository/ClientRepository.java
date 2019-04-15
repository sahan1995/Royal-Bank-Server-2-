package lk.royalBank.repository;

import lk.royalBank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
}
