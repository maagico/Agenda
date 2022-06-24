package es.agenda.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UsuarioForm {
	
	private Long id;
	
	@NotEmpty(message = "El nombre es obligatorio")
	private String usuario;
	
	private String password;
	
	@NotNull(message = "El rol es obligatorios")
	private Long roleId;
}
