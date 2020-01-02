package com.gametopvideos;

import java.util.List;

public interface IGenericService<E,D>{

    D toDTO(E entity, D dto);
    E toEntity(D dto, E entity);
    List<D> toDTOList(List<E> entityList, List<D> dtoList);
    List<E> toEntityList(List<E> entityList, List<D> dtoList);
}
