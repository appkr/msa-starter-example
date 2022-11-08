package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.adapter.in.rest.mapper.SongMapper;
import dev.appkr.example.application.SongService;
import dev.appkr.example.domain.Song;
import dev.appkr.example.rest.SongApiDelegate;
import dev.appkr.example.rest.SongDto;
import dev.appkr.example.support.HeaderUtils;
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
    final Song entity = service.createSong(dto);
    return ResponseEntity.created(HeaderUtils.uri("/{param1}", entity.getId())).build();
  }

  @Override
  public ResponseEntity<SongDto> getSong(Long songId) {
    return ResponseEntity.ok(mapper.toDto(service.getSong(songId)));
  }
}
