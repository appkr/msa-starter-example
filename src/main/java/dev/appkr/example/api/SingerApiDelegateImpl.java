package dev.appkr.example.api;

import dev.appkr.example.api.model.SingerDto;
import dev.appkr.example.service.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SingerApiDelegateImpl implements SingerApiDelegate {

  private final SingerService service;

  @Override
  public ResponseEntity<Void> createSinger(SingerDto singerDto) {
    service.createSinger(singerDto);
    return null;
  }
}
