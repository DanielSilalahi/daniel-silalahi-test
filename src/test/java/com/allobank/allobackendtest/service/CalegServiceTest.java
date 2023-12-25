package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.CalegRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalegServiceTest {

    @Mock
    private CalegRepository calegRepository;

    @InjectMocks
    private CalegService calegService;

    @Test
    public void testGetAllCaleg() {
        when(calegRepository.findAll(Sort.unsorted())).thenReturn(Collections.emptyList());

        List<Caleg> result = calegService.getAllCaleg(Sort.unsorted());

        verify(calegRepository, times(1)).findAll(Sort.unsorted());

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindByDapilAndPartai() {
        Dapil dapil = new Dapil();
        Partai partai = new Partai();
        when(calegRepository.findByDapilAndPartai(dapil, partai, Sort.unsorted())).thenReturn(Collections.emptyList());

        List<Caleg> result = calegService.findByDapilAndPartai(dapil, partai, Sort.unsorted());

        verify(calegRepository, times(1)).findByDapilAndPartai(dapil, partai, Sort.unsorted());

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindById() {
        Long calegId = 1L;
        Caleg caleg = new Caleg();
        when(calegRepository.findById(calegId)).thenReturn(Optional.of(caleg));

        Caleg result = calegService.findById(calegId);

        verify(calegRepository, times(1)).findById(calegId);

        assertEquals(caleg, result);
    }

}
