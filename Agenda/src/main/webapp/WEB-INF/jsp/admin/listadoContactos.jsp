<%@ page contentType="text/html; charset=UTF-8" %>  

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="title">
	
		<title>Listado de contactos</title>
	
	</tiles:putAttribute>
	
	<tiles:putAttribute name="scripts">
		
		<script>

			function irAListadoUsuarios(){

				location.href = "/admin/listadoUsuarios";
			}
			
		</script>
		
	</tiles:putAttribute>
		
    <tiles:putAttribute name="body">
		
		<table class="table">
			<thead>
				<tr>
			    	<th scope="col">Nombre</th>
			      	<th scope="col">Apellidos</th>
			      	<th scope="col">Teléfono/s</th>
			      	<th scope="col">Correo/s</th>
			    </tr>
			  </thead>
		  	  <tbody>
		  	  	
		  	  	<c:if test = "${numeroContactos == 0}">
		  	  		
		  	  		<tr>
		  	  			<td colspan="5">No hay contactos</td>
		  	  		</tr>
		  	  		
		  	  	</c:if>
		  	  			  	  	
		  	  	<c:forEach items="${contactos}" var="contacto">
			  		
			  		<tr>
				   		<td><c:out value = "${contacto.nombre}"/></td>
					    <td><c:out value = "${contacto.apellidos}"/></td>
					    
					    <td>
					    	
					    	<c:forEach items="${contacto.telefonos}" var="telefono">
					    		<c:out value = "${telefono.numero}"/><br/>
					    	</c:forEach>
					    	
					    </td>
					    
					    <td>
					    	
					    	<c:forEach items="${contacto.correos}" var="correo">
					    		<c:out value = "${correo.correo}"/><br/>
					    	</c:forEach>
					    	
					    </td>
					    
					</tr>
				</c:forEach>
			    
			  </tbody>
		</table>
			
		<button class="w-100 btn btn-lg btn-primary" type="button" onclick="javascript:irAListadoUsuarios();">Volver</button>
										
 	</tiles:putAttribute>

</tiles:insertDefinition>
