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
public class OrderDto {

    private Long customerId;

    private String customerName;

    private Long productId;

    private BigDecimal orderValue;
}
