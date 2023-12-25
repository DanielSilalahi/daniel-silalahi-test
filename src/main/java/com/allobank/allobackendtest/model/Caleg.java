package com.allobank.allobackendtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Caleg {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("nomor_urut")
    private Integer nomorUrut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partai_id")
    @JsonProperty("partai_id")
    private Partai partai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dapil_id")
    @JsonProperty("dapil_id")
    private Dapil dapil;

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Integer getNomorUrut() {
        return nomorUrut;
    }


    public Partai getPartai() {
        return partai;
    }

    public Dapil getDapil() {
        return dapil;
    }
}