package br.com.ismadrade.entrypoints.mapper;

import br.com.ismadrade.core.domain.Customer;
import br.com.ismadrade.core.domain.vo.Phone;
import br.com.ismadrade.entrypoints.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    @Mapping(source = "phone", target = "phone", qualifiedByName = "phoneToString")
    CustomerDto of(Customer customer);

    List<CustomerDto> of(List<Customer> products);

    @Named("phoneToString")
    default String phoneToString(Phone phone){
        return phone.getFormattedPhone();
    }


}
