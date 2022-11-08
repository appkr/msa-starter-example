package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.adapter.in.rest.mapper.AlbumMapper;
import dev.appkr.example.application.AlbumService;
import dev.appkr.example.domain.Album;
import dev.appkr.example.rest.AlbumApiDelegate;
import dev.appkr.example.rest.AlbumDetailDto;
import dev.appkr.example.rest.AlbumDto;
import dev.appkr.example.rest.AlbumListDto;
import dev.appkr.example.rest.PageDto;
import dev.appkr.example.support.HeaderUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

  private final AlbumService service;
  private final AlbumMapper mapper;

  @Override
  public ResponseEntity<Void> associateSinger(Long albumId, Long singerId) {
    service.associateSinger(albumId, singerId);
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> associateSong(Long albumId, Long songId) {
    service.associateSong(albumId, songId);
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> createAlbum(AlbumDto dto) {
    final Album entity = service.createAlbum(dto);
    return ResponseEntity.created(HeaderUtils.uri("/{param1}", entity.getId())).build();
  }

  @Override
  public ResponseEntity<AlbumListDto> listAlbums(Integer page, Integer size) {
    final Pageable pageable = PageRequest.of(page, size);
    final Page<Album> albums = service.listAlbums(pageable);

    final List<AlbumDetailDto> dataDto = mapper.toDetailDto(albums.getContent());
    final PageDto pageDto = new PageDto()
        .number(albums.getNumber() + 1)
        .size(albums.getSize())
        .totalElements(albums.getTotalElements())
        .totalPages(albums.getTotalPages());

    return ResponseEntity.ok(new AlbumListDto()
        .data(dataDto)
        .page(pageDto));
  }
}
