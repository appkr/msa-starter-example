package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.rest.SongApiDelegate;
import dev.appkr.example.rest.SongDetailDto;
import dev.appkr.example.rest.SongDto;
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
    return ResponseEntity.ok(Fixtures.aSongDetailDto());
  }
}
