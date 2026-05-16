package com.examen.ms_productos.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductoResponseDTO {
	private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
}
