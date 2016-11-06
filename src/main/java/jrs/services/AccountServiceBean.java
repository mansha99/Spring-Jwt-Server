package jrs.services;

import jrs.models.Account;
import jrs.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Collection;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceBean implements AccountService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Collection<Account> findAll() {
        Collection<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public Account findByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        return account;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Account createNewAccount(Account account) {
        if (account.getPassword().length() < 8){
            throw new EntityExistsException("password should be greater than 8 characters");
        }
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        return accountRepository.save(account);
    }
}
