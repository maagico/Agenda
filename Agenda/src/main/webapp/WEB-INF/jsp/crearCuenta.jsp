<%@ page contentType="text/html; charset=UTF-8" %> 

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template-login">
		
	<tiles:putAttribute name="title">
	
		<title>Crear cuenta</title>
	
	</tiles:putAttribute>
	
	<tiles:putAttribute name="header-resources">
	
	<link href="css/signin.css" rel="stylesheet">
	
	</tiles:putAttribute>	 
	
    <tiles:putAttribute name="body">
	
		<main class="form-signin w-100 m-auto">
			<form action = "/crearCuenta" method="post">
				
				<h1 class="h3 mb-3 fw-normal">Introduce tus datos para crear la cuenta</h1>
			    
			    <div class="form-floating">
			      <input id="floatingInput" type="text" name = "username" class="form-control" placeholder="Usuario" maxlength="20" required="required">
			      <label for="floatingInput">Usuario</label>
			    </div>
			    
			    <br/>
			    
			    <div class="form-floating">
			      <input id="floatingPassword" type="password" name = "password" class="form-control" placeholder="Password" maxlength="20" required="required">
			      <label for="floatingPassword">Password</label>
			    </div>   
			    
			    <br/>
			    
			    <select class="form-select" aria-label="Selecciona un rol" required="required">
					<option value="" selected>Selecciona un rol</option>
				  	<option value="1">Usuario</option>
				  	<option value="2">Admin</option>
				</select>
			    
			    <br/>			    
			    
			    <button class="w-100 btn btn-lg btn-success" type="submit">Crear cuenta</button>
			  	
			    <br/><br/>
			    
			    <button class="w-100 btn btn-lg btn-primary" type="button" onclick="javascript:irALogin();">Volver</button>
			</form>
			
		</main>
		
		<script>
			function irALogin(){
				location.href = "/login";
			}
		</script>
			
 	</tiles:putAttribute>

</tiles:insertDefinition>