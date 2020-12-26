package dev.appkr.example.api.dummy;

import dev.appkr.example.api.model.AlbumDetailDto;
import java.time.OffsetDateTime;
import java.util.Collections;

public class AlbumDetailDtoFactory {

  public static AlbumDetailDto create() {
    return new AlbumDetailDto()
        .albumId(1L)
        .title("다시 부르기")
        .published(OffsetDateTime.parse("1993-03-01T09:00:00+09:00"))
        .singer(SingerDtoFactory.create())
        .songs(Collections.singletonList(SongDtoFactory.create()));
  }

}
