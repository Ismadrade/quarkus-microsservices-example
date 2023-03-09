package br.com.ismadrade.core;

import br.com.ismadrade.core.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {

    @Test
    @DisplayName("Should create a costumer")
    void shouldCreateCostumer(){
        Customer customer = new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
        assertEquals(1L, customer.getId());
        assertEquals("Jackson", customer.getName());
        assertEquals("jackson@email.com", customer.getEmail());
        assertEquals("Rua Dom Joaquim, nº 237", customer.getAddress());
        assertEquals(29L, customer.getAge());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer without name")
    void throwExceptionWhenTryingCreateCostumerWithoutName(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Customer(1L, null, "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L));

        assertEquals("O nome é obrigatório!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Customer(1L, " ", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L));

        assertEquals("O nome é obrigatório!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer without address")
    void throwExceptionWhenTryingCreateCostumerWithoutAddress(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Customer(1L, "Jackson", "jackson@email.com", null, 29L));

        assertEquals("O endereço é obrigatório!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Customer(1L, "Jackson", "jackson@email.com", " ", 29L));

        assertEquals("O endereço é obrigatório!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer without age")
    void throwExceptionWhenTryingCreateCostumerWithoutAge(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", null));

        assertEquals("A idade é obrigatória!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer with invalid age")
    void throwExceptionWhenTryingCreateCostumerWithInvalidAge(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", -1L));

        assertEquals("Idade inválida!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 201L));

        assertEquals("Idade inválida!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Should create a costumer with a valid home phone number")
    void shouldCreateCostumerWithValidHomePhoneNumber(){
        Customer customer = new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
        customer.setPhone("4832334241");
        assertEquals(1L, customer.getId());
        assertEquals("Jackson", customer.getName());
        assertEquals("jackson@email.com", customer.getEmail());
        assertEquals("Rua Dom Joaquim, nº 237", customer.getAddress());
        assertEquals(29L, customer.getAge());
        assertEquals(29L, customer.getAge());
        assertEquals("(48) 3233 - 4241", customer.getPhone().getFormattedPhone());
        assertNotNull( customer.getPhone());
    }

    @Test
    @DisplayName("Should create a costumer with a valid cellphone number")
    void shouldCreateCostumerWithValidCellPhoneNumber(){
        Customer customer = new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
        customer.setPhone("51998745656");
        assertEquals(1L, customer.getId());
        assertEquals("Jackson", customer.getName());
        assertEquals("jackson@email.com", customer.getEmail());
        assertEquals("Rua Dom Joaquim, nº 237", customer.getAddress());
        assertEquals(29L, customer.getAge());
        assertEquals(29L, customer.getAge());
        assertEquals("(51) 9 9874 - 5656", customer.getPhone().getFormattedPhone());
        assertNotNull( customer.getPhone());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer with a invalid phone number")
    void throwExceptionWhenTryingCreateCostumerWithInvalidPhoneNumber(){
        Customer customer = new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> customer.setPhone("4823659898"));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> customer.setPhone("48336598983"));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> customer.setPhone("489987654321"));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a phone number costumer with letters and characters")
    void throwExceptionWhenTryingCreatePhoneNumberCostumerWithLettersAndCharacters(){
        Customer customer = new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> customer.setPhone("483323ABCD"));

        assertEquals("O número do telefone deve conter somente números!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> customer.setPhone("&83323!@#$"));

        assertEquals("O número do telefone deve conter somente números!", illegalArgumentException.getMessage());


    }


}
