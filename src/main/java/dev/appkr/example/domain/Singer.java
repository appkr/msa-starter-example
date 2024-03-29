package dev.appkr.example.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "singers")
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Singer {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "singer")
  private Set<Album> albums = new HashSet<>();

  public Singer(String name) {
    this.name = name;
  }

  public void addAlbum(Album album) {
    if (!this.albums.contains(album)) {
      this.albums.add(album);
    }
  }
}
