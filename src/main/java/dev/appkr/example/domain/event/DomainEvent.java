package dev.appkr.example.domain.event;

import com.google.common.base.CaseFormat;
import java.time.Instant;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DomainEvent<T> {

  private T source;
  private Instant timestamp;

  public DomainEvent(T source) {
    this.source = source;
    this.timestamp = Instant.now();
  }

  public String getType() {
    return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, getClass().getSimpleName());
  }
}
