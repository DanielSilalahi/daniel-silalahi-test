package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.PartaiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// PartaiService.java

@Service
public class PartaiService {
    @Autowired
    private PartaiRepository partaiRepository;

    public Partai findById(Long partaiId) {
        return partaiRepository.findById(partaiId)
                .orElseThrow(() -> new EntityNotFoundException("Partai with ID " + partaiId + " not found"));
    }

}
