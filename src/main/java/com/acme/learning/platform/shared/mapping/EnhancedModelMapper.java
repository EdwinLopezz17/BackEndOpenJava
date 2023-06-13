package com.acme.learning.platform.shared.mapping;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EnhancedModelMapper extends ModelMapper {
    public EnhancedModelMapper() {
    }

    public <S, T>List<T>mapList(List<T> sourceList, Class<T> targetClase){
        return sourceList.stream().map(item->this.map(item,targetClase))
                .collect(Collectors.toList());
    }
}
