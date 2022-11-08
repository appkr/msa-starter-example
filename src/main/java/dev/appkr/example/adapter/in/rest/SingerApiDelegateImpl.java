package dev.appkr.example.adapter.in.rest;

import dev.appkr.example.application.SingerService;
import dev.appkr.example.domain.Singer;
import dev.appkr.example.rest.SingerApiDelegate;
import dev.appkr.example.rest.SingerDto;
import dev.appkr.example.support.HeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SingerApiDelegateImpl implements SingerApiDelegate {

  private final SingerService service;

  @Override
  public ResponseEntity<Void> createSinger(SingerDto dto) {
    final Singer entity = service.createSinger(dto);
    return ResponseEntity.created(HeaderUtils.uri("/{param1}", entity.getId())).build();
  }
}
