package DAWI_T2.TREJO_BURGA_JUANANTONY.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private Integer languageId;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "last_update", nullable = true)
	private LocalDateTime lastUpdate;
}
