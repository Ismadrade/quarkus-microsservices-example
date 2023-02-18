package br.com.ismadrade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class ProductDto {

    private String name;
    private String description;
    private String category;
    private String model;
    private BigDecimal price;
}
