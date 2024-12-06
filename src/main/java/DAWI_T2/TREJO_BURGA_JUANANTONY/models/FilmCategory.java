package DAWI_T2.TREJO_BURGA_JUANANTONY.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "film_category")
public class FilmCategory {
	@Id
	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;
	@Id
	@Column(name = "category_id")
	private Integer categoriId;
	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate;

}