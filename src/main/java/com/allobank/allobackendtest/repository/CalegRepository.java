package com.allobank.allobackendtest.repository;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalegRepository extends JpaRepository<Caleg, Long> {
    List<Caleg> findByDapilAndPartai(Dapil dapil, Partai partai, Sort sort);

    List<Caleg> findByDapil(Dapil dapil, Sort sort);

    List<Caleg> findByPartai(Partai partai, Sort sort);

}