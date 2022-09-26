package com.epsilon.homebanking.common.mapper;

public abstract class RestBaseMapper<E, D, R> {

  public abstract D toDomain(E request, Object... args);

  public abstract R toResponse(D domain, Object... args);
}
