package com.aaurzola.bankExample.service;

import com.aaurzola.bankExample.dto.CustomerBalanceInfoDTO;
import com.aaurzola.bankExample.dto.TransferDTO;
import com.aaurzola.bankExample.exception.ResourceNotFountException;
import com.aaurzola.bankExample.model.Customer;
import com.aaurzola.bankExample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerBalanceInfoDTO> findCustomerBalanceInfo() {
        return customerRepository.findCustomerBalanceInfo();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getCustomerId()).orElseThrow(
                () ->  new ResourceNotFountException("No existe cliente con id: " + customer.getCustomerId())
        );
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long customerId) {
        customerRepository.bankDelete(customerId);
    }

    @Override
    public void transfer(TransferDTO transferDTO) {
        customerRepository.transfer(transferDTO.getSourceAccount(), transferDTO.getDestinationAccount(), transferDTO.getAmount());
    }
}
