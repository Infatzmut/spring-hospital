package pe.edu.upn.demo.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "pacientes")
public class Paciente {
	@Id
	@Column(name = "codigo", length = 10)
	private String codigo;
	
	@Column(name = "nom_paciente", length = 25, nullable = false)
	private String nombre;
	
	@Column(name = "fec_nac_paciente")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "dir_paciente", length = 50, nullable = true)
	private String direccion;
	
	private Integer telefono;
	
	//  Lazy: No carga el objeto medico
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id")
	private Medico medico;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}





