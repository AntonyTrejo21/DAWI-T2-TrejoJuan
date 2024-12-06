package DAWI_T2.TREJO_BURGA_JUANANTONY.service;

import DAWI_T2.TREJO_BURGA_JUANANTONY.dto.FilmDTO;
import DAWI_T2.TREJO_BURGA_JUANANTONY.dto.FilmDetailDTO;
import DAWI_T2.TREJO_BURGA_JUANANTONY.dto.FilmTosaveDTO;
import DAWI_T2.TREJO_BURGA_JUANANTONY.models.Film;
import DAWI_T2.TREJO_BURGA_JUANANTONY.models.Language;

import java.util.List;

public interface FilmService {

	List<FilmDTO> findAll();
	FilmDetailDTO getFilmDetails(Integer id);
	Film update(FilmTosaveDTO entity);
	boolean delete(Integer id);
	Film create(FilmTosaveDTO entity);
	FilmTosaveDTO getFilmToSave(Integer id);
	List<Language> getAllLanguages();
}
