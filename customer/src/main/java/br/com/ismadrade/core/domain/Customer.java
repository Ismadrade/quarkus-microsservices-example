package br.com.ismadrade.core.domain;

import java.io.Serializable;

public class Customer implements Serializable {

    private final Long id;
    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final Long age;

    public Customer(Long id, String name, String phone, String email, String address, Long age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
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
}
