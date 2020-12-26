package dev.appkr.example.repository;

import dev.appkr.example.domain.Example;
import java.util.List;

public interface ExampleRepositoryCustom {

  List<Example> findCreatedToday();
}
