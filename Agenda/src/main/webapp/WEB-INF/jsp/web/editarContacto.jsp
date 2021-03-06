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

			$(document).ready(function() {
				
				$("#eliminar").click(function(e){
					
					$("#contactoForm").attr("action", "/web/eliminarContacto");
	            	$("#contactoForm").submit();
	            					
				});

				$("#modificar").click(function(e){
					
					$("#contactoForm").attr("action", "/web/modificarContacto");
	            	$("#contactoForm").submit();
	            					
				});
				
			});
					
			let contadorCampoTelefono = 1;
			let contadorCampoCorreo = 1;

			function addCampoTelefono(telefono){

				let campoTelefonoDiv = "<div class='col-5 addCampoTelefonoDiv' id ='addCampoTelefonoDiv" + contadorCampoTelefono + "'>";
				campoTelefonoDiv +=    "	<div class='form-floating mb-3'>";
				campoTelefonoDiv +=    "		<input name = 'telefonos' type='tel' class='form-control' id='telefono" + contadorCampoTelefono + "' placeholder='Teléfono' maxlength='9' pattern='[0-9]{9}' value = '" + telefono + "'/>";
				campoTelefonoDiv +=    "		<label for='telefono'>Teléfono</label>";
				campoTelefonoDiv +=    "	</div>";
				campoTelefonoDiv +=    "</div>";
				
				let enlaceCampoTelefono = "<div class='col-5 addOtroTelefonoDiv' id = 'addOtroTelefonoDiv" + contadorCampoTelefono + "'>";
				enlaceCampoTelefono +=    "		<a class='nav-link color-rojo quitarCampoTelefono'  id = 'quitarTelefono' href = 'javascript:quitarCampoTelefono(" + contadorCampoTelefono + ");'>";
				enlaceCampoTelefono +=    "			Quitar teléfono ";
				enlaceCampoTelefono +=    "  		<i class='bi bi-x-circle' title='Quitar teléfono'></i>";
				enlaceCampoTelefono +=    "  	</a> Introducir 9 dígitos ";
				enlaceCampoTelefono +=    "</div>";

				$(".addOtroTelefonoDiv:last").after(campoTelefonoDiv + enlaceCampoTelefono);

				contadorCampoTelefono++;
			}

			function quitarCampoTelefono(id){

				$("#addCampoTelefonoDiv" + id).remove();
				$("#addOtroTelefonoDiv" + id).remove();
			}
			
			function addCampoCorreo(correo){
				
				let campoCorreoDiv = "<div class='col-5 addCampoTelefonoDiv' id = 'addCampoCorreoDiv" + contadorCampoCorreo + "'>";
				campoCorreoDiv +=    "	<div class='form-floating mb-3'>";
				campoCorreoDiv +=    "		<input type='email' name = 'correos' class='form-control' id = 'correo" + contadorCampoCorreo + "' placeholder='Correo' maxlength='70'' value = '" + correo + "'>";
				campoCorreoDiv +=    "		<label for='correo'>Correo</label>";
				campoCorreoDiv +=    "	</div>";
				campoCorreoDiv +=    "</div>";
				
				let enlaceCampoCorreo = "<div class='col-5 addOtroCorreoDiv' id = 'addOtroCorreoDiv" + contadorCampoCorreo + "'>";
				enlaceCampoCorreo +=    "		<a class='nav-link color-rojo' href = 'javascript:quitarCampoCorreo(" + contadorCampoCorreo + ");'>";
				enlaceCampoCorreo +=    "			Quitar correo ";
				enlaceCampoCorreo +=    "  		<i class='bi bi-x-circle' title='Quitar correo'></i>";
				enlaceCampoCorreo +=    "  	</a>";
				enlaceCampoCorreo +=    "</div>";

				$(".addOtroCorreoDiv:last").after(campoCorreoDiv + enlaceCampoCorreo);

				contadorCampoCorreo++;
			}

			function quitarCampoCorreo(id){
				
				$("#addCampoCorreoDiv" + id).remove();
				$("#addOtroCorreoDiv" + id).remove();
			}

			function irAListadoContactos(){

				location.href = "<c:url value = '/web/listadoContactos'/>";
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
			
				<h2>Introduce los datos del nuevo contacto</h2>
			
			</c:if>
			
			<c:if test = "${!esCreacion}">
				<h2>Modifica los datos del contacto</h2>
			</c:if>
			
			<form:form action = "/web/crearContacto" method = "post" id ="contactoForm" name = "contactoForm"  modelAttribute="contactoForm">
			
				<form:input path = "id" type="hidden"/>
			
				<div class="form-floating mb-3">
					<form:input path = "nombre" type="tel" class="form-control" id="nombre" placeholder="Nombre" required = "required"/>
				  	<label for="nombre">Nombre*</label>
				</div>
				
				<div class="form-floating mb-3">
				  	<form:input path = "apellidos" type="text" class="form-control" id="apellidos" placeholder="Apellidos" required = "required"/>
				  	<label for="apellidos">Apellidos*</label>
				</div>
							
				<div class="row g-3">
					
					<hr/>
					
					<c:forEach items = "${contactoForm.telefonos}" var = "telefono" varStatus = "loop">
						
						<c:if test = "${loop.index == 0}">
							
							<div class="col-5">
								
								<div class="form-floating mb-3" id = "campoTelefonoDiv">
								  	
								  	<input name = "telefonos" type="tel" class="form-control" id="telefono${loop.index}" placeholder="Teléfono" maxlength="9" pattern="[0-9]{9}" value = "${telefono}"/>
								  	<label for="telefono">Teléfono</label>
								  						
								</div>
								
							</div>
							
							<div class="col-5 addOtroTelefonoDiv">
							
								<a class="nav-link color-verde"  href = "#" id = "addTelefono" onclick = "addCampoTelefono('');return false;">
									Añadir otro teléfono
									<i class="bi bi-plus-circle-fill" title="Añadir otro teléfono"></i>
								</a>
								
									Introducir 9 dígitos
							</div>
						</c:if>
						
						<script>

							<c:if test = "${loop.index > 0}">
								addCampoTelefono('${telefono}');
							</c:if>
							
						</script>

					</c:forEach>
					
					<hr/>
					
					<c:forEach items = "${contactoForm.correos}" var = "correo" varStatus = "loop">
						
						<c:if test = "${loop.index == 0}">
							<div class="col-5">
								
								<div class="form-floating mb-3">
								  	
								  	<input name = "correos" type="email" class="form-control" id="correo${loop.index}" placeholder="Correo" value = "${correo}" maxlength="70"/>
								  	<label for="correo">Correo</label>
								
								</div>
								
							</div>
						
							<div class="col-5 addOtroCorreoDiv">
								
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
					
							<c:if test = "${esCreacion}">
							
								<div class="col-6">
							
							</c:if>
							
							<c:if test = "${!esCreacion}">
							
								<div class="col-4">
							
							</c:if>
					
							
							<button class="w-100 btn btn-lg btn-primary" type="button" onclick="javascript:irAListadoContactos();">Volver</button>
							
							</div>
														
								<c:if test = "${esCreacion}">
								
									<div class="col-6">
								
								</c:if>
								
								<c:if test = "${!esCreacion}">
								
									<div class="col-4">
								
								</c:if>
														
								<c:if test = "${esCreacion}">
									
									<button class="w-100 btn btn-lg btn-success" type="submit">Crear</button>	
								
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
					        	<h5 class="modal-title" id="modalLabel">Eliminar contacto</h5>
					        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      	</div>
					      	
					      	<div class="modal-body">
					       		¿Quieres eliminar el contacto?
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
