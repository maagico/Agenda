<%@ page contentType="text/html; charset=UTF-8" %> 

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<tiles:insertDefinition name="template">
		
	<tiles:putAttribute name="header">
	
		cabecera 1111
		<meta name="viewport" content="width=device-width; initial-scale=1, user-scalable=yes"/>
		
		 	
	</tiles:putAttribute>	 
	
    <tiles:putAttribute name="body">
			
		Cuerpo11
			
 	</tiles:putAttribute>
 	
 	<tiles:putAttribute name="footer">
			
		Pie2222
			
 	</tiles:putAttribute>

</tiles:insertDefinition>