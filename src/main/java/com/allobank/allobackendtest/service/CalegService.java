package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.CalegRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalegService {
    @Autowired
    private CalegRepository calegRepository;

    public List<Caleg> getAllCaleg(Sort sort) {
        return calegRepository.findAll(sort);
    }

    public List<Caleg> findByDapilAndPartai(Dapil dapil, Partai partai, Sort sort) {
        return calegRepository.findByDapilAndPartai(dapil, partai, sort);
    }

    public List<Caleg> findByDapil(Dapil dapil, Sort sort) {
        return calegRepository.findByDapil(dapil, sort);
    }

    public List<Caleg> findByPartai(Partai partai, Sort sort) {
        return calegRepository.findByPartai(partai, sort);
    }

    public Caleg findById(Long calegId) {
        return calegRepository.findById(calegId)
                .orElseThrow(() -> new EntityNotFoundException("Caleg with ID " + calegId + " not found"));
    }


}
