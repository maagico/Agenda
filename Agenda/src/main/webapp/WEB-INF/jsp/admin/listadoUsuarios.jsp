<%@ page contentType="text/html; charset=UTF-8" %>  

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="title">
	
		<title>Listado de usuarios</title>
	
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
	
		<table class="table">
			<thead>
				<tr>
			    	<th scope="col">Nombre</th>
			    	<th scope="col">Rol</th>
			    	<th scope="col">Editar</th>
			    </tr>
			  </thead>
		  	  <tbody>
		  	  
		  	  	<c:forEach  items="${usuarios}" var = "usuario">
			  		
			  		<tr>
			  			
			   			<td>
			   				<c:out value = "${usuario.usuario}"/>
			   			
			   			</td>
			   			
			   			<td>
			   				
			   				<c:out value = "${usuario.rol.nombre}"/>
			   			
			   			</td>
				   
				    	<td>
					   		
					   		<a href = "/admin/editarUsuario?id=<c:out value = '${usuario.id}'/>"><i class="bi bi-arrow-right"></i></a> 
						
						</td>
						
					</tr>
					
			    </c:forEach>
			    
			  </tbody>
		</table>

			
 	</tiles:putAttribute>

</tiles:insertDefinition>
