package DAWI_T2.TREJO_BURGA_JUANANTONY.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import DAWI_T2.TREJO_BURGA_JUANANTONY.models.Film;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
	@Cacheable(value = "film")
	List<Film> findAll();
	@CacheEvict(value = "film", allEntries = true)
	Film save(Film film);
	@CacheEvict(value = "film", allEntries = true)
	void deleteById(Integer id);
}
