package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.service.CalegService;
import com.allobank.allobackendtest.service.DapilService;
import com.allobank.allobackendtest.service.PartaiService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/caleg")
public class CalegController {

    private static final Logger logger = LoggerFactory.getLogger(CalegController.class);

    @Autowired
    private CalegService calegService;

    @Autowired
    private DapilService dapilService;

    @Autowired
    private PartaiService partaiService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllCaleg(
            @RequestParam(name = "dapilId", required = false) Long dapilId,
            @RequestParam(name = "partaiId", required = false) Long partaiId,
            @RequestParam(name = "sort", defaultValue = "nomorUrut") String sort) {

        try {
            logger.info("Fetching Caleg data with dapilId={}, partaiId={}, sort={}", dapilId, partaiId, sort);

            Sort sorting = Sort.by(sort);
            Dapil dapil = (dapilId != null) ? dapilService.findById(dapilId) : null;
            Partai partai = (partaiId != null) ? partaiService.findById(partaiId) : null;

            List<Caleg> calegList;

            if (dapil != null && partai != null) {
                calegList = calegService.findByDapilAndPartai(dapil, partai, Sort.by(sort));
            } else if (dapil != null) {
                calegList = calegService.findByDapil(dapil, Sort.by(sort));
            } else if (partai != null) {
                calegList = calegService.findByPartai(partai, Sort.by(sort));
            } else {
                calegList = calegService.getAllCaleg(Sort.by(sort, "nomorUrut"));
            }

            logger.info("CalegList size: {}", calegList.size());

            List<CalegDTO> calegDTOList = new ArrayList<>();

            for (Caleg caleg : calegList) {
                CalegDTO calegDTO = new CalegDTO();
                calegDTO.setId(caleg.getId());
                calegDTO.setNama(caleg.getNama());
                calegDTO.setNomorUrut(caleg.getNomorUrut());
                calegDTO.setPartaiId(caleg.getPartai().getId());
                calegDTO.setDapilId(caleg.getDapil().getId());

                calegDTOList.add(calegDTO);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", calegDTOList);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            logger.error("Entity not found", ex);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Entity not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            logger.error("Internal server error", ex);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

