package com.jayanthi.banking.controller;

import com.jayanthi.banking.dto.AccountDto;
import com.jayanthi.banking.service.AccountService;
import com.jayanthi.banking.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

//    public AccountController(AccountService accountService){
//        this.accountService= accountService;
//    }

    @PostMapping
    private ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountdto){
        AccountDto createdaccountdto = accountService.createAccount(accountdto);
        return new ResponseEntity<>(createdaccountdto, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    private ResponseEntity<AccountDto> createAccount(@PathVariable("id") Long accountId){
        AccountDto accountdto = accountService.getAccoountById(accountId);
        return  ResponseEntity.ok(accountdto);
    }
    @PutMapping("deposit/{id}")
    private ResponseEntity<AccountDto> depositAmountById(@PathVariable("id") Long accountId,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto accountdto = accountService.depositByAccoutId(accountId,amount);
        return  ResponseEntity.ok(accountdto);
    }
    @PutMapping("withdraw/{id}")
    private ResponseEntity<AccountDto> withdrawAmountById(@PathVariable("id") Long accountId,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto accountdto = accountService.withdrawByAccoutId(accountId,amount);
        return  ResponseEntity.ok(accountdto);
    }
    @GetMapping
    private ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountdtolist = accountService.getAllAccounts();
        return  ResponseEntity.ok(accountdtolist);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<String> deleteAccountById(@PathVariable Long id){
       accountService.deleteAccountById(id);
        return  ResponseEntity.ok("Account Deleted Successfully");
    }
}
