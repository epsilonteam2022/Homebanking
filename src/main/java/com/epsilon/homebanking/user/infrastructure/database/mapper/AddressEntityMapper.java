package com.epsilon.homebanking.user.infrastructure.database.mapper;

import com.epsilon.homebanking.address.domain.Address;
import com.epsilon.homebanking.address.infrastructure.database.entity.AddressEntity;
import com.epsilon.homebanking.common.mapper.EntityBaseMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityMapper extends EntityBaseMapper<AddressEntity, Address> {

  @Override
  public Address toDomain(AddressEntity entity, Object... args) {
    if (entity == null) {
      return null;
    }
    return Address.builder()
        .addressId(entity.getAddressId())
        .city(entity.getCity())
        .zipCode(entity.getZipCode())
        .street(entity.getStreet())
        .build();
  }

  @Override
  public AddressEntity toEntity(Address domain, Object... args) {
    if (domain == null) {
      return null;
    }
    return AddressEntity.builder()
        .addressId(domain.getAddressId())
        .city(domain.getCity())
        .zipCode(domain.getZipCode())
        .street(domain.getStreet())
        .build();
  }
}
