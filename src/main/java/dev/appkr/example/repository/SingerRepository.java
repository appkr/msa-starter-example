package dev.appkr.example.repository;

import dev.appkr.example.domain.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> { }
