package pe.edu.upn.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo.model.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	
	List<Medico> findByNombre(String nombre);
	
	@Query("Select me from Medico me where me.telefono > :telefono")
	List<Medico> fetchMayorTelefono(Integer telefono);
}
