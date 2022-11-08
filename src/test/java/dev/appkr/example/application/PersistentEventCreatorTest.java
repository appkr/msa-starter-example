package dev.appkr.example.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.appkr.example.adapter.in.rest.Fixtures;
import dev.appkr.example.application.port.out.AlbumRepository;
import dev.appkr.example.application.port.out.PersistentEventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersistentEventCreatorTest {

  @Autowired private AlbumService service;

  @MockBean private AlbumRepository mockAlbumRepository;
  @MockBean private PersistentEventRepository mockPersistentEventRepository;

  @DisplayName("when new Album is created"
      + " then a PersitentEvent should be created too")
  @Test
  void create() {
    when(mockAlbumRepository.save(any())).thenReturn(Fixtures.anAlbumEntity());

    service.createAlbum(Fixtures.anAlbumDto());

    verify(mockPersistentEventRepository, times(1)).save(any());
  }
}
