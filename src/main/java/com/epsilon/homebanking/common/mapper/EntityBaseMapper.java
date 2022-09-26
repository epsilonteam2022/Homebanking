package com.epsilon.homebanking.common.mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class EntityBaseMapper<E, D> {

  public abstract D toDomain(E entity, Object... args);

  public Collection<D> toDomain(Collection<E> entity, Object... args) {
    if (entity == null) {
      return null;
    }
    return entity.stream().map(e -> toDomain(e, args)).collect(Collectors.toList());
  }

  public abstract E toEntity(D domain, Object... args);

  public Collection<E> toEntity(Collection<D> domain, Object... args) {
    if (domain == null) {
      return null;
    }
    return domain.stream().map(d -> toEntity(d, args)).collect(Collectors.toList());
  }

  public Set<E> toEntitySet(Collection<D> domain, Object... args) {
    if (domain == null) {
      return null;
    }
    return new HashSet<>(toEntity(domain, args));
  }

  public Set<D> toDomainSet(Collection<E> entity, Object... args) {
    if (entity == null) {
      return null;
    }
    return new HashSet<>(toDomain(entity, args));
  }
}
