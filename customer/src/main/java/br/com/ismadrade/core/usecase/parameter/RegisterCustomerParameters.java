package br.com.ismadrade.core.usecase.parameter;

public class RegisterCustomerParameters {

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final Long age;

    public RegisterCustomerParameters(String name, String phone, String email, String address, Long age) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.age = age;
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
