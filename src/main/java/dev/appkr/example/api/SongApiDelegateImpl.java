package dev.appkr.example.api;

import dev.appkr.example.api.dummy.SongDetailDtoFactory;
import dev.appkr.example.api.model.SongDetailDto;
import dev.appkr.example.api.model.SongDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SongApiDelegateImpl implements SongApiDelegate {

  @Override
  public ResponseEntity<Void> createSong(SongDto songDto) {
    return null;
  }

  @Override
  public ResponseEntity<SongDetailDto> getSong(Long songId) {
    return ResponseEntity.ok(SongDetailDtoFactory.create());
  }
}
