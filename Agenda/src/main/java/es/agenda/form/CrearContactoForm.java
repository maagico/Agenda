package es.agenda.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CrearContactoForm {
	
	@NotEmpty(message = "El nombre es obligatorio")
	private String nombre;
	
	@NotEmpty(message = "Los apellidos son obligatorios")
	private String apellidos;
	
	private List<String> telefonos;
	
	private List<String> correos;
}
