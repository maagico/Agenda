<%@ page contentType="text/html; charset=UTF-8" %>  

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="title">
	
		<c:if test = "${esCreacion}">
			<c:set var = "titulo" value = "Nuevo usuario"></c:set>
		</c:if>
		
		<c:if test = "${!esCreacion}">
			<c:set var = "titulo" value = "Editar usuario"></c:set>
		</c:if>
		
		<title>
			<c:out value = "${titulo}"/>
		</title>
		
	</tiles:putAttribute>
	
	<tiles:putAttribute name="scripts">
		
		<script>

			$(document).ready(function() {
				
				$("#eliminar").click(function(e){
					
					$("#usuarioForm").attr("action", "/admin/eliminarUsuario");
	            	$("#usuarioForm").submit();
	            					
				});

				$("#modificar").click(function(e){
					
					$("#usuarioForm").attr("action", "/admin/modificarUsuario");
	            	$("#usuarioForm").submit();
	            					
				});
				
			});
					
			function irAListadoUsuarios(){

				location.href = "/admin/listadoUsuarios";
			}

		</script>
		
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
    	
    	<br/>
    	
    	<c:if test = "${mensaje != null}">
				
			<div class="alert alert-success" role="alert">
 				
 				<c:out value = "${mensaje}"/>
			
			</div>
				
		</c:if>
    	
		<main class="form-signin w-100 m-auto">
		
			<c:if test = "${esCreacion}">
			
				<h2>Introduce los datos del nuevo usuario</h2>
			
			</c:if>
			
			<c:if test = "${!esCreacion}">
				<h2>Modifica los datos del usuario</h2>
			</c:if>
			
			<form:form action = "/web/crearUsuario" method = "post" id ="usuarioForm" name = "usuarioForm"  modelAttribute="usuarioForm">
			
				<form:input path = "id" type="hidden"/>
			
				<div class="form-floating mb-3">
					<form:input path = "nombre" type="tel" class="form-control" id="nombre" placeholder="Nombre" required = "required"/>
				  	<label for="nombre">Nombre*</label>
				</div>
				
				<div class="form-floating mb-3">
					<form:input path = "password" type="password" class="form-control" id="nombre" placeholder="Password" required = "required"/>
				  	<label for="nombre">Password*</label>
				</div>
				
				<div class="form-floating mb-3">
				  	
				  	<form:errors path="roleId" cssClass="color-rojo"/>
			   	  
			    		<form:select id = "roleId" path = "roleId" class="form-select" aria-label="Selecciona un rol" required="required">
					
							<form:option value="" label="Selecciona un rol*..."/>
							<form:options items="${roles}" itemValue="id" itemLabel="nombre"/>
				
						</form:select>

				  	
				</div>
												
				<div class="row g-3">
			
					<c:if test = "${esCreacion}">
					
						<div class="col-6">
					
					</c:if>
					
					<c:if test = "${!esCreacion}">
					
						<div class="col-4">
					
					</c:if>
			
					
					<button class="w-100 btn btn-lg btn-primary" type="button" onclick="javascript:irAListadoUsuarios();">Volver</button>
					
					</div>
												
						<c:if test = "${esCreacion}">
						
							<div class="col-6">
						
						</c:if>
						
						<c:if test = "${!esCreacion}">
						
							<div class="col-4">
						
						</c:if>
												
						<c:if test = "${esCreacion}">
							
							<button class="w-100 btn btn-lg btn-success" type="submit">Crear contacto</button>	
						
						</c:if>
						
						<c:if test = "${!esCreacion}">
						
							<button class="w-100 btn btn-lg btn-danger" type="button" data-bs-toggle="modal" data-bs-target="#modal">eliminar</button>	
							
						</c:if>
						
					</div>
					
					<c:if test = "${!esCreacion}">
						
						<div class="col-4">
						
							<button class="w-100 btn btn-lg btn-success" type="submit" id = "modificar">Modificar</button>	
						
						</div>
							
					</c:if>
					
				</div>
				
			</div>
			
		</form:form>
				
				<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
					
					<div class="modal-dialog">
						
						<div class="modal-content">
					    	
					    	<div class="modal-header">
					        	<h5 class="modal-title" id="modalLabel">Eliminar usuario</h5>
					        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      	</div>
					      	
					      	<div class="modal-body">
					       		¿Quieres eliminar el usuario?
					      	</div>
					      	
					      	<div class="modal-footer">
					        	
					        	<button type="button" class="btn btn-danger" id = "eliminar">Eliminar</button>
					      		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
					        
					      	</div>
					    
					    </div>
					  
					  </div>
					
					</div>
				
		</main>
			
 	</tiles:putAttribute>
		
</tiles:insertDefinition>
