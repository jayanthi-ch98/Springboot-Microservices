package com.jayanthi.banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="account")
@Table(name="account",schema="banking_app")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name="account_holder_name")
    private String accountHolderName;
    @Column(name="account_balance")
    private double accountBalance;
}
