package dev.appkr.example.application.port.out;

import dev.appkr.example.domain.Album;
import dev.appkr.example.domain.Singer;
import dev.appkr.example.domain.Song;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class )
@SpringBootTest
class AlbumRepositoryTest {

  private Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private SongRepository songRepository;
  @Autowired private SingerRepository singerRepository;
  @Autowired private AlbumRepository albumRepository;

  @Test
  @Transactional
  public void curd() {
    final Singer singer = new Singer("김광석");
    singerRepository.saveAndFlush(singer);

    final Album album = new Album("다시 부르기", OffsetDateTime.parse("1993-03-01T09:00:00+09:00"));
    album.associateSinger(singer);
    albumRepository.saveAndFlush(album);

    final Song song = new Song("두 바퀴로 가는 자동차", "03:20");
    song.associateAlbum(album);
    song.associateSinger(singer);
    songRepository.saveAndFlush(song);

    albumRepository
        .findById(album.getId())
        .ifPresent(retrieved -> log.info("retrieved entity {}", retrieved));
  }
}
