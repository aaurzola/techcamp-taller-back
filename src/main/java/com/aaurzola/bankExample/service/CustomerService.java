package com.aaurzola.bankExample.service;

import com.aaurzola.bankExample.dto.CustomerBalanceInfoDTO;
import com.aaurzola.bankExample.dto.TransferDTO;
import com.aaurzola.bankExample.model.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();
    List<CustomerBalanceInfoDTO> findCustomerBalanceInfo();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    void transfer(TransferDTO transferDTO);
}
