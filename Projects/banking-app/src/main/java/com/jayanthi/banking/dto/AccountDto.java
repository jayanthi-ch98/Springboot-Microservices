package com.jayanthi.banking.dto;
//
//import jakarta.persistence.Column;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double accountBalance;
//}

public record AccountDto(Long id,String accountHolderName,double accountBalance) {
}