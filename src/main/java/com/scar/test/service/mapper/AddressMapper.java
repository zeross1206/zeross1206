package com.scar.test.service.mapper;

import com.scar.test.domain.Address;
import com.scar.test.service.dto.AddressDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {}
