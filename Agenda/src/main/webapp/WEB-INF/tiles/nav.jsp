<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg bg-light">
	
	<div class="container-fluid">
    	<a class="navbar-brand" href="<c:url value='/listadoContactos'/>">Agenda</a>
    	
    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#toggler" aria-controls="toogle" aria-expanded="false">
      		<span class="navbar-toggler-icon"></span>
    	</button>
    	
    	<div class="collapse navbar-collapse" id="toggler">
      		
      		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        	
	        	<li class="nav-item">
	          		<a class="nav-link color-verde" aria-current="page" href="<c:url value='/addContacto'/>">
	          			Añadir contacto 
	          			<i class="bi bi-person-plus"></i>
	          		</a>
	        	</li>
	        	
	        	<li class="nav-item">
	          		
	          		<a class="nav-link color-rojo" aria-current="page" href="<c:url value='/logout'/>">
	          			Logout
	          			<i class="bi bi-box-arrow-left"></i>
	          		</a>
	        	</li>
	        	
      		</ul>
      		
      		<form:form class="d-flex" role="search" action="/buscarContacto">
        		
        		<input class="form-control me-2" type="search" placeholder="Buscar contacto" aria-label="Buscar">
        		<button class="btn btn-outline-success" type="submit">Buscar</button>
      		
      		</form:form>
      		
    	</div>
    	
  	</div>
  	
</nav>