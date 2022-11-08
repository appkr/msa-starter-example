package dev.appkr.example.application;

import dev.appkr.example.application.port.out.SingerRepository;
import dev.appkr.example.domain.Singer;
import dev.appkr.example.rest.SingerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SingerService {

  private final SingerRepository repository;

  @Transactional
  public Singer createSinger(SingerDto dto) {
    final Singer entity = new Singer(dto.getName());
    return repository.save(entity);
  }
}
