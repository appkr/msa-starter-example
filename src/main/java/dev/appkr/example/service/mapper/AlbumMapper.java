package dev.appkr.example.service.mapper;

import dev.appkr.example.api.model.AlbumDetailDto;
import dev.appkr.example.api.model.AlbumDto;
import dev.appkr.example.domain.Album;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
    DateTimeMapper.class,
    SongMapper.class,
    SingerMapper.class
})
public interface AlbumMapper extends EntityMapper<AlbumDto, Album> {

  @Override
  @Mapping(source = "id", target = "albumId")
  AlbumDto toDto(Album entity);

  @Mapping(source = "id", target = "albumId")
  AlbumDetailDto toDetailDto(Album entity);

  List<AlbumDetailDto> toDetailDto(List<Album> entityList);
}
