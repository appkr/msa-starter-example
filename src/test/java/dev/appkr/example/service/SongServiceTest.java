package dev.appkr.example.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import dev.appkr.example.api.dummy.SongDtoFactory;
import dev.appkr.example.api.model.SongDto;
import dev.appkr.example.domain.Song;
import dev.appkr.example.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class SongServiceTest {

  @Autowired private SongService sut;
  @MockBean private SongRepository mockRepository;

  @Test
  public void testCreateSong() {
    final Song stub = Song.builder().title("두 바퀴로 가는 자동차").playTime("03:20").build();
    when(mockRepository.save(any())).thenReturn(stub);

    final SongDto dto = sut.createSong(SongDtoFactory.create());
    log.info("dto {}", dto);
  }
}
