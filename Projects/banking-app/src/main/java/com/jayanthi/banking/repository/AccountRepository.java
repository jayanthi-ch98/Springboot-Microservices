package com.jayanthi.banking.repository;

import com.jayanthi.banking.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query("update account a SET a.accountBalance = a.accountBalance + :balance where a.id = :id")
    @Transactional
    public void updateAccountBalance(@Param("id") Long id, @Param("balance")Double balance);
}
