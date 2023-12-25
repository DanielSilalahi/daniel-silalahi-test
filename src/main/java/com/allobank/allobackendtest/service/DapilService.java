package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.repository.DapilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// DapilService.java

@Service
public class DapilService {
    @Autowired
    private DapilRepository dapilRepository;

    public Dapil findById(Long dapilId) {
        return dapilRepository.findById(dapilId)
                .orElseThrow(() -> new EntityNotFoundException("Dapil with ID " + dapilId + " not found"));
    }

}
