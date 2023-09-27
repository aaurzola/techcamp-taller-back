package com.aaurzola.bankExample.dto;

import java.math.BigDecimal;

public interface CustomerBalanceInfoDTO {

    Long getCustomer_Id();
    String getName();
    String getEmail();
    String getAddress();
    String getPhone_Number();
    BigDecimal getTotalBalance();

}
