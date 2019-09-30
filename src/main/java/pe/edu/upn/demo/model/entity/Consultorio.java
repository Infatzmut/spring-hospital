package pe.edu.upn.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "consultorios")
public class Consultorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod")
	private Integer codigo;
	
	@Column(name = "nom_consultorio", length = 30, nullable = false )
	private String nombre;
	
	@ManyToMany(mappedBy = "consultorios")
	private List<Medico> medicos;
	
	public Consultorio() {
		medicos = new ArrayList<>();
	}
	//-----------------
	public void addMedico(Medico medico) {
		medico.addConsultorio(this);
		medicos.add(medico);
	}
	//-----------------

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
