package dev.appkr.example.domain.event;

import dev.appkr.example.domain.Album;

public class AlbumCreated extends DomainEvent<Album> {

  public AlbumCreated(Album source) {
    super(source);
  }
}
