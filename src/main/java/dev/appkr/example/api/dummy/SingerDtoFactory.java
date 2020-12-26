package dev.appkr.example.api.dummy;

import dev.appkr.example.api.model.SingerDto;

public class SingerDtoFactory {

  public static SingerDto create() {
    return new SingerDto()
        .singerId(1L)
        .name("김광석");
  }
}
