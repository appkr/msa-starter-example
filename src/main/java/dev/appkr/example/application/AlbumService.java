package dev.appkr.example.application;

import dev.appkr.example.application.port.out.AlbumRepository;
import dev.appkr.example.application.port.out.SingerRepository;
import dev.appkr.example.application.port.out.SongRepository;
import dev.appkr.example.domain.Album;
import dev.appkr.example.rest.AlbumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlbumService {

  private final AlbumRepository albumRepository;
  private final SongRepository songRepository;
  private final SingerRepository singerRepository;
  private final PersistentEventCreator eventCreator;

  @Transactional
  public void associateSinger(Long albumId, Long singerId) {
    singerRepository.findById(singerId).ifPresent(singer -> {
      albumRepository.findById(albumId).ifPresent(album -> {
        album.associateSinger(singer);
      });
    });
  }

  @Transactional
  public void associateSong(Long albumId, Long songId) {
    songRepository.findById(songId).ifPresent(song -> {
      albumRepository.findById(albumId).ifPresent(album -> {
        song.associateAlbum(album);
      });
    });
  }

  @Transactional
  public Album createAlbum(AlbumDto dto) {
    final Album entity = new Album(dto.getTitle(), dto.getPublished());
    eventCreator.create("ALBUM_CREATED", entity);

    return albumRepository.save(entity);
  }

  @Transactional(readOnly = true)
  public Page<Album> listAlbums(Pageable pageable) {
    return albumRepository.findAll(pageable);
  }
}
