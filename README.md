# Agenda
## _Otra simple agenda más_
Apicación web Agenda hecha en Java para probar varias tecnologías:

#### Front:
- JSP
- HMTL5
- CSS3
- Bootstrap
- JavaScript
- JQuery

#### Back:
- Spring Boot
- Sring MVC
- Spring Security
- Tiles
- Lombok
- JPA

### Ejecución

Se despliega en un Tomcat y en una base de datos H2 en memoria, cargada en cada arranque de la aplicación con los datos que hay en el fichero data.sql del directorio resources.

Para levantar la aplicación primero crear el archivo war con el comando:

```sh
mvn package
```
Una vez creado el war(que tendrá el nombre _Agenda-0.0.1-SNAPSHOT.war_) ejecutar desde línea de comandos:

```sh
java -jar Agenda-0.0.1-SNAPSHOT.war
```

Una vez levantada se ejecutará en el navegador en la ruta:

```sh
http://localhost:8080/
```

### Usuario, password y rol
Hay 3 usuarios creados, 2 con rol USUARIO y otro con rol ADMIN:

- usuario:usuario:USUARIO
- usuario1:usuario1:USUARIO
- admin:admin:ADMIN

La aplicación permite crear tantos usuarios como sean necesarios.

### Imágenes

Login:

![Login de la agenda](/Agenda/assets/imagenes/login.png)

Crear un nuevo usuario:

![Creación de usuario](/Agenda/assets/imagenes/crear_usuario.png)

Una vez logueado con un usuario con rol _USUARIO_ veremos sus contactos:

![Login de la agenda](/Agenda/assets/imagenes/listado_contactos.png)

Pantalla de edición de un contacto:

![Login de la agenda](/Agenda/assets/imagenes/modificar_contacto.png)

Pantalla de inicio de un usuario con rol _ADMIN_ en la que vemos todos los usuarios de la aplicación:

![Login de la agenda](/Agenda/assets/imagenes/listado_usuarios.png)

Listado de contactos de un usuario:

![Login de la agenda](/Agenda/assets/imagenes/listado_contactos_usuario.png)

### Licencia

MIT
