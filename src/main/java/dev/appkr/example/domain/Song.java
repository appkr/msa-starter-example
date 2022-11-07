package dev.appkr.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "songs")
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "title"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String playTime;

  @ManyToOne
  private Album album;

  @ManyToOne
  private Singer singer;

  @Builder
  private Song(String title, String playTime) {
    this.title = title;
    this.playTime = playTime;
  }

  public void associateAlbum(Album album) {
    this.album = album;
    album.addSong(this);
  }

  public void associateSinger(Singer singer) {
    this.singer = singer;
    singer.addSong(this);
  }
}
