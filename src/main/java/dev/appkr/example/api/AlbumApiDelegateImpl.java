package dev.appkr.example.api;

import dev.appkr.example.api.dummy.AlbumDetailDtoFactory;
import dev.appkr.example.api.model.AlbumDto;
import dev.appkr.example.api.model.AlbumListDto;
import dev.appkr.example.api.model.PageDto;
import dev.appkr.example.support.PaginationUtils;
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
    final PageDto pageDto = PaginationUtils.getPageDto(0, 1, 1L, 1);
    final AlbumListDto body = new AlbumListDto()
        .data(Collections.singletonList(AlbumDetailDtoFactory.create()))
        .page(pageDto);

    return ResponseEntity.ok(body);
  }
}
