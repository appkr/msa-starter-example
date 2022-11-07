package dev.appkr.example.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "singers")
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Singer {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "singer")
  private Set<Album> albums = new HashSet<>();

  @OneToMany(mappedBy = "singer")
  private Set<Song> songs = new HashSet<>();

  @Builder
  private Singer(String name) {
    this.name = name;
  }

  public void addAlbum(Album album) {
    if (!this.albums.contains(album)) {
      this.albums.add(album);
    }
  }

  public void addSong(Song song) {
    if (!this.songs.contains(song)) {
      this.songs.add(song);
    }
  }
}
