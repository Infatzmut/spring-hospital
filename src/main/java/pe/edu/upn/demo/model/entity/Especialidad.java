package pe.edu.upn.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "especial")
public class Especialidad {
	@Id
	@Column(name = "especial_id", length = 5)
	private String id;
	
	@Column(name = "nombre", length = 80)
	private String nombre;
	
	@OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY)
	private List<Medico> medicos;
	
	public Especialidad() {
		this.medicos = new ArrayList<>();
	}
	//------------------
	public void addMedico(Medico medico) {
		medico.setEspecialidad(this);
		this.medicos.add(medico);
	}
	//------------------

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	
}


