package br.com.ismadrade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class CustomerDto {

    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;

}
