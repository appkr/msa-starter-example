package dev.appkr.example.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.appkr.example.support.Carbon;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlbumTest {

  private Logger log = LoggerFactory.getLogger(getClass());

  @Test
  public void testAlbum() {
    Singer singer = new Singer("김광석");

    Album album = Album.builder()
        .title("다시 부르기")
        .build();
    album.markPublished(Carbon.parse("1993-03-01T09:00:00+09:00").toInstant());
    album.associateSinger(singer);

    Song song = new Song("두 바퀴로 가는 자동차", "03:20");
    song.associateAlbum(album);
    song.associateSinger(singer);

    assertEquals(singer, album.getSinger());
    assertEquals(singer, song.getSinger());
    assertEquals(album, song.getAlbum());

    log.info("album {}", album);
  }
}
