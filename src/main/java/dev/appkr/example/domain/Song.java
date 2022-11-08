package dev.appkr.example.domain;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "songs")
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "title"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String playTime;

  @ManyToOne
  private Album album;

  @CreatedBy
  private String createdBy;

  @CreatedDate
  private Instant createdAt = Instant.now();

  @LastModifiedBy
  private String updatedBy;

  @LastModifiedDate
  private Instant updatedAt = Instant.now();

  public Song(String title, String playTime) {
    this.title = title;
    this.playTime = playTime;
  }

  public void associateAlbum(Album album) {
    this.album = album;
    album.addSong(this);
  }
}
