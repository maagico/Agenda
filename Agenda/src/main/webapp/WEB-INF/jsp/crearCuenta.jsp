<%@ page contentType="text/html; charset=UTF-8" %> 

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			
			<form:form id = "crearCuentaForm" action = "/crearCuenta" method="post" modelAttribute= "crearCuentaForm">
				
				
				
				<h1 class="h3 mb-3 fw-normal">Introduce tus datos para crear la cuenta</h1>
			    
			    <form:errors path="usuario" cssClass="color-rojo"/>
			    
			    <div class="form-floating">
			   	  
			   	  <form:input id="usuario" path = "usuario" type="text" class="form-control" placeholder="Usuario" maxlength="20" required="required"/>
			      <label for="usuario">Usuario</label>
			    
			    </div>
			   	
			   	<br/>
		
			    <form:errors path="password" cssClass="color-rojo"/>
			    
			    <div class="form-floating">
			      <form:input id="password" path = "password" type="password" class="form-control" placeholder="Password" maxlength="20" required="required"/>
			      <label for="password">Password</label>
			    </div>   
                
			    <br/>
			    
			    
			   	<form:errors path="roleId" cssClass="color-rojo"/>
			   	  
			    <form:select id = "roleId" path = "roleId" class="form-select" aria-label="Selecciona un rol" required="required">
					
					<form:option value="" label="Selecciona un rol..."/>
					<form:options items="${roles}" itemValue="id" itemLabel="nombre"/>
				
				</form:select>
			    
			    <br/>
			    
			    <button class="w-100 btn btn-lg btn-success" type="submit">Crear cuenta</button>
			  	
			    <br/><br/>
			    
			    <button class="w-100 btn btn-lg btn-primary" type="button" onclick="javascript:irALogin();">Volver</button>
			
			</form:form>
			
		</main>
		
		<script>
			function irALogin(){
				location.href = "/login";
			}
		</script>
			
 	</tiles:putAttribute>

</tiles:insertDefinition>