package es.agenda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario{
 
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@Column
	private String usuario;
	
	@Getter
	@Setter
	@Column
	private String password;
		
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Rol rol;
		
	@Getter
	@Setter
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Contacto> contacto;
}
