package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.rest.SingerApiDelegate;
import dev.appkr.example.rest.SingerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SingerApiDelegateImpl implements SingerApiDelegate {

  @Override
  public ResponseEntity<Void> createSinger(SingerDto singerDto) {
    return null;
  }
}
