package dev.appkr.example.api;

import dev.appkr.example.api.model.SingerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SingerApiDelegateImpl implements SingerApiDelegate {

  @Override
  public ResponseEntity<Void> createSinger(SingerDto singerDto) {
    return null;
  }
}
