package com.gametopvideos;

import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

public abstract class GenericService<E,D> implements IGenericService<E,D> {

     @Override
    public D toDTO(E entity, D dto) {
         return (D) new ModelMapper().map(entity,dto.getClass());
    }

    @Override
    public E toEntity(D dto, E entity) {
        return (E) new ModelMapper().map(dto,entity.getClass());
    }

    @Override
    public List<D> toDTOList(List<E> entityList, List<D> dtoList) {
        return (List<D>)(new ModelMapper().map(entityList,dtoList.getClass()));
    }

    @Override
    public List<E> toEntityList(List<E> entityList, List<D> dtoList) {
        return (List<E>)(new ModelMapper().map(dtoList,entityList.getClass()));
    }
}
