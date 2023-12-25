package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.PartaiRepository;
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
public class PartaiServiceTest {

    @Mock
    private PartaiRepository partaiRepository;

    @InjectMocks
    private PartaiService partaiService;

    @Test
    public void testFindById() {
        // Mocking repository behavior
        Long partaiId = 1L;
        Partai partai = new Partai();
        when(partaiRepository.findById(partaiId)).thenReturn(Optional.of(partai));

        // Perform the service method
        Partai result = partaiService.findById(partaiId);

        // Verify the interaction
        verify(partaiRepository, times(1)).findById(partaiId);

        // Assert the result
        assertNotNull(result);
        assertEquals(partai, result);
    }

    @Test
    public void testFindByIdNotFound() {
        Long partaiId = 1L;
        when(partaiRepository.findById(partaiId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> partaiService.findById(partaiId));

        verify(partaiRepository, times(1)).findById(partaiId);
    }

}
