package jrs.controllers;
import jrs.models.Account;
import jrs.services.AccountService;
import jrs.settings.errors.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.http.MediaType;
@RestController
public class AuthenticationController extends BaseController{
    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

   
 
    @RequestMapping(value="/register", 
            method= RequestMethod.POST, 
            consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> register(@Valid @RequestBody Account account, BindingResult errors){
        if(errors.hasErrors()){
            throw new InvalidRequestException("Username already exists", errors);
        }

        Account createdAccount = accountService.createNewAccount(account);
        return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
    }


}
