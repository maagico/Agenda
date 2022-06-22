package es.agenda.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@Column
	private String rol;
	
	@Getter
	@Setter
	@Column
	private String nombre;
	
	@Getter
	@Setter
	@OneToOne(mappedBy = "rol", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private Usuario usuario;
}
