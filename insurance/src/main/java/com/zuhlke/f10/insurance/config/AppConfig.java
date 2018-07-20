package com.zuhlke.f10.insurance.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppConfig {

    @Value("${api.bank.url}")
    private String bankUrl;

    @Value("${payee.account.number}")
    private String payeeAccountNumber;

    @Value("${payee.account.name}")
    private String payeeAccountName;

    @Value("${payee.account.currency}")
    private String payeeAccountCurrency;

}
