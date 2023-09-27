package com.aaurzola.bankExample.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TRANSFER")
public class Transfer {

    @Id
    @Basic(optional = false)
    @Column(name = "TRANSFER_ID")
    private Long transferId;
    @Basic(optional = false)
    @Column(name = "TRANSFER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "DESTINATION")
    private Long destination;

    @Column(name = "SOURCE")
    private Long source;

}
