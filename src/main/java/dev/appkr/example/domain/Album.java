package dev.appkr.example.domain;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "albums")
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private Instant published;

  @ManyToOne
  private Singer singer;

  @OneToMany(mappedBy = "album")
  private Set<Song> songs = new HashSet<>();

  @Builder
  public Album(String title) {
    this.title = title;
  }

  public void associateSinger(Singer singer) {
    this.singer = singer;
    this.singer.addAlbum(this);
  }

  public void addSong(Song song) {
    if (!this.songs.contains(song)) {
      this.songs.add(song);
    }
  }

  public void markPublished() {
    this.published = Instant.now();
  }

  public void markPublished(Instant publishedDate) {
    this.published = publishedDate;
  }
}
