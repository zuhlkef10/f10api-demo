package com.zuhlke.f10.account.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuhlke.f10.account.model.Account;
import com.zuhlke.f10.account.model.CrAccount;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AccountService {


    public Account getAccountById(String bankId, String accountId){
        ObjectMapper mapper = new ObjectMapper();

        Account account=null;
        try {
            String jsonInString="{\n" +
                    "  \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "  \"bank_id\":\"String\",\n" +
                    "  \"label\":\"String\",\n" +
                    "  \"number\":\"String\",\n" +
                    "  \"owners\":[{\n" +
                    "    \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "    \"provider\":\"OBP\",\n" +
                    "    \"display_name\":\"OBP\"\n" +
                    "  }],\n" +
                    "  \"type\":\"String\",\n" +
                    "  \"balance\":{\n" +
                    "    \"currency\":\"EUR\",\n" +
                    "    \"amount\":\"10\"\n" +
                    "  },\n" +
                    "  \"account_routings\":[{\n" +
                    "    \"scheme\":\"AccountNumber\",\n" +
                    "    \"address\":\"4930396\"\n" +
                    "  }],\n" +
                    "  \"account_rules\":[{\n" +
                    "    \"scheme\":\"OVERDRAFT\",\n" +
                    "    \"value\":\"10\"\n" +
                    "  }]\n" +
                    "}\n";
            account = mapper.readValue(jsonInString, Account.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }

    public CrAccount create(CrAccount crAccount) {

        return crAccount;

    }
}
