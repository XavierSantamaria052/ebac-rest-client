package com.ebac.modulo44.dto;

public class Telefono {

    private Long id;
    private String number;
    private String cityCode;

    public Telefono() {
    }

    public Telefono(Long id, String number, String cityCode) {
        this.id = id;
        this.number = number;
        this.cityCode = cityCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}