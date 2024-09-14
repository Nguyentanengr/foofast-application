package com.swingapplication.foofast.daos;

import java.util.List;
import java.util.Optional;

public interface IBaseDAO<E, I>{

    List<E> findAll();

    Optional<E> findById(I id);

    E save(E entity);

    E update(E entity);

    E setActiveOrInactive(I id);
}
