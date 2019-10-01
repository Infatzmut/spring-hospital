package pe.edu.upn.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.demo.model.entity.Especialidad;
import pe.edu.upn.demo.model.entity.Medico;
import pe.edu.upn.demo.service.EspecialidadService;
import pe.edu.upn.demo.service.MedicoService;

@Controller
@RequestMapping("/medico") //http:localhost:8080/medico
@SessionAttributes("medico") //es el objeto que estoy enviando
public class MedicoController {

	@Autowired
	private MedicoService medicoService; //obtiene el servicio que envia todos los medicos
	@Autowired
	private EspecialidadService especialidadService; //es la unica forma de acceder a una entidad
	
	@GetMapping
	public String inicio(Model model) { //permite enviar los medicos hacia la vista 
		try {
			List<Medico> medicos = medicoService.findAll();
			model.addAttribute("medicos", medicos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/medico/inicio";
	}
	//html<->controller<->service
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model){
		try {
			Optional<Medico> optional = medicoService.findById(id);
			List<Especialidad> especialidades = especialidadService.findAll();
			if(optional.isPresent()) {
												
				model.addAttribute("medico", optional.get());
				model.addAttribute("especialidades",especialidades); //obtener lista de especialidades , lo obtenemos del service de especialidad
			}else {
				return "redirect:/medico";
			}
		}catch(Exception e) {
			
		}
		return "/medico/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("medico") Medico medico,Model model,SessionStatus status) {
		try {
			medicoService.save(medico);
			status.setComplete();
		
		}catch(Exception e) {}
		return "";
	}
}
