package com.aaurzola.bankExample.controller;


import com.aaurzola.bankExample.dto.CustomerBalanceInfoDTO;
import com.aaurzola.bankExample.dto.TransferDTO;
import com.aaurzola.bankExample.model.Customer;
import com.aaurzola.bankExample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/balanceInfo")
    public ResponseEntity<List<CustomerBalanceInfoDTO>> getCustomerBalanceInfo() {
        return new ResponseEntity<>(customerService.findCustomerBalanceInfo(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO) {
        try {
            customerService.transfer(transferDTO);
            return ResponseEntity.ok("Transaccion exitosa");
        } catch (Exception e) {
            return ResponseEntity.ok("Algo fallo en la transaccion: " + e.getMessage());
        }
    }
}
