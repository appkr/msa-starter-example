package dev.appkr.example.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import dev.appkr.example.api.dummy.AlbumDtoFactory;
import dev.appkr.example.api.dummy.SingerDtoFactory;
import dev.appkr.example.api.dummy.SongDtoFactory;
import dev.appkr.example.api.model.AlbumDto;
import dev.appkr.example.api.model.AlbumListDto;
import dev.appkr.example.domain.Album;
import dev.appkr.example.domain.Singer;
import dev.appkr.example.domain.Song;
import dev.appkr.example.repository.AlbumRepository;
import dev.appkr.example.repository.SingerRepository;
import dev.appkr.example.repository.SongRepository;
import dev.appkr.example.support.PaginationUtils;
import java.util.Collections;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class AlbumServiceTest {

  @Autowired private AlbumService sut;
  @MockBean private AlbumRepository mockAlbumRepository;
  @MockBean private SongRepository mockSongRepository;
  @MockBean private SingerRepository mockSingerRepository;

  @Test
  public void testAssociateSinger() {
    when(mockSingerRepository.findById(any()))
        .thenReturn(Optional.of(Singer.createFrom(SingerDtoFactory.create())));
    when(mockAlbumRepository.findById(any()))
        .thenReturn(Optional.of(Album.createFrom(AlbumDtoFactory.create())));

    sut.associateSinger(1L, 1L);
    assertTrue(true);
  }

  @Test
  public void testAssociateSong() {
    when(mockSongRepository.findById(any()))
        .thenReturn(Optional.of(Song.createFrom(SongDtoFactory.create())));
    when(mockAlbumRepository.findById(any()))
        .thenReturn(Optional.of(Album.createFrom(AlbumDtoFactory.create())));

    sut.associateSong(1L, 1L);
    assertTrue(true);
  }

  @Test
  public void testCreateAlbum() {
    final AlbumDto req = AlbumDtoFactory.create();
    final Album stub = Album.createFrom(req);
    when(mockAlbumRepository.save(any())).thenReturn(stub);

    final AlbumDto res = sut.createAlbum(req);
    log.info("res {}", res);
  }

  @Test
  public void testListAlbums() {
    final Album album = Album.createFrom(AlbumDtoFactory.create());
    Page<Album> stub = new PageImpl<>(Collections.singletonList(album));
    when(mockAlbumRepository.findAll(PaginationUtils.getPageable()))
        .thenReturn(stub);

    final AlbumListDto res = sut.listAlbums(PaginationUtils.getPageable());
    log.info("res {}", res);
  }
}
