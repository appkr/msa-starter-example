package dev.appkr.example.scheduled;

import static org.junit.jupiter.api.Assertions.*;

import dev.appkr.example.domain.Example;
import dev.appkr.example.domain.PersistentEvent;
import dev.appkr.example.domain.PersistentEventStatus;
import dev.appkr.example.repository.PersistentEventRepository;
import dev.appkr.example.support.JsonUtils;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersistentEventPublisherTest {

  @Autowired
  private PersistentEventRepository repository;
  @Autowired
  private PersistentEventPublisher publisher;

  private PersistentEvent base;

  @Transactional
  @Test
  public void testPublish() throws IOException {
    // given
    final Example eventSource = Example.newInstance("original title");
    final String body = JsonUtils.convertObjectToString(eventSource);
    final PersistentEvent entity = PersistentEvent.newInstance("ExampleCreated", UUID.randomUUID(), body);
    this.base = repository.saveAndFlush(entity);

    // when
    publisher.publish();

    // then
    final Optional<PersistentEvent> optional = repository.findById(base.getId());
    final PersistentEvent actual = optional.orElseThrow(() -> new NoSuchElementException());
    assertEquals(PersistentEventStatus.PRODUCED, actual.getStatus());
  }
}