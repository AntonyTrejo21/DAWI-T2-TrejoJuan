package DAWI_T2.TREJO_BURGA_JUANANTONY.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import DAWI_T2.TREJO_BURGA_JUANANTONY.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer>{
}
