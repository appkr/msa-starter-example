package dev.appkr.example.application;

import dev.appkr.example.application.port.out.SongRepository;
import dev.appkr.example.domain.Song;
import dev.appkr.example.rest.SongDto;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SongService {

  private final SongRepository repository;

  @Transactional
  public Song createSong(SongDto dto) {
    final Song entity = new Song(dto.getTitle(), dto.getPlayTime());
    return repository.save(entity);
  }

  @Transactional(readOnly = true)
  public Song getSong(Long songId) {
    return repository.findById(songId)
        .orElseThrow(() -> new NoSuchElementException());
  }
}
