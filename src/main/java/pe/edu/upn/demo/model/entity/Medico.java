package pe.edu.upn.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ape_nom", length = 60)
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "especial_id")
	private Especialidad especialidad;
	
	@Column(name = "dir_medico", length = 50)
	private String direccion;
	
	@Column(name = "fono")
	private Integer telefono;
	
	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
	private List<Paciente> pacientes;
	
	@ManyToMany
	@JoinTable(name = "medico_consultorio", 
		joinColumns = @JoinColumn(columnDefinition = "medico_id"),
		inverseJoinColumns = @JoinColumn(columnDefinition = "consultorio_cod"))
	private List<Consultorio> consultorios;
	
	public Medico() {
		pacientes = new ArrayList<>();
		consultorios = new ArrayList<>();
	}
	//-----------------
	public void addPaciente(Paciente paciente) {
		paciente.setMedico(this);
		this.pacientes.add(paciente);
	}
	public void addConsultorio(Consultorio consultorio) {
		consultorios.add(consultorio);
	}
	//-----------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Consultorio> getConsultorios() {
		return consultorios;
	}

	public void setConsultorios(List<Consultorio> consultorios) {
		this.consultorios = consultorios;
	}
	
}





