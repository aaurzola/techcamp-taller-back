package com.aaurzola.bankExample.controller;

import com.aaurzola.bankExample.model.Transfer;
import com.aaurzola.bankExample.service.transfer.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transferLog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransferController {


    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public ResponseEntity<List<Transfer>> getTransferHistory () {
        return ResponseEntity.ok(transferService.getAllTransferhistory());
    }

}
