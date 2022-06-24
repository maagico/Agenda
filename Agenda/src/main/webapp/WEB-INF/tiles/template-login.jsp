<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<fmt:setLocale value="es_ES" scope="session"/>

<!DOCTYPE html>
<html lang="es">
	
	<head>
		
		<tiles:insertAttribute name="title"/>
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="header-resources"/>
		
		<link href="css/css.css?1" rel="stylesheet">
	</head>
	
	<body>
		<div class = "container">
		
		    <tiles:insertAttribute name="body"/>
		    <tiles:insertAttribute name="footer"/>	 			    	    
		   		
	    </div>
	    
	</body>
    	
</html>