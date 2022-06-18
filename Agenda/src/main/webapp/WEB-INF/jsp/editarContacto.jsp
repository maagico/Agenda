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
	
    <tiles:putAttribute name="body">
		<br/>
		<main class="form-signin w-100 m-auto">
		
		<h2>Introduce los datos del nuevo contacto</h2>
		
		<form:form method = "post">
			
			<div class="form-floating mb-3">
				<input type="tel" class="form-control" id="nombre" placeholder="Nombre" required = "required">
			  	<label for="nombre">Nombre</label>
			</div>
			
			<div class="form-floating mb-3">
			  	<input type="text" class="form-control" id="apellidos" placeholder="Apellidos" required = "required">
			  	<label for="apellidos">Apellidos</label>
			</div>
			
			<div class="row g-3">
				
				<div class="col-5">
					
					<div class="form-floating mb-3" id = "campoTelefonoDiv">
					  	
					  	<input type="tel" class="form-control" id="telefono" placeholder="Teléfono" maxlength="20" onblur="mostrarAddTelefono();">
					  	<label for="telefono">Teléfono</label>
					  						
					</div>
					
				</div>
					
				<div class="col-5" id = "addOtroTelefonoDiv">
				
					<a class="nav-link color-verde"  href = "#" id = "addTelefono" onclick = "addCampoTelefono();return false;">
						Añadir otro teléfono
						<i class="bi bi-plus-circle-fill" title="Añadir otro teléfono"></i>
					</a>
				
				</div>
					
				<div class="col-5">
					
					<div class="form-floating mb-3">
					  	
					  	<input type="email" class="form-control" id="correo" placeholder="Correo electrónico">
					  	<label for="correo">Correo electrónico</label>
					
					</div>
					
				</div>
				
				<div class="col-5">
					
					<!-- 
					<i class="bi bi-plus-circle-fill"></i><br>
					 -->
				
				</div>
				
				<button class="text-right btn btn-lg btn-success" type="submit">Crear contacto</button>	
			
			
			</div>
				
			</form:form>
			</main>
			
			<div id = "plantillaCampoTelefono" class = "invisible">
				
				
				
			</div>
			
 	</tiles:putAttribute>
	
	<tiles:putAttribute name="footer">
	
		<script>
		
			let contadorCampoTelefono = 1;
			let contadorCampoCorreo = 1;
			
			function mostrarAddTelefono(){

				let texto = $("#telefono").val();

				if(texto != ""){
				
					$("#addTelefono").removeClass("invisible");
				}else{

					$("#addTelefono").addClass("invisible");
				}
			}

			function addCampoTelefono(){

				let campoTelefonoDiv = "<div class='col-5' id = 'addCampoTelefonoDiv" + contadorCampoTelefono + "'>";
				campoTelefonoDiv +=    "	<div class='form-floating mb-3'>";
				campoTelefonoDiv +=    "		<input type='tel' class='form-control' id='telefono' placeholder='Teléfono' maxlength='20' onblur='mostrarAddTelefono();'>";
				campoTelefonoDiv +=    "		<label for='telefono'>Teléfono</label>";
				campoTelefonoDiv +=    "	</div>";
				campoTelefonoDiv +=    "</div>";
				
				let enlaceCampoTelefono = "<div class='col-5' id = 'addOtroTelefonoDiv" + contadorCampoTelefono + "'>";
				enlaceCampoTelefono +=    "		<a class='nav-link color-rojo quitarCampoTelefono'  id = 'quitarTelefono' href = 'javascript:quitarCampoTelefono(" + contadorCampoTelefono + ");'>";
				enlaceCampoTelefono +=    "			Quitar teléfono ";
				enlaceCampoTelefono +=    "  		<i class='bi bi-plus-circle-fill' title='Quitar teléfono'></i>";
				enlaceCampoTelefono +=    "  	</a>";
				enlaceCampoTelefono +=    "</div>";

				$("#addOtroTelefonoDiv").after(campoTelefonoDiv + enlaceCampoTelefono);

				contadorCampoTelefono++;
			}

			function quitarCampoTelefono(id){
				
				$("#addCampoTelefonoDiv" + id).remove();
				$("#addOtroTelefonoDiv" + id).remove();

				return;
			}
			
		</script>
		
	</tiles:putAttribute>
	
</tiles:insertDefinition>
