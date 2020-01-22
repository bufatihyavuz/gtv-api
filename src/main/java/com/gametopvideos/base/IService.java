package com.gametopvideos.base;

import java.util.List;

public interface IService<E,D>{

    D toDTO(E entity, D dto);
    E toEntity(D dto, E entity);
    List<D> toDTOList(List<E> entityList, List<D> dtoList);
    List<E> toEntityList(List<E> entityList, List<D> dtoList);
}
