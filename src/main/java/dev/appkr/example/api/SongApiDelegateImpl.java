package dev.appkr.example.api;

import dev.appkr.example.api.model.SongDetailDto;
import dev.appkr.example.api.model.SongDto;
import dev.appkr.example.service.SongService;
import dev.appkr.example.support.HeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongApiDelegateImpl implements SongApiDelegate {

  private final SongService service;

  @Override
  public ResponseEntity<Void> createSong(SongDto req) {
    final SongDto res = service.createSong(req);
    return ResponseEntity
        .created(HeaderUtils.uri(res.getSongId()))
        .build();
  }

  @Override
  public ResponseEntity<SongDetailDto> getSong(Long songId) {
    SongDetailDto songDto = service.getSong(songId);
    return ResponseEntity.ok(songDto);
  }
}
