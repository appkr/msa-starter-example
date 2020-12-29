package dev.appkr.example.service.event;

import dev.appkr.example.domain.event.DomainEvent;
import dev.appkr.example.service.PersistentEventCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DomainEventHandler {

  private final PersistentEventCreator persistentEventCreator;

  @EventListener(classes = {DomainEvent.class})
  public void handle(DomainEvent<?> event) {
    log.info("An DomainEvent received {}", event);
    persistentEventCreator.create(event.getType(), event.getSource());
  }
}
