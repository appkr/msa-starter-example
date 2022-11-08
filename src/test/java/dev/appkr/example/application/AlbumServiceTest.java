package dev.appkr.example.application;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import dev.appkr.example.adapter.in.rest.Fixtures;
import dev.appkr.example.application.port.out.AlbumRepository;
import dev.appkr.example.application.port.out.SingerRepository;
import dev.appkr.example.application.port.out.SongRepository;
import dev.appkr.example.domain.Album;
import dev.appkr.example.rest.AlbumDto;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
  void associateSinger() {
    when(mockSingerRepository.findById(any()))
        .thenReturn(Optional.of(Fixtures.aSingerEntity()));
    when(mockAlbumRepository.findById(any()))
        .thenReturn(Optional.of(Fixtures.anAlbumEntity()));

    sut.associateSinger(1L, 1L);
    assertTrue(true);
  }

  @Test
  void associateSong() {
    when(mockSongRepository.findById(any()))
        .thenReturn(Optional.of(Fixtures.aSongEntity()));
    when(mockAlbumRepository.findById(any()))
        .thenReturn(Optional.of(Fixtures.anAlbumEntity()));

    sut.associateSong(1L, 1L);
    assertTrue(true);
  }

  @Test
  void createAlbum() {
    final AlbumDto req = Fixtures.anAlbumDto();
    final Album stub = Fixtures.anAlbumEntity();
    when(mockAlbumRepository.save(any())).thenReturn(stub);

    final Album res = sut.createAlbum(req);
    log.info("res {}", res);
  }

  @Test
  void listAlbums() {
    final Album album = Fixtures.anAlbumEntity();
    final Page<Album> stub = new PageImpl<Album>(List.of(album));
    final PageRequest pageable = PageRequest.of(1, 10);
    when(mockAlbumRepository.findAll(pageable))
        .thenReturn(stub);

    final Page<Album> res = sut.listAlbums(pageable);
    log.info("res {}", res);
  }
}
