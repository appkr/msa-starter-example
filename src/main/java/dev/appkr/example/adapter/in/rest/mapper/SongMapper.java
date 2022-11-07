package dev.appkr.example.adapter.in.rest.mapper;

import dev.appkr.example.domain.Song;
import dev.appkr.example.rest.SongDetailDto;
import dev.appkr.example.rest.SongDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SingerMapper.class, AlbumMapper.class})
public interface SongMapper extends DtoMapper<SongDto, Song> {

  @Override
  @Mapping(source = "id", target = "songId")
  SongDto toDto(Song entity);

  @Mapping(source = "id", target = "songId")
  SongDetailDto toDetailDto(Song entity);
}
