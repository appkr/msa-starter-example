package dev.appkr.example.api.dummy;

import dev.appkr.example.api.model.SongDto;

public class SongDtoFactory {

  public static SongDto create() {
    return new SongDto()
        .songId(1L)
        .title("두 바퀴로 가는 자동차")
        .playTime("03:20");
  }
}
