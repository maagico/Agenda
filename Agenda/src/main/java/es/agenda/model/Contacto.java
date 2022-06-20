package es.agenda.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contactos")
public class Contacto {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@Column	
	private String nombre;
	
	@Getter
	@Setter
	@Column
	private String apellidos;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Telefono> telefonos;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Correo> correos;
}
