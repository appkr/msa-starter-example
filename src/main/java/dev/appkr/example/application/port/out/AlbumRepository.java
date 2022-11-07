package dev.appkr.example.application.port.out;

import dev.appkr.example.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> { }
