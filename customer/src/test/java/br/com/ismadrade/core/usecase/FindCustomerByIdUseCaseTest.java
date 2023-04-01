package br.com.ismadrade.core.usecase;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindCustomerByIdUseCaseTest {


    @Mock
    private final CustomerPort customerPort = mock(CustomerPort.class);

    @InjectMocks
    private final FindCustomerByIdUseCase findCustomerByIdUseCase = new FindCustomerByIdUseCaseImpl(customerPort);


    @Test
    @DisplayName("Should return a costumer")
    void shouldReturnCustomer(){
        when(customerPort.findCustomerById(anyLong())).thenReturn(mockFindCustomerById());

        Customer customer = findCustomerByIdUseCase.execute(1L);

        assertNotNull(customer);

        assertEquals(1L, customer.getId());
        assertEquals("Jackson", customer.getName());
        assertEquals("jackson@email.com", customer.getEmail());
        assertEquals("Rua Dom Joaquim, nº 237", customer.getAddress());
        assertEquals(29L, customer.getAge());

    }


    private Customer mockFindCustomerById() {
        return new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L);
    }
}
