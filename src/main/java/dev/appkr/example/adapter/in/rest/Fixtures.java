package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.rest.AlbumDetailDto;
import dev.appkr.example.rest.AlbumDto;
import dev.appkr.example.rest.SingerDto;
import dev.appkr.example.rest.SongDetailDto;
import dev.appkr.example.rest.SongDto;
import java.time.OffsetDateTime;
import java.util.Collections;

public class Fixtures {

  public static AlbumDetailDto anAlbumDetailDto() {
    return new AlbumDetailDto()
        .albumId(1L)
        .title("다시 부르기")
        .published(OffsetDateTime.parse("1993-03-01T09:00:00+09:00"))
        .singer(aSingerDto())
        .songs(Collections.singletonList(aSongDto()));
  }

  public static AlbumDto anAlbumDto() {
    return new AlbumDto()
        .albumId(1L)
        .title("다시 부르기")
        .published(OffsetDateTime.parse("1993-03-01T09:00:00+09:00"));
  }

  public static SingerDto aSingerDto() {
    return new SingerDto()
        .singerId(1L)
        .name("김광석");
  }

  public static SongDetailDto aSongDetailDto() {
    return new SongDetailDto()
        .songId(1L)
        .title("두바퀴로 가는 자동차")
        .playTime("03:20")
        .singer(aSingerDto())
        .album(anAlbumDto());
  }

  public static SongDto aSongDto() {
    return new SongDto()
        .songId(1L)
        .title("두바퀴로 가는 자동차")
        .playTime("03:20");
  }
}
