package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.repository.DapilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DapilServiceTest {

    @Mock
    private DapilRepository dapilRepository;

    @InjectMocks
    private DapilService dapilService;

    @Test
    public void testFindById() {
        Long dapilId = 1L;
        Dapil dapil = new Dapil();
        when(dapilRepository.findById(dapilId)).thenReturn(Optional.of(dapil));

        Dapil result = dapilService.findById(dapilId);

        verify(dapilRepository, times(1)).findById(dapilId);

        assertNotNull(result);
        assertEquals(dapil, result);
    }

    @Test
    public void testFindByIdNotFound() {
        Long dapilId = 1L;
        when(dapilRepository.findById(dapilId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> dapilService.findById(dapilId));

        verify(dapilRepository, times(1)).findById(dapilId);
    }

}
