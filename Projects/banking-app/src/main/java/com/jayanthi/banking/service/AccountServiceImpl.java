package com.jayanthi.banking.service;

import com.jayanthi.banking.Mapper.AccountMapper;
import com.jayanthi.banking.dto.AccountDto;
import com.jayanthi.banking.entity.Account;
import com.jayanthi.banking.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private EntityManager entityManager;

//    public AccountServiceImpl(AccountRepository accountRepository){
//        this.accountRepository=accountRepository;
//    }
//    @Autowired
//    private ModelMapper modelMapper;

    @Override
    public AccountDto createAccount(AccountDto accountdto) {
        Account accountAdded = accountRepository.save(accountMapper.maptoAccount(accountdto));
        AccountDto finalaccountdto= accountMapper.maptoAccountDto(accountAdded);
        return finalaccountdto;
    }

    @Override
    public AccountDto getAccoountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account with I d doesn't exists"));
        return accountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto depositByAccoutId(Long accoundId, Double amount) {
        Account account = accountRepository.findById(accoundId).orElseThrow(()->new RuntimeException("Account with I d doesn't exists"));
       accountRepository.updateAccountBalance(accoundId,amount);
       entityManager.clear();
        Account accountUpdated = accountRepository.findById(accoundId).orElseThrow(()->new RuntimeException("Account with I d doesn't exists"));
        return accountMapper.maptoAccountDto(accountUpdated);
    }

    @Override
    @Transactional
    public AccountDto withdrawByAccoutId(Long accoundId, Double amount) {
        Account account = accountRepository.findById(accoundId).orElseThrow(()->new RuntimeException("Account with I d doesn't exists"));
        if(account.getAccountBalance()< amount){
            throw new RuntimeException("Insufficient Balance");
        }
       // instead of calling repository trying an approach using @transactional on method and see whether db is getting updated or not

//        accountRepository.updateAccountBalance(accoundId,-amount);
//        entityManager.clear();

        account.setAccountBalance(account.getAccountBalance()-amount);
//        Account accountUpdated = accountRepository.findById(accoundId).orElseThrow(()->new RuntimeException("Account with I d doesn't exists"));
//        return accountMapper.maptoAccountDto(accountUpdated);
        return accountMapper.maptoAccountDto(account);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        List<AccountDto> accountdtoList = accountList.stream().map(account->accountMapper.maptoAccountDto(account)).collect(Collectors.toList());
        return accountdtoList;
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

}
