package dev.appkr.example.service;

import dev.appkr.example.api.model.SingerDto;
import dev.appkr.example.domain.Singer;
import dev.appkr.example.repository.SingerRepository;
import dev.appkr.example.service.mapper.SingerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SingerService {

  private final SingerRepository repository;
  private final SingerMapper mapper;

  @Transactional
  public SingerDto createSinger(SingerDto singerDto) {
    Singer entity = Singer.createFrom(singerDto);
    repository.save(entity);
    return mapper.toDto(entity);
  }
}
