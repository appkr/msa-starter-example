package dev.appkr.example.service;

import dev.appkr.example.api.model.AlbumDto;
import dev.appkr.example.api.model.AlbumListDto;
import dev.appkr.example.domain.Album;
import dev.appkr.example.repository.AlbumRepository;
import dev.appkr.example.repository.SingerRepository;
import dev.appkr.example.repository.SongRepository;
import dev.appkr.example.service.mapper.AlbumMapper;
import dev.appkr.example.support.PaginationUtils;
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
  private final AlbumMapper albumMapper;
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
  public AlbumDto createAlbum(AlbumDto albumDto) {
    Album entity = Album.createFrom(albumDto);
    albumRepository.save(entity);
    eventCreator.create("ALBUM_CREATED", entity);
    return albumMapper.toDto(entity);
  }

  @Transactional(readOnly = true)
  public AlbumListDto listAlbums(Pageable pageable) {
    final Page<Album> page = albumRepository.findAll(pageable);
    return new AlbumListDto()
        .data(albumMapper.toDetailDto(page.getContent()))
        .page(PaginationUtils.getPageDto(page));
  }
}
