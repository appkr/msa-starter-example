package dev.appkr.example.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import dev.appkr.example.api.dummy.SingerDtoFactory;
import dev.appkr.example.api.model.SingerDto;
import dev.appkr.example.domain.Singer;
import dev.appkr.example.repository.SingerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class SingerServiceTest {

  @Autowired private SingerService sut;
  @MockBean private SingerRepository mockRepository;

  @Test
  public void testCreateSinger() {
    final Singer stub = Singer.builder().name("김광석").build();
    when(mockRepository.save(any())).thenReturn(stub);

    final SingerDto dto = sut.createSinger(SingerDtoFactory.create());
    log.info("dto {}", dto);
  }
}
