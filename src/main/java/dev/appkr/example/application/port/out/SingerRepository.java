package dev.appkr.example.application.port.out;

import dev.appkr.example.domain.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> { }
