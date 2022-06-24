<%@ page contentType="text/html; charset=UTF-8" %>  

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="title">
	
		<title>Listado de usuarios</title>
	
	</tiles:putAttribute>
	
	<tiles:putAttribute name="scripts">
		
		<script>

			$(document).ready(function() {

				$("#eliminar").click(function(e){
					
					$("#usuarioForm").attr("action", "/admin/eliminarUsuario");	
	            	$("#usuarioForm").submit();
	            					
				});
						
			});

			function eliminarUsuario(id){
				
				$("#id").val(id);
				$('#modal').modal('show');	
			}
				
		</script>
		
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
	
		<c:if test = "${mensaje != null}">
			
			<br/>
					
			<div class="alert alert-success" role="alert">
 				
 				<c:out value = "${mensaje}"/>
			
			</div>
				
		</c:if>
	
		<table class="table">
			<thead>
				<tr>
			    	<th scope="col">Usuario</th>
			    	<th scope="col">Ver contactos</th>
			    	<th scope="col">Borrar</th>
			    
			    </tr>
			  </thead>
		  	  <tbody>
		  	  
		  	  	<c:forEach  items="${usuarios}" var = "usuario">
			  		
			  		<tr>
			  			
			   			<td>
			   				<c:out value = "${usuario.usuario}"/>
			   			
			   			</td>					
						
						<td>
					   		
					   		<a href = "/admin/listadoContactos?idUsuario=<c:out value = '${usuario.id}'/>"><i class="bi bi-binoculars-fill"></i></a> 
						
						</td>
						
				    	<td>
					   		
					   		<a href = "#" onclick = "eliminarUsuario(<c:out value = '${usuario.id}'/>)"><i class="bi bi-person-dash-fill"></i></a> 
						
						</td>
						
					</tr>
					
			    </c:forEach>
			    
			  </tbody>
		</table>

		<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
					
		<div class="modal-dialog">
			
			<div class="modal-content">
		    	
		    	<div class="modal-header">
		        	<h5 class="modal-title" id="modalLabel">Eliminar usuario</h5>
		        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      	</div>
		      	
		      	<div class="modal-body">
		       		¿Quieres eliminar el usuario? Se borrarán todos sus contactos
		      	</div>
		      	
		      	<div class="modal-footer">
		        	
		        	<button type="button" class="btn btn-danger" id = "eliminar">Eliminar</button>
		      		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
		        
		      	</div>
		    
		    </div>
		  
		  </div>
		
		</div>
		
		<form:form action = "/admin/eliminarUsuario" method = "post" id ="usuarioForm" name = "usuarioForm"  modelAttribute="usuarioForm">
			
			<form:input path = "id" type="hidden"/>
		
		</form:form>
		
 	</tiles:putAttribute>

</tiles:insertDefinition>
