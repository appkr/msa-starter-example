package dev.appkr.example.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.appkr.example.support.Carbon;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlbumTest {

  private Logger log = LoggerFactory.getLogger(getClass());

  @Test
  public void testAlbum() {
    Singer singer = new Singer("김광석");

    Album album = new Album("다시 부르기", OffsetDateTime.parse("1993-03-01T09:00:00+09:00"));
    album.markPublished(Carbon.parse("1993-03-01T09:00:00+09:00").toInstant());
    album.associateSinger(singer);

    Song song = new Song("두 바퀴로 가는 자동차", "03:20");
    song.associateAlbum(album);

    assertEquals(singer, album.getSinger());
    assertEquals(album, song.getAlbum());

    log.info("album {}", album);
  }
}
