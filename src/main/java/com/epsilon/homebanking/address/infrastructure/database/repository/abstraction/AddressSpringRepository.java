package com.epsilon.homebanking.address.infrastructure.database.repository.abstraction;

import com.epsilon.homebanking.address.infrastructure.database.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressSpringRepository extends JpaRepository<AddressEntity, Long> {

}
