package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.rest.AlbumApiDelegate;
import dev.appkr.example.rest.AlbumDto;
import dev.appkr.example.rest.AlbumListDto;
import dev.appkr.example.rest.PageDto;
import java.util.Collections;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

  @Override
  public ResponseEntity<Void> associateSinger(Long albumId, Long singerId) {
    return null;
  }

  @Override
  public ResponseEntity<Void> associateSong(Long albumId, Long songId) {
    return null;
  }

  @Override
  public ResponseEntity<Void> createAlbum(AlbumDto albumDto) {
    return null;
  }

  @Override
  public ResponseEntity<AlbumListDto> listAlbums(Integer page, Integer size) {
    final PageDto pageDto = new PageDto().number(page).size(size).totalPages(1).totalElements(1L);
    final AlbumListDto body = new AlbumListDto()
        .data(Collections.singletonList(Fixtures.anAlbumDetailDto()))
        .page(pageDto);

    return ResponseEntity.ok(body);
  }
}
