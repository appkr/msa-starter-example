package dev.appkr.example.service.mapper;

import dev.appkr.example.api.model.AlbumDto;
import dev.appkr.example.domain.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DateTimeMapper.class})
public interface AlbumMapper extends EntityMapper<AlbumDto, Album> {

  @Override
  @Mapping(source = "id", target = "albumId")
  AlbumDto toDto(Album entity);
}
