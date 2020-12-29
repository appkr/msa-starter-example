package dev.appkr.example.support;

import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class HeaderUtils {

  public static URI uri(Object pathParam) {
    return ServletUriComponentsBuilder.fromCurrentRequest().path("/{pathParam}").buildAndExpand(pathParam).toUri();
  }

  private HeaderUtils() {
  }
}
