package dev.appkr.example.api.dummy;

import dev.appkr.example.api.model.AlbumDto;
import java.time.OffsetDateTime;

public class AlbumDtoFactory {

  public static AlbumDto create() {
    return new AlbumDto()
        .albumId(1L)
        .title("다시 부르기")
        .published(OffsetDateTime.parse("1993-03-01T09:00:00+09:00"));
  }

}
