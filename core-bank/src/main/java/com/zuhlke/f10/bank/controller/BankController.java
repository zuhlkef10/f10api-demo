package com.zuhlke.f10.bank.controller;

import com.zuhlke.f10.bank.model.Bank;
import com.zuhlke.f10.bank.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BankController implements BankApi{

    private static final Logger LOGGER = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankRepository repository;


    @RequestMapping(value = "/banks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<List<Bank>> searchBanks(@RequestParam(value = "name", required = false) String name) {
        Bank bank = new Bank().id("gh.29.uk.x").fullName("uk").shortName("uk");
        this.repository.save(bank);

        List<Bank> banks = this.repository.findAll();
        LOGGER.info("Found {} records in the Database ", banks.size());
        return ResponseEntity.ok().body(banks);
    }

    @RequestMapping(value = "/banks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        if(bank.id() == null){
            bank.id(UUID.randomUUID().toString());
        }
        Bank response = this.repository.save(bank);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/banks", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Bank> updateBank(@RequestBody Bank bank) {
        Bank response = this.repository.save(bank);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/banks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Bank> getBankById(@PathParam(value = "id") String id) {
        Optional<Bank> bank = this.repository.findById(id);
        bank.map(bank1 -> {
            return ResponseEntity.ok().body(bank1);
        });
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/banks/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<String> deleteBankById(@PathVariable(value = "id") String id) {
        this.repository.deleteById(id);
        return ResponseEntity.ok("Success");
    }


}
