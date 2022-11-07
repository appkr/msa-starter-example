package dev.appkr.example.adapter.in.rest.mapper;

import dev.appkr.example.domain.Singer;
import dev.appkr.example.rest.SingerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SingerMapper extends DtoMapper<SingerDto, Singer> {

  @Override
  @Mapping(source = "id", target = "singerId")
  SingerDto toDto(Singer entity);
}
