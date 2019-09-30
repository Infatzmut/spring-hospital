package pe.edu.upn.demo;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.demo.model.entity.Consultorio;
import pe.edu.upn.demo.model.entity.Especialidad;
import pe.edu.upn.demo.model.entity.Medico;
import pe.edu.upn.demo.model.entity.Paciente;
import pe.edu.upn.demo.model.repository.ConsultorioRepository;
import pe.edu.upn.demo.model.repository.EspecialidadRepository;
import pe.edu.upn.demo.model.repository.MedicoRepository;
import pe.edu.upn.demo.model.repository.PacienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private EspecialidadRepository especialidadRepository;
	@Autowired
	private ConsultorioRepository consultorioRepository;
	
	@Test
	public void contextLoads() {
		// paciente
		// Recuperando un paciente antiguo
		
		try {
			/*Paciente antiguo = null;
			Optional<Paciente> caja = pacienteRepository.findById("N01");
			if(caja.isPresent())
				antiguo = caja.get();*/
			
			Paciente antiguo = new Paciente();
			antiguo.setCodigo("N01");
			antiguo.setNombre("Antiguo");
			antiguo.setDireccion("jr. Breña ");
			antiguo.setTelefono(958785514);
			antiguo.setFechaNacimiento(new Date(2019, 9, 9));
			
			Paciente carlos = new Paciente();
			carlos.setCodigo("N02");
			carlos.setNombre("Jesus Mendoza");
			carlos.setDireccion("jr. Breña ");
			carlos.setTelefono(958785514);
			carlos.setFechaNacimiento(new Date(2019, 9, 9));
			
			Paciente jose = new Paciente();
			jose.setCodigo("N03");
			jose.setNombre("Jose nazaret");
			jose.setDireccion("jr. Breña ");
			jose.setTelefono(95878544);
			jose.setFechaNacimiento(new Date(2019, 9, 9));
			
			antiguo = pacienteRepository.save(antiguo);
			carlos = pacienteRepository.save(carlos);
			jose = pacienteRepository.save(jose);
			
			// Medicos
			Medico medico1 = new Medico();
			medico1.setNombre("medico 1");
			Medico medico2 = new Medico();
			medico2.setNombre("medico 2");
			Medico medico3 = new Medico();
			medico3.setNombre("medico 3");
			
			medico1 = medicoRepository.save(medico1);
			medico2 = medicoRepository.save(medico2);
			medico3 = medicoRepository.save(medico3);
			
			// Especialidad
			Especialidad cirujano = new Especialidad();
			cirujano.setId("E01");
			cirujano.setNombre("Cirujano");
			Especialidad cardiologo = new Especialidad();
			cardiologo.setId("E02");
			cardiologo.setNombre("Cardiologo");
			Especialidad ginecologo = new Especialidad();
			ginecologo.setId("E03");
			ginecologo.setNombre("Ginecologo");
			
			cardiologo = especialidadRepository.save(cardiologo);
			ginecologo = especialidadRepository.save(ginecologo);
			cirujano = especialidadRepository.save(cirujano);
			
			// Consultorio
			Consultorio consultorio1 = new Consultorio(); 
			consultorio1.setNombre("Consultorio 1");
			Consultorio consultorio2 = new Consultorio(); 
			consultorio2.setNombre("Consultorio 2");
			Consultorio consultorio3 = new Consultorio(); 
			consultorio3.setNombre("Consultorio 3");
			
			consultorio1 = consultorioRepository.save(consultorio1);
			consultorio2 = consultorioRepository.save(consultorio2);
			consultorio3 = consultorioRepository.save(consultorio3);
			
			// Relaciones paciente-Medico
			antiguo.setMedico(medico1);
			carlos.setMedico(medico1);
			
			// Relaciones Medico-paciente
			medico3.addPaciente(jose);
			
			// Relacion Medico-Especialidad
			medico1.setEspecialidad(ginecologo);
			medico2.setEspecialidad(ginecologo);
			
			// Relacion Especialidad-medico
			cardiologo.addMedico(medico3);
			
			// relacion Medico-Consultorio
			medico1.addConsultorio(consultorio1);
			medico1.addConsultorio(consultorio3);
			medico2.addConsultorio(consultorio2);
			
			// Relacion Consultorio-Medico
			consultorio2.addMedico(medico3);
			consultorio1.addMedico(medico3);
			consultorio3.addMedico(medico3);
			
			// grabar
			medicoRepository.save(medico1);
			medicoRepository.save(medico2);
			medicoRepository.save(medico3);
			especialidadRepository.save(cardiologo);
			especialidadRepository.save(ginecologo);
			especialidadRepository.save(cirujano);			
			
			consultorioRepository.save(consultorio1);
			consultorioRepository.save(consultorio2);
			consultorioRepository.save(consultorio3);
			pacienteRepository.save(antiguo);
			pacienteRepository.save(carlos);
			pacienteRepository.save(jose);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		/*Paciente paciente = pacienteRepository.save(antiguo);
		assertTrue(paciente.getCodigo().equals("N01"));*/
		

	}

}














