package es.agenda.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UsuarioForm {
	
	private Long id;
	
	@NotEmpty(message = "El nombre es obligatorio")
	private String nombre;
	
	@NotEmpty(message = "El password es obligatorios")
	private String password;
	
	@NotEmpty(message = "El rol es obligatorios")
	private Long roleId;
}
