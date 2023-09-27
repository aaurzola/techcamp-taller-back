package com.aaurzola.bankExample.repository;

import com.aaurzola.bankExample.dto.CustomerBalanceInfoDTO;
import com.aaurzola.bankExample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Modifying
    @Query(value = "DELETE FROM TECHCAMP.CUSTOMER cu WHERE cu.CUSTOMER_ID = :customerId", nativeQuery = true)
    void bankDelete(@Param("customerId") Long customerId);

    @Query(value = "SELECT c.CUSTOMER_ID, c.NAME, c.EMAIL, c.ADDRESS, c.PHONE_NUMBER, A.\"totalBalance\" FROM TECHCAMP.CUSTOMER c\n" +
            "LEFT JOIN (SELECT a.OWNER_ID, SUM(a.balance) AS \"totalBalance\" FROM TECHCAMP.ACCOUNT a GROUP BY a.OWNER_ID) A\n" +
            "ON c.CUSTOMER_ID = a.OWNER_ID", nativeQuery = true)
    List<CustomerBalanceInfoDTO> findCustomerBalanceInfo();


    @Procedure(procedureName = "CUSTOMER_OPERATIONS.TRANSFER")
    void transfer(Long source,
                  Long destination,
                  BigDecimal amount
    );

}
