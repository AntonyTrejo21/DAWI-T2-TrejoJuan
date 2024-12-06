package DAWI_T2.TREJO_BURGA_JUANANTONY.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import DAWI_T2.TREJO_BURGA_JUANANTONY.dto.FilmTosaveDTO;
import DAWI_T2.TREJO_BURGA_JUANANTONY.service.FilmService;

@Controller
public class FilmController {
	@Autowired
	private FilmService _filmService;
	@GetMapping("/films")
	public String list(Model model,RedirectAttributes flash) {

		model.addAttribute("films", _filmService.findAll());
		return "Listado";

	}
	@GetMapping("/film/{id}")
	public String viewDetails(Model model, @PathVariable Integer id) {

		model.addAttribute("filmSelected" ,_filmService.getFilmDetails(id));
		return "Detalle";
	}
	@GetMapping("/save/{id}")
	public String viewToSave(Model model, @PathVariable Integer id) {

		model.addAttribute("languages" ,_filmService.getAllLanguages());
		model.addAttribute("filmSelected" ,_filmService.getFilmToSave(id));
		return "Guardar";

	}
	
	@PostMapping("/film")
	public String putFilm(@ModelAttribute FilmTosaveDTO filmSelected,RedirectAttributes flash) {		
		 if (filmSelected.filmId()!=null)	{
			 if(_filmService.update(filmSelected)!=null)
				 flash.addFlashAttribute("success", "Se guardo la pelicula exitosamente");
			 else
				 flash.addFlashAttribute("error", "Hubo un error al guardar la pelicula");
		 }

		else
			if(_filmService.create(filmSelected)!=null)
				 flash.addFlashAttribute("success", "Se guardo la pelicula exitosamente");

			 else
				 flash.addFlashAttribute("error", "Hubo un error al guardar la pelicula");
			
			 return "redirect:/films";
	}
	
	@PostMapping("/film/{id}")
	public String delFilm(@PathVariable Integer id, Model model,RedirectAttributes flash) {

		 if(_filmService.delete(id))
		 	flash.addFlashAttribute("warning", "Se elimino la pelicula exitosamente");
		 else
			 flash.addFlashAttribute("error", "Hubo un error al eliminar la pelicula");
		return "redirect:/films";

	}
}
