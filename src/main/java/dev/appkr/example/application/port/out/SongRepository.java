package dev.appkr.example.application.port.out;

import dev.appkr.example.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> { }
