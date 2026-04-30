package com.ebac.modulo44.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {

    private Long id;
    private String nombre;
    private int edad;

}