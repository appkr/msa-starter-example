package dev.appkr.example.api.dummy;

import dev.appkr.example.api.model.SongDetailDto;

public class SongDetailDtoFactory {

  public static SongDetailDto create() {
    return new SongDetailDto()
        .songId(1L)
        .title("두바퀴로 가는 자동차")
        .playTime("03:20")
        .singer(SingerDtoFactory.create())
        .album(AlbumDtoFactory.create());
  }
}
