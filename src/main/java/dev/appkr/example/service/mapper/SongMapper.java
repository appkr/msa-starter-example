package dev.appkr.example.service.mapper;

import dev.appkr.example.api.model.SongDetailDto;
import dev.appkr.example.api.model.SongDto;
import dev.appkr.example.domain.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SingerMapper.class, AlbumMapper.class})
public interface SongMapper extends EntityMapper<SongDto, Song> {

  @Override
  @Mapping(source = "id", target = "songId")
  SongDto toDto(Song entity);

  @Mapping(source = "id", target = "songId")
  SongDetailDto toDetailDto(Song entity);
}
