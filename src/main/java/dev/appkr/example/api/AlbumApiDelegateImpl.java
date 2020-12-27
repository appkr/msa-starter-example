package dev.appkr.example.api;

import dev.appkr.example.api.model.AlbumDto;
import dev.appkr.example.api.model.AlbumListDto;
import dev.appkr.example.service.AlbumService;
import dev.appkr.example.support.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

  private final AlbumService service;

  @Override
  public ResponseEntity<Void> associateSinger(Long albumId, Long singerId) {
    service.associateSinger(albumId, singerId);
    return null;
  }

  @Override
  public ResponseEntity<Void> associateSong(Long albumId, Long songId) {
    service.associateSong(albumId, songId);
    return null;
  }

  @Override
  public ResponseEntity<Void> createAlbum(AlbumDto albumDto) {
    service.createAlbum(albumDto);
    return null;
  }

  @Override
  public ResponseEntity<AlbumListDto> listAlbums(Integer page, Integer size) {
    final Pageable pageable = PaginationUtils.getPageable(page, size);
    AlbumListDto body = service.listAlbums(pageable);
    return ResponseEntity.ok(body);
  }
}
