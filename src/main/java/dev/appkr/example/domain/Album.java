package dev.appkr.example.domain;

import dev.appkr.example.config.Constants;
import dev.appkr.example.support.Carbon;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "albums")
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private Instant published;

  @ManyToOne
  private Singer singer;

  @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
  private Set<Song> songs = new HashSet<>();

  @CreatedBy
  private String createdBy;

  @CreatedDate
  private Instant createdAt = Instant.now();

  @LastModifiedBy
  private String updatedBy;

  @LastModifiedDate
  private Instant updatedAt = Instant.now();

  public Album(String title, OffsetDateTime publishedDate) {
    this.title = title;
    final Instant published = Carbon.from(publishedDate, ZoneId.of(Constants.TIMEZONE_SEOUL)).toInstant();
    markPublished(published);
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
