package br.com.ismadrade.core.domain;

import br.com.ismadrade.core.domain.vo.Phone;

import java.io.Serializable;

public class Customer implements Serializable {

    private final Long id;
    private final String name;
    private Phone phone;
    private final String email;
    private final String address;
    private final Long age;

    public Customer(Long id, String name, String email, String address, Long age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.age = age;
        this.validate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Long getAge() {
        return age;
    }

    public void setPhone(String phone){
        this.phone = new Phone(phone);
    }

    private void validate(){
        if(name == null || name.trim().equals(""))
            throw new IllegalArgumentException("O nome é obrigatório!");

        if(address == null || address.trim().equals(""))
            throw new IllegalArgumentException("O endereço é obrigatório!");

        if(age == null)
            throw new IllegalArgumentException("A idade é obrigatória!");

        if(age < 0 || age > 200)
            throw new IllegalArgumentException("Idade inválida!");


    }
}
