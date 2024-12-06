package DAWI_T2.TREJO_BURGA_JUANANTONY.dto;

public record FilmTosaveDTO(
		Integer filmId,
		String title,
		String description,
		Integer release,
		Integer rentalDuration,
		Double rentalRate,
		Integer length,
		Double replacementCost,					
		String rating,
		Integer languageId

) {
}
