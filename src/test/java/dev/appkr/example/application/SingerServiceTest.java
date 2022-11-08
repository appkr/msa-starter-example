package dev.appkr.example.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import dev.appkr.example.adapter.in.rest.Fixtures;
import dev.appkr.example.application.port.out.SingerRepository;
import dev.appkr.example.domain.Singer;
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
class SingerServiceTest {

  @Autowired private SingerService sut;

  @MockBean private SingerRepository mockRepository;

  @Test
  void createSinger() {
    final Singer stub = new Singer("김광석");
    when(mockRepository.save(any())).thenReturn(stub);

    final Singer dto = sut.createSinger(Fixtures.aSingerDto());
    log.info("dto {}", dto);
  }
}
