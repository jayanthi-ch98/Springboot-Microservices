package com.jayanthi.banking.service;

import com.jayanthi.banking.dto.AccountDto;
import com.jayanthi.banking.entity.Account;

import java.util.List;

public interface AccountService {

    public AccountDto createAccount(AccountDto account);

    public AccountDto getAccoountById(Long id);

    public AccountDto depositByAccoutId(Long accoundId,Double Amount);

    public AccountDto withdrawByAccoutId(Long accoundId,Double Amount);

    public List<AccountDto> getAllAccounts();

    public void deleteAccountById(Long id);
}
