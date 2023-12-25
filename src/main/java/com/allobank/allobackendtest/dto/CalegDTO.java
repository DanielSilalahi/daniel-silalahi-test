package com.allobank.allobackendtest.dto;

public class CalegDTO {
    private Long id;
    private String nama;
    private Integer nomorUrut;
    private Long partaiId;
    private Long dapilId;

    public CalegDTO() {
    }

    public CalegDTO(Long id, String nama, Integer nomorUrut, Long partaiId, Long dapilId) {
        this.id = id;
        this.nama = nama;
        this.nomorUrut = nomorUrut;
        this.partaiId = partaiId;
        this.dapilId = dapilId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNomorUrut() {
        return nomorUrut;
    }

    public void setNomorUrut(Integer nomorUrut) {
        this.nomorUrut = nomorUrut;
    }

    public Long getPartaiId() {
        return partaiId;
    }

    public void setPartaiId(Long partaiId) {
        this.partaiId = partaiId;
    }

    public Long getDapilId() {
        return dapilId;
    }

    public void setDapilId(Long dapilId) {
        this.dapilId = dapilId;
    }
}
