package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.adapter.in.rest.mapper.SongMapper;
import dev.appkr.example.application.SongService;
import dev.appkr.example.rest.SongApiDelegate;
import dev.appkr.example.rest.SongDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongApiDelegateImpl implements SongApiDelegate {

  private final SongService service;
  private final SongMapper mapper;

  @Override
  public ResponseEntity<Void> createSong(SongDto dto) {
    service.createSong(dto);
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<SongDto> getSong(Long songId) {
    return ResponseEntity.ok(mapper.toDto(service.getSong(songId)));
  }
}
