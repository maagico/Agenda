package es.agenda.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CuentaForm {
	
	@NotEmpty(message = "El usuario es obligatorio")
	private String usuario;
	
	@NotEmpty(message = "El password es obligatorio")
	private String password;
	
	@NotNull(message = "El rol es obligatorio")
	private Long roleId;
}
