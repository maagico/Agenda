package es.agenda.excepcion;

public class UsuarioYaExisteException extends Exception{
	
	private static final long serialVersionUID = 3205385258251876327L;

	public UsuarioYaExisteException(String mensaje, Throwable cause){
		
		super(mensaje, cause);
	}
}
