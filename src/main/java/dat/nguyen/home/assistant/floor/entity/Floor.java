package dat.nguyen.home.assistant.floor.entity;

import dat.nguyen.home.assistant.home.entity.Home;
import dat.nguyen.home.assistant.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "floors")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Floor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "home_id")
  private Home home;

  @Column(name = "name")
  private String name;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
