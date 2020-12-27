package dev.appkr.example.service.mapper;

import dev.appkr.example.api.model.SingerDto;
import dev.appkr.example.domain.Singer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SingerMapper extends EntityMapper<SingerDto, Singer> {

  @Override
  @Mapping(source = "id", target = "singerId")
  SingerDto toDto(Singer entity);
}
