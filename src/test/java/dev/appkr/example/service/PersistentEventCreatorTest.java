package dev.appkr.example.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.appkr.example.api.dummy.AlbumDtoFactory;
import dev.appkr.example.api.model.AlbumDto;
import dev.appkr.example.domain.Album;
import dev.appkr.example.repository.AlbumRepository;
import dev.appkr.example.repository.PersistentEventRepository;
import org.junit.jupiter.api.Disabled;
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

  @Disabled("Not valid any more "
      + "from 'refactored domain events using AbstractAggregateRoot and EventListeners' commit on")
  @DisplayName("when new Album is created"
      + " then a PersitentEvent should be created too")
  @Test
  public void testCreatePersistentEvent() {
    final AlbumDto req = AlbumDtoFactory.create();
    final Album stub = Album.createFrom(req);
    when(mockAlbumRepository.save(any())).thenReturn(stub);

    service.createAlbum(req);

    verify(mockPersistentEventRepository, times(1)).save(any());
  }
}
