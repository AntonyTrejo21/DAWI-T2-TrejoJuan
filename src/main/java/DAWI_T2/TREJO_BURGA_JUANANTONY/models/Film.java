package DAWI_T2.TREJO_BURGA_JUANANTONY.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "film")
public class Film {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer filmId;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "release_year")
	private Integer releaseYear;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id", referencedColumnName = "language_id")
	private Language language;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "original_language_id" ,referencedColumnName = "language_id")
	private Language originalLanguage;
	@Column(name = "rental_duration")
	private Integer rentalDuration;

	@Column(name = "rental_rate" )
	private Double rentalRate;

	@Column(name = "length")
	private Integer length;
	@Column(name = "replacement_cost")
	private Double replacementCost;
	@Column(name = "rating")
	private String rating;
	@Column(name = "special_features")
	private String specialFeatures;
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<FilmCategory> categories;
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Inventory> inventories;
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<FilmActor> actores;

	public Integer getFilmId() {
		return filmId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public Language getLanguage() {
		return language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public Double getRentalRate() {
		return rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public Double getReplacementCost() {
		return replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public Set<FilmCategory> getCategories() {
		return categories;
	}

	public Set<Inventory> getInventories() {
		return inventories;
	}

	public Set<FilmActor> getActores() {
		return actores;
	}
}