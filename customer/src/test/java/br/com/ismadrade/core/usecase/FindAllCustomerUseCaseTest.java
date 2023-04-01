package br.com.ismadrade.core.usecase;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.port.CustomerPort;
import br.com.ismadrade.core.usecase.impl.FindAllCustomerUseCaseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindAllCustomerUseCaseTest {

    @Mock
    private final CustomerPort customerPort = mock(CustomerPort.class);

    @InjectMocks
    private final FindAllCustomerUseCase findAllCustomerUseCase = new FindAllCustomerUseCaseImpl(customerPort);


    @Test
    @DisplayName("Should return a costumer list")
    void shouldReturnCustomerList(){
        when(customerPort.findAllCustomers()).thenReturn(mockFindAllCustomersMock());

        List<Customer> customers = findAllCustomerUseCase.execute();

        assertNotNull(customers);
        assertEquals(1, customers.size());

        Customer customer = customers.get(0);
        assertEquals(1L, customer.getId());
        assertEquals("Jackson", customer.getName());
        assertEquals("jackson@email.com", customer.getEmail());
        assertEquals("Rua Dom Joaquim, nº 237", customer.getAddress());
        assertEquals(29L, customer.getAge());

    }

    @Test
    @DisplayName("Should return an empty costumer list")
    void shouldReturnEmptyCustomerList(){
        when(customerPort.findAllCustomers()).thenReturn(new ArrayList<>());

        List<Customer> customers = findAllCustomerUseCase.execute();

        assertNotNull(customers);
        assertEquals(0, customers.size());
    }

    private List<Customer> mockFindAllCustomersMock() {
        return List.of(new Customer(1L, "Jackson", "jackson@email.com", "Rua Dom Joaquim, nº 237", 29L));
    }


}
