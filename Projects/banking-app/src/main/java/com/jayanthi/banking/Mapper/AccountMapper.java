package com.jayanthi.banking.Mapper;

import com.jayanthi.banking.dto.AccountDto;
import com.jayanthi.banking.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account maptoAccount(AccountDto accountdto){
        Account account = new Account(accountdto.id(), accountdto.accountHolderName(), accountdto.accountBalance());
        return account;
    }
    public AccountDto maptoAccountDto(Account account){
        AccountDto accountdto  = new AccountDto(account.getId(), account.getAccountHolderName(), account.getAccountBalance());
        return accountdto;
    }
}
