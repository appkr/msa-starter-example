package dev.appkr.example.adapter.in.rest.mapper;

import dev.appkr.example.domain.Song;
import dev.appkr.example.rest.SongDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SongMapper extends DtoMapper<SongDto, Song> {

  @Override
  @Mapping(source = "id", target = "songId")
  SongDto toDto(Song entity);
}
