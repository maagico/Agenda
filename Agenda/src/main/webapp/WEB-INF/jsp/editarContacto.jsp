<%@ page contentType="text/html; charset=UTF-8" %>  

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="title">
	
		<c:if test = "${esCreacion}">
			<c:set var = "titulo" value = "Nuevo contacto"></c:set>
		</c:if>
		
		<c:if test = "${!esCreacion}">
			<c:set var = "titulo" value = "Editar contacto"></c:set>
		</c:if>
		
		<title>
			<c:out value = "${titulo}"/>
		</title>
		
	</tiles:putAttribute>
	
	<tiles:putAttribute name="scripts">
		
		<script>
		
			let contadorCampoTelefono = 1;
			let contadorCampoCorreo = 1;

			function addCampoTelefono(telefono){

				let campoTelefonoDiv = "<div class='col-5' id = 'addCampoTelefonoDiv" + contadorCampoTelefono + "'>";
				campoTelefonoDiv +=    "	<div class='form-floating mb-3'>";
				campoTelefonoDiv +=    "		<input name = 'telefonos' type='tel' class='form-control' id='telefono" + contadorCampoTelefono + "' placeholder='Teléfono' maxlength='20' pattern='[0-9]{9}' value = '" + telefono + "'/>";
				campoTelefonoDiv +=    "		<label for='telefono'>Teléfono</label>";
				campoTelefonoDiv +=    "	</div>";
				campoTelefonoDiv +=    "</div>";
				
				let enlaceCampoTelefono = "<div class='col-5' id = 'addOtroTelefonoDiv" + contadorCampoTelefono + "'>";
				enlaceCampoTelefono +=    "		<a class='nav-link color-rojo quitarCampoTelefono'  id = 'quitarTelefono' href = 'javascript:quitarCampoTelefono(" + contadorCampoTelefono + ");'>";
				enlaceCampoTelefono +=    "			Quitar teléfono ";
				enlaceCampoTelefono +=    "  		<i class='bi bi-plus-circle-fill' title='Quitar teléfono'></i>";
				enlaceCampoTelefono +=    "  	</a> Introducir 9 dígitos ";
				enlaceCampoTelefono +=    "</div>";

				$("#addOtroTelefonoDiv").after(campoTelefonoDiv + enlaceCampoTelefono);

				contadorCampoTelefono++;
			}

			function addCampoCorreo(correo){

				let campoCorreoDiv = "<div class='col-5' id = 'addCampoCorreoDiv" + contadorCampoCorreo + "'>";
				campoCorreoDiv +=    "	<div class='form-floating mb-3'>";
				campoCorreoDiv +=    "		<input type='email' name = 'correos' class='form-control' id = 'correo" + contadorCampoCorreo + "' placeholder='Correo' maxlength='20'' value = '" + correo + "'>";
				campoCorreoDiv +=    "		<label for='correo'>Correo electrónico</label>";
				campoCorreoDiv +=    "	</div>";
				campoCorreoDiv +=    "</div>";
				
				let enlaceCampoCorreo = "<div class='col-5' id = 'addOtroCorreoDiv" + contadorCampoCorreo + "'>";
				enlaceCampoCorreo +=    "		<a class='nav-link color-rojo' href = 'javascript:quitarCampoCorreo(" + contadorCampoCorreo + ");'>";
				enlaceCampoCorreo +=    "			Quitar correo ";
				enlaceCampoCorreo +=    "  		<i class='bi bi-plus-circle-fill' title='Quitar correo'></i>";
				enlaceCampoCorreo +=    "  	</a>";
				enlaceCampoCorreo +=    "</div>";

				$("#addOtroCorreoDiv").after(campoCorreoDiv + enlaceCampoCorreo);

				contadorCampoCorreo++;
			}

			function quitarCampoTelefono(id){
				
				$("#addCampoTelefonoDiv" + id).remove();
				$("#addOtroTelefonoDiv" + id).remove();
			}

			function quitarCampoCorreo(id){
				
				$("#addCampoCorreoDiv" + id).remove();
				$("#addOtroCorreoDiv" + id).remove();
			}

			function irAListadoContactos(){

				location.href = "/listadoContactos";
			}
			
		</script>
		
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
    	
		<br/>
		<main class="form-signin w-100 m-auto">
		
			<h2>Introduce los datos del nuevo contacto</h2>
		
			<form:form action = "/crearContacto" method = "post" id ="contactoForm" name = "contactoForm"  modelAttribute="crearContactoForm">
			
				<div class="form-floating mb-3">
					<form:input path = "nombre" type="tel" class="form-control" id="nombre" placeholder="Nombre" required = "required"/>
				  	<label for="nombre">Nombre*</label>
				</div>
				
				<div class="form-floating mb-3">
				  	<form:input path = "apellidos" type="text" class="form-control" id="apellidos" placeholder="Apellidos" required = "required"/>
				  	<label for="apellidos">Apellidos*</label>
				</div>
				
				<hr/>
				
				<div class="row g-3">
					
					<c:forEach items = "${crearContactoForm.telefonos}" var = "telefono" varStatus = "loop">
						
						<c:if test = "${loop.index == 0}">
							<div class="col-5">
								
								<div class="form-floating mb-3" id = "campoTelefonoDiv">
								  	
								  	<form:input path = "telefonos" type="tel" class="form-control" id="telefono${loop.index}" placeholder="Teléfono" maxlength="20" pattern="[0-9]{9}" value = "${telefono}"/>
								  	<label for="telefono">Teléfono</label>
								  						
								</div>
								
							</div>
							
							<div class="col-5" id = "addOtroTelefonoDiv">
							
								<a class="nav-link color-verde"  href = "#" id = "addTelefono" onclick = "addCampoTelefono('');return false;">
									Añadir otro teléfono
									<i class="bi bi-plus-circle-fill" title="Añadir otro teléfono"></i>
								</a>
								
									Introducir 9 dígitos
							</div>
						</c:if>
						<script>

							<c:if test  ="${loop.index > 0}">
								addCampoTelefono(${telefono});
							</c:if>
							
						</script>

					</c:forEach>
					
					<hr/>
					
					<c:forEach items = "${crearContactoForm.correos}" var = "correo" varStatus = "loop">
						
						<c:if test = "${loop.index == 0}">
							<div class="col-5">
								
								<div class="form-floating mb-3">
								  	
								  	<form:input path = "correos" type="email" class="form-control" id="correo${loop.index}" placeholder="Correo electrónico" value = "${correo}"/>
								  	<label for="correo">Correo electrónico</label>
								
								</div>
								
							</div>
						
							<div class="col-5" id = "addOtroCorreoDiv">
								
								<a class="nav-link color-verde"  href = "#" id = "addCorreo" onclick = "addCampoCorreo('');return false;">
									Añadir otro correo
									<i class="bi bi-plus-circle-fill" title="Añadir otro correo"></i>
								</a>
						
							</div>
						</c:if>
						<script>

							<c:if test  ="${loop.index > 0}">
								addCampoCorreo('${correo}');
							</c:if>
							
						</script>
						
					</c:forEach>
						
						<div class="row g-3">
					
							<div class="col-6">
							
								<button class="w-100 btn btn-lg btn-primary" type="button" onclick="javascript:irAListadoContactos();">Volver</button>
							
							</div>
							
							<div class="col-6">
								
								<button class="w-100 btn btn-lg btn-success" type="submit">Crear contacto</button>	
							
							</div>
							
						</div>
						
					</div>
					
				</form:form>
				
			</main>
			
 	</tiles:putAttribute>
		
</tiles:insertDefinition>
