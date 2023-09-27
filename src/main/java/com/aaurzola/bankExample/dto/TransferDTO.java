package com.aaurzola.bankExample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO {
    private Long sourceAccount;
    private Long destinationAccount;
    private BigDecimal amount;
}
