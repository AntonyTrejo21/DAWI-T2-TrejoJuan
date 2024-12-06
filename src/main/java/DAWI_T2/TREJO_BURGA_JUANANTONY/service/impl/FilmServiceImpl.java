package DAWI_T2.TREJO_BURGA_JUANANTONY.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import DAWI_T2.TREJO_BURGA_JUANANTONY.dto.FilmDTO;
import DAWI_T2.TREJO_BURGA_JUANANTONY.dto.FilmDetailDTO;
import DAWI_T2.TREJO_BURGA_JUANANTONY.dto.FilmTosaveDTO;
import DAWI_T2.TREJO_BURGA_JUANANTONY.models.Film;
import DAWI_T2.TREJO_BURGA_JUANANTONY.models.Language;
import DAWI_T2.TREJO_BURGA_JUANANTONY.repository.FilmRepository;
import DAWI_T2.TREJO_BURGA_JUANANTONY.repository.LanguageRepository;
import DAWI_T2.TREJO_BURGA_JUANANTONY.service.FilmService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmRepository _filmService;
	@Autowired
	private LanguageRepository _languageRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<FilmDTO> findAll() {
	    return _filmService.findAll()
	            .stream()
	            .map(film -> 
	                new FilmDTO(
	                    film.getFilmId(),
	                    film.getTitle(),
	                    film.getDescription(),
	                    film.getReleaseYear(),
	                    film.getRating()
	                )
	            )
	            .collect(Collectors.toList());
	}
	@Transactional(readOnly = true)
	@Override
	public FilmDetailDTO getFilmDetails(Integer id) {
		return _filmService.findById(id).map(film ->
			new FilmDetailDTO(id,
					film.getTitle(),
					film.getDescription(),
					film.getReleaseYear(),
					film.getLanguage().getName(),
					film.getRating(),
					film.getLastUpdate())
				).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public FilmTosaveDTO getFilmToSave(Integer id) {
		return _filmService.findById(id).map(film ->
		new FilmTosaveDTO(film.getFilmId(),
				film.getTitle(),
				film.getDescription(),
				film.getReleaseYear(),
				film.getRentalDuration(),
				film.getRentalRate(),
				film.getLength(),
				film.getReplacementCost(),
				film.getRating(),
				film.getLanguage().getLanguageId())
				).orElse(new FilmTosaveDTO(null, "", "", 0, 0, 0.0, 0, 0.0, "",null));
	}
	@Transactional
	@Override
	public Film update(FilmTosaveDTO entity) {		
		return _filmService.findById(entity.filmId()).map( (film) -> {
            Language lang = _languageRepository.findById(entity.languageId()).orElseThrow();
			film.setTitle(entity.title());
			film.setDescription(entity.description());
			film.setReleaseYear(entity.release());
			film.setRentalDuration(entity.rentalDuration());
			film.setRentalRate(entity.rentalRate());
			film.setLength(entity.length());
			film.setReplacementCost(entity.replacementCost());
			film.setRating(entity.rating());
			film.setLastUpdate(LocalDateTime.now());
			film.setLanguage(lang);
			return _filmService.save(film);
		}).orElse(null);
	}
	@Transactional
	@Override
	public Film create(FilmTosaveDTO entity) {								
			Film filmToSave = new Film();
			Language lang = _languageRepository.findById(entity.languageId()).orElseThrow();
			filmToSave.setTitle(entity.title());
			filmToSave.setDescription(entity.description());
			filmToSave.setReleaseYear(entity.release());
			filmToSave.setRentalDuration(entity.rentalDuration());
			filmToSave.setRentalRate(entity.rentalRate());
			filmToSave.setLength(entity.length());
			filmToSave.setReplacementCost(entity.replacementCost());
			filmToSave.setRating(entity.rating());
			filmToSave.setLastUpdate(LocalDateTime.now());
			filmToSave.setLanguage(lang);
			return _filmService.save(filmToSave);
	}
	
	@Transactional
	@Override
	public boolean delete(Integer id) {
		if(_filmService.existsById(id)) {
			_filmService.deleteById(id);
			return true;
		}
		return false;
	}


	@Transactional(readOnly = true)
	@Override
	public List<Language> getAllLanguages() {
		return (List<Language>)_languageRepository.findAll();
	}
}
