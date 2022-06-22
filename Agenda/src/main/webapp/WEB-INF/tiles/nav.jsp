<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<nav class="navbar navbar-expand-lg bg-light">
	
	<div class="container-fluid">
	
		<sec:authorize access="hasRole('USUARIO')">
    		
    		<a class="navbar-brand" href="<c:url value='/web/listadoContactos'/>">Agenda web</a>
    	
    	</sec:authorize>
    	
    	<sec:authorize access="hasRole('ADMIN')">
    		
    		<a class="navbar-brand" href="<c:url value='/admin/listadoUsuarios'/>">Agenda admin</a>
    	
    	</sec:authorize>
    	
    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#toggler" aria-controls="toogle" aria-expanded="false">
      		<span class="navbar-toggler-icon"></span>
    	</button>
    	
    	<div class="collapse navbar-collapse" id="toggler">
      		
      		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        	
	        	<li class="nav-item">
	          		
	          		<sec:authorize access="hasRole('USUARIO')">
	          		
	          			<a class="nav-link color-verde" aria-current="page" href="<c:url value='/web/addContacto'/>">
	          				Añadir contacto 
	          				<i class="bi bi-person-plus"></i>
	          			</a>
	          			
	          		</sec:authorize>
	          		<sec:authorize access="hasRole('ADMIN')">
	          		
	          			<a class="nav-link color-verde" aria-current="page" href="<c:url value='/admin/addUsuario'/>">
	          				Añadir usuario 
	          				<i class="bi bi-person-plus"></i>
	          			</a>
	          			
	          		</sec:authorize>
	          		
	        	</li>
	        	
	        	<li class="nav-item">
	          		
	          		<a class="nav-link color-rojo" aria-current="page" href="<c:url value='/logout'/>">
	          			Logout
	          			<i class="bi bi-box-arrow-left"></i>
	          		</a>
	        	</li>
	        	
      		</ul>
      		
      		<c:if test = "${mostrarDeseleccionarBusqueda}">
      			
      			<span class = "busqueda-web">
      			
      				<a class = "nav-link color-verde" href="<c:url value='/web/listadoContactos'/>">
      					Quitar búsqueda
      				</a>
      			</span>
      		
      		</c:if>
      		
      		<sec:authorize access="hasRole('USUARIO')">
      			<c:set var = "placeBusqueda" value="Por nombre o apellidos"/>
      		</sec:authorize>
      		
      		<sec:authorize access="hasRole('ADMIN')">
      			<c:set var = "placeBusqueda" value="Por nombre o rol"/>
      		</sec:authorize>
      		
      		<form id = "buscarForm"  name = "buscarForm" class="d-flex" role="search" action="/web/buscarContactos" method="get">
        		
        		<input class="form-control me-2" type="search" placeholder="${placeBusqueda}" aria-label="Buscar" id = "textoABuscar" name = "textoABuscar"/>
        		<button class="btn btn-outline-success" type="submit">Buscar</button>
      		
      		</form>
      		
    	</div>
    	
  	</div>
  	
</nav>