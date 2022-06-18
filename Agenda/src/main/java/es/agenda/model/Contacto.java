package es.agenda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "contactos")
@Data
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column	
	private String nombre;
	
	@Column
	private String apellidos;
	
	@OneToMany
    @JoinColumn(name = "contacto_id")
	private List<Telefono> telefonos;
	
	@OneToMany
	@JoinColumn(name = "contacto_id")
	private List<Correo> correos;
}
