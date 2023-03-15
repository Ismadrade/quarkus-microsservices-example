package br.com.ismadrade.core.usecase;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.impl.FindAllCustomerUseCaseImpl;
import br.com.ismadrade.core.usecase.impl.RegisterCustomerUseCaseImpl;
import br.com.ismadrade.core.usecase.parameter.RegisterCustomerParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegisterCustomerUseCaseTest {

    @Mock
    private final CustomerPort customerPort = mock(CustomerPort.class);

    @InjectMocks
    private final RegisterCustomerUseCase registerCustomerUseCase = new RegisterCustomerUseCaseImpl(customerPort);


    @Test
    @DisplayName("Should create a costumer")
    void shouldCreateCustomer(){
        when(customerPort.createNewCustomer(any(Customer.class))).thenReturn(mockCreateCustomersMock());

        RegisterCustomerParameters parameters = new RegisterCustomerParameters("Jackson", null, "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);

        Customer customer = registerCustomerUseCase.execute(parameters);
        assertNotNull(customer.getId());
        assertEquals(1L, customer.getId());
        assertEquals("Jackson", customer.getName());
        assertEquals("jackson@email.com", customer.getEmail());
        assertEquals("Rua Dom Joaquim, nº 237", customer.getAddress());
        assertEquals(29L, customer.getAge());
        assertNull(customer.getPhone());

    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer without name")
    void throwExceptionWhenTryingCreateCostumerWithoutName(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters(null, null, "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L)));

        assertEquals("O nome é obrigatório!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters(" ", null, "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L)));

        assertEquals("O nome é obrigatório!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer without address")
    void throwExceptionWhenTryingCreateCostumerWithoutAddress(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", null,  "jackson@email.com", null, 29L)));

        assertEquals("O endereço é obrigatório!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", null,  "jackson@email.com", " ", 29L)));

        assertEquals("O endereço é obrigatório!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer without age")
    void throwExceptionWhenTryingCreateCostumerWithoutAge(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", null, "jackson@email.com", "Rua Dom Joaquim, nº 237", null)));

        assertEquals("A idade é obrigatória!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a costumer with invalid age")
    void throwExceptionWhenTryingCreateCostumerWithInvalidAge(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", null, "jackson@email.com", "Rua Dom Joaquim, nº 237", -1L)));

        assertEquals("Idade inválida!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", null, "jackson@email.com", "Rua Dom Joaquim, nº 237", 201L)));

        assertEquals("Idade inválida!", illegalArgumentException.getMessage());
    }



    @Test
    @DisplayName("Throw exception when trying to create a costumer with a invalid phone number")
    void throwExceptionWhenTryingCreateCostumerWithInvalidPhoneNumber(){
        Customer customer = new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", "4823659898", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L)));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", "48336598983", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L)));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", "489987654321", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L)));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to create a phone number costumer with letters and characters")
    void throwExceptionWhenTryingCreatePhoneNumberCostumerWithLettersAndCharacters(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", "483323ABCD", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L)));

        assertEquals("O número do telefone deve conter somente números!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> registerCustomerUseCase.execute(new RegisterCustomerParameters("Jackson", "&83323!@#$", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L)));

        assertEquals("O número do telefone deve conter somente números!", illegalArgumentException.getMessage());


    }

    private Customer mockCreateCustomersMock() {
        return new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
    }


}
