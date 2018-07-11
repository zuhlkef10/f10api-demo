package com.zuhlke.f10.bank.controller;

import com.zuhlke.f10.bank.model.Bank;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

public interface BankApi {

    @RequestMapping(value = "/banks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Bank>> searchBanks(@RequestParam(value = "name", required = false) String name);

    @RequestMapping(value = "/banks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Bank> createBank(@RequestBody Bank bank);

    @RequestMapping(value = "/banks", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Bank> updateBank(@RequestBody Bank bank);

    @RequestMapping(value = "/banks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Bank> getBankById(@PathParam(value = "id") String id);

    @RequestMapping(value = "/banks/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteBankById(@PathParam(value = "id") String id);


}
