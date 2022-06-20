<%@ page contentType="text/html; charset=UTF-8" %>  

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="title">
	
		<title>Listado de contactos</title>
	
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
	
		<table class="table">
			<thead>
				<tr>
			    	<th scope="col">Nombre</th>
			      	<th scope="col">Apellidos</th>
			      	<th scope="col">Teléfono/s</th>
			      	<th scope="col">Editar contacto</th>
			    </tr>
			  </thead>
		  	  <tbody>
		  	  	
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
					   		<a href = "/web/editarContacto?id=<c:out value = '${contacto.id}'/>"><i class="bi bi-arrow-right"></i></a> 
						</td>
					</tr>
				</c:forEach>
			    
			  </tbody>
		</table>
			
 	</tiles:putAttribute>

</tiles:insertDefinition>
