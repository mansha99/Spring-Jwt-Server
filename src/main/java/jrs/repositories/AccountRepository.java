package jrs.repositories;

import jrs.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //@Query("SELECT a FROM account a WHERE a.username = :username")
    Account findByUsername(@Param("username") String username);

}