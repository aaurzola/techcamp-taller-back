package com.aaurzola.bankExample.service.transfer;

import com.aaurzola.bankExample.model.Transfer;
import com.aaurzola.bankExample.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImp implements TransferService{

    private final TransferRepository transferRepository;


    @Autowired
    public TransferServiceImp(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public List<Transfer> getAllTransferhistory() {
        return transferRepository.findAll();
    }
}
