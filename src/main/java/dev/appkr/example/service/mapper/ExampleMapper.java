package dev.appkr.example.service.mapper;

import dev.appkr.example.api.model.ExampleDto;
import dev.appkr.example.domain.Example;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DateTimeMapper.class})
public interface ExampleMapper extends EntityMapper<ExampleDto, Example>{

  @Override
  @Mapping(source = "id", target = "exampleId")
  ExampleDto toDto(Example entity);
}
