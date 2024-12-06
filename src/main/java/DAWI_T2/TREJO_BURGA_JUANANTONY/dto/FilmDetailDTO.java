package DAWI_T2.TREJO_BURGA_JUANANTONY.dto;

import java.time.LocalDateTime;
public record FilmDetailDTO(				
		Integer filmId,
		String title,
		String description,
		Integer release,
		String LanguageName,					
		String rating,
		LocalDateTime lastUpdate

		) {
}
