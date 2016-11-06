package jrs.services;
import jrs.models.Account;
import java.util.Collection;
public interface AccountService {
    Collection<Account> findAll();
    Account findByUsername(String userename);
    Account createNewAccount(Account account);

}
