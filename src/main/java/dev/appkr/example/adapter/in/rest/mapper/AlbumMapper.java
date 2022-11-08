package dev.appkr.example.adapter.in.rest.mapper;

import dev.appkr.example.domain.Album;
import dev.appkr.example.rest.AlbumDetailDto;
import dev.appkr.example.rest.AlbumDto;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
    DateTimeMapper.class,
    SongMapper.class,
    SingerMapper.class
})
public interface AlbumMapper extends DtoMapper<AlbumDto, Album> {

  @Override
  @Mapping(source = "id", target = "albumId")
  AlbumDto toDto(Album entity);

  @Mapping(source = "id", target = "albumId")
  AlbumDetailDto toDetailDto(Album entity);

  default List<AlbumDetailDto> toDetailDto(List<Album> entityList) {
    final List<AlbumDetailDto> dtoList = new ArrayList<>();
    if (entityList == null) {
      return dtoList;
    }

    for (Album entity : entityList) {
      dtoList.add(toDetailDto(entity));
    }

    return dtoList;
  }
}
