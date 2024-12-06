package DAWI_T2.TREJO_BURGA_JUANANTONY.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "film_actor")
public class FilmActor {

	@Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Id
    @Column(name = "actor_id")
    private Integer actor;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
