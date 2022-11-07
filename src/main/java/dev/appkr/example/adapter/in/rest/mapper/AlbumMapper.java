package dev.appkr.example.adapter.in.rest.mapper;

import dev.appkr.example.domain.Album;
import dev.appkr.example.rest.AlbumDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DateTimeMapper.class})
public interface AlbumMapper extends DtoMapper<AlbumDto, Album> {

  @Override
  @Mapping(source = "id", target = "albumId")
  AlbumDto toDto(Album entity);
}
