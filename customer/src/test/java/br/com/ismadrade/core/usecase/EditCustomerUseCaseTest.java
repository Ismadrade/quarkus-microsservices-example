package br.com.ismadrade.core.usecase;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.impl.EditCustomerUseCaseImpl;
import br.com.ismadrade.core.usecase.parameter.EditCustomerParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditCustomerUseCaseTest {

    @Mock
    private final CustomerPort customerPort = mock(CustomerPort.class);

    @InjectMocks
    private final EditCustomerUseCase editCustomerUseCase = new EditCustomerUseCaseImpl(customerPort);


    @Test
    @DisplayName("Should edit a costumer")
    void shouldEditCustomer(){
        when(customerPort.changeCustomer(any(Customer.class))).thenReturn(mockEditCustomersMock());

        EditCustomerParameters parameters = new EditCustomerParameters(1L, "Jackson Edited", "48984554545", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L);

        Customer customer = editCustomerUseCase.execute(parameters);
        assertEquals(parameters.getName(), customer.getName());
        assertEquals(parameters.getEmail(), customer.getEmail());
        assertEquals(parameters.getAddress(), customer.getAddress());
        assertEquals(parameters.getAge(), customer.getAge());
        assertEquals("(48) 9 8455 - 4545", customer.getPhone().getFormattedPhone());

    }

    @Test
    @DisplayName("Throw exception when trying to edit a costumer without name")
    void throwExceptionWhenTryingEditCostumerWithoutName(){

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, null, "48984554545", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L)));

        assertEquals("O nome é obrigatório!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "", "48984554545", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L)));

        assertEquals("O nome é obrigatório!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to edit a costumer without address")
    void throwExceptionWhenTryingEditCostumerWithoutAddress(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "48984554545", "jackson@gemail.com", null, 30L)));

        assertEquals("O endereço é obrigatório!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "48984554545", "jackson@gemail.com", "", 30L)));

        assertEquals("O endereço é obrigatório!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to edit a costumer without age")
    void throwExceptionWhenTryingEditCostumerWithoutAge(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "48984554545", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", null)));

        assertEquals("A idade é obrigatória!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to edit a costumer with invalid age")
    void throwExceptionWhenTryingEditCostumerWithInvalidAge(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "48984554545", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", -1L)));

        assertEquals("Idade inválida!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "48984554545", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 201L)));

        assertEquals("Idade inválida!", illegalArgumentException.getMessage());
    }



    @Test
    @DisplayName("Throw exception when trying to edit a costumer with a invalid phone number")
    void throwExceptionWhenTryingEditCostumerWithInvalidPhoneNumber(){

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "4823659898", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L)));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "48336598983", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L)));


        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "489987654321", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L)));

        assertEquals("O número de telefone é inválido!", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Throw exception when trying to edit a phone number costumer with letters and characters")
    void throwExceptionWhenTryingEditPhoneNumberCostumerWithLettersAndCharacters(){

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "483323ABCD", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L)));

        assertEquals("O número do telefone deve conter somente números!", illegalArgumentException.getMessage());

        illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> editCustomerUseCase.execute(new EditCustomerParameters(1L, "Jackson Edited", "&83323!@#$", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L)));

        assertEquals("O número do telefone deve conter somente números!", illegalArgumentException.getMessage());


    }

    private Customer mockEditCustomersMock() {
        Customer customerEdited = new Customer(1L, "Jackson Edited", "jackson@gemail.com", "Rua Dom Joaquim editado, nº 237", 30L);
        customerEdited.setPhone("48984554545");
        return customerEdited;
    }


}
