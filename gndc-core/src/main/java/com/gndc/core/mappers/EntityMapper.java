package com.gndc.core.mappers;

import java.util.List;

/**
 * @Description
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 */
public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List <E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
