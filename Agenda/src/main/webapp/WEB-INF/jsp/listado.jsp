<%@ page contentType="text/html; charset=UTF-8" %>  

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="title">
	
		<title>Listado</title>
	
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
	
		<table class="table">
			<thead>
				<tr>
			    	<th scope="col">Nombre</th>
			      	<th scope="col">Apellidos</th>
			      	<th scope="col">Teléfono</th>
			      	<th scope="col">Editar</th>
			    </tr>
			  </thead>
		  	  <tbody>
			  	<tr>
			   		<td>Mark</td>
				    <td>Otto</td>
				    <td>555550987</td>
				    <td>
				    	<a href = "#">
					    	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
		  						<path fill-rule="evenodd" d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
							</svg>
						</a>
					</td>
			    </tr>
			  </tbody>
		</table>

			
 	</tiles:putAttribute>

</tiles:insertDefinition>
