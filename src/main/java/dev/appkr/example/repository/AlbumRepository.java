package dev.appkr.example.repository;

import dev.appkr.example.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> { }
