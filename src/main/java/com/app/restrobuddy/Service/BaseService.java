package com.app.restrobuddy.Service;

public interface BaseService<E, D> {
    D copyToDto(E entity);

    E copyFromDto(D dto);
}
