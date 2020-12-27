package dev.appkr.example.service;

import dev.appkr.example.api.model.SongDetailDto;
import dev.appkr.example.api.model.SongDto;
import dev.appkr.example.domain.Song;
import dev.appkr.example.repository.SongRepository;
import dev.appkr.example.service.mapper.SongMapper;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SongService {

  private final SongRepository repository;
  private final SongMapper mapper;

  @Transactional
  public SongDto createSong(SongDto dto) {
    final Song entity = Song.createFrom(dto);
    repository.save(entity);
    return mapper.toDto(entity);
  }

  @Transactional(readOnly = true)
  public SongDetailDto getSong(Long songId) {
    final Song entity = repository.findById(songId)
        .orElseThrow(() -> new NoSuchElementException());
    return mapper.toDetailDto(entity);
  }
}
