package es.agenda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario{
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String usuario;
	
	@Column
	private String password;
	
	@Column
	private Integer roleId;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Contacto> contacto;
}
