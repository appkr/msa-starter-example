package dev.appkr.example.repository;

import dev.appkr.example.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> { }
