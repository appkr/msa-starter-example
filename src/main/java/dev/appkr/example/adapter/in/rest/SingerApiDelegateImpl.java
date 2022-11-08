package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.application.SingerService;
import dev.appkr.example.rest.SingerApiDelegate;
import dev.appkr.example.rest.SingerDto;
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
    return ResponseEntity.noContent().build();
  }
}
