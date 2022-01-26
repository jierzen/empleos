# Curso Spring Boot 2 & Spring Framework 5 MVC

## SECCION 1: Spring Boot - Introducción

### ¿Qué es Spring Boot?

* Es un subproyecto de Spring Framework que busca facilitar la creación de proyectos eliminando la necesidad de configurar extensos archivos XML.
* Spring Boot provee configuraciones por defecto para la mayoría de las tecnologías usadas (Spring MVC, Spring Data JPA & Hibernate, Spring Security, Spring REST, etc).
* Spring Boot administra las dependencias (archivos JAR y versiones compatibles).
* Spring Boot provee un modelo de programación parecido a las aplicaciones java tradicionales que inician en el método main.

### Funcionamiento de Spring Boot

Los procesos de desarrollo de una aplicación en términos generales consiste en:

1. Seleccionar dependencias Maven compatibles.
2. Programar la aplicación.
3. Realizar el deployment en el servidor.

Spring Boot simplifica los pasos 1 y 3 del proceso, para enfocarse en el paso 2 de desarrollo de programación. Al simplificar el proceso de desarrollo Spring Boot permite:

* Crear aplicaciones Stand-Alone (independientes) con Spring.
* Incluye servidor web embebido Apache Tomcat (puede cambiarse por Jetty o Undertow).
* Se requiere una mínima configuración ya que las tecnologías ya se incluyen con valores por defecto.

### Instalación de Java SE Development Kit 11 (JDK)

1. Navega a la [página oficial](https://www.oracle.com/cl/java/technologies/javase/jdk11-archive-downloads.html) de Oracle para descargar e instalar el JDK (11.0.12 del Java SE Development Kit, fecha 16-11-2021).

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\JDK pagina de descarga 16-11-2021.png)

2. Crea una nueva `variable de entorno del sistema` llamada JAVA_HOME que contenga la ruta del JDK instalada, en este caso es `C:\Program Files\Java\jdk-11.0.12`.

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Variable de entorno JDK.png)

3. Edita la `variable de entorno del sistema` llamada Path agregando la ruta `%JAVA_HOME%\bin`.

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Variable de entorno JDK path.png)

4. Realiza la comprobación del JDK en `cmd` con los comandos `echo %JAVA_HOME%` y `javac -version`.

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Comprobacion del JDK.png)

5. Reinicia el equipo.

### Instalación de Spring Tools IDE

Está basado en Eclipse

1. Ir a este [link](https://spring.io/tools) que es la pagina oficial de Spring.

2. Descargar el archivo para el sistema operativo correspondiente, en este caso es Windows 10.

   ![IDE](D:\Spring Boot Udemy\Apuntes\imagenes\IDE descargar.png)

3. Mueve y extrae el contenido del archivo .jar la carpeta en `C:` (si no puede abrir el archivo se deberá instalar [Java Runtime Environment](https://www.java.com/es/download/), con se extraerá sin problemas) y se creará la carpeta STS donde estará ubicado el IDE.

4. Entra en la carpeta del IDE y edita el archivo `SpringToolSuite4.ini` para asignar la ruta `C:\Program Files\Java\jdk-11.0.12\bin\javaw.exe` después del `-vm` y antes del `-vmargs` (debe coincidir con la ruta del JDK instalado [antes](###Instalación de Java SE Development Kit 11 (JDK))). 

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Ruta en archivo ini de Spring Boot.png)

4. Iniciar el ejecutable de Spring Boot. Se abrirá un cuadro de diálogo para asignar la ruta del WorkSpace o directorio de los proyectos por defecto. En este caso se usa la ruta `C:\WorkSpace` y el IDE creará la carpeta llamada WorkSpace. Chequear opción de recordar el directorio.

   <img src="D:\Spring Boot Udemy\Apuntes\imagenes\WorkSpace IDE.png" style="zoom:67%;" />

### Crear proyecto en Spring Initializr

1. Navegar a Spring Initializr mediante este [link](https://start.spring.io/) para seleccionar las siguientes opciones. (NOTA: En la parte final seleccionar la versión del JDK instalada en el equipo).

   <img src="D:\Spring Boot Udemy\Apuntes\imagenes\Spring Initializr parte 1.png" style="zoom:67%;" />

2. En las dependencias buscar y agregar la dependencia Web 

   <img src="D:\Spring Boot Udemy\Apuntes\imagenes\Spring Initializr parte 2.png" style="zoom:67%;" />

3. Presiona botón `Generate` para guardar el archivo en formato `.zip`.

4. Si tienes el IDE iniciado es necesario cerrarlo por completo y luego extraer el archivo `.zip` (descargado en el paso anterior) en el directorio WorkSpace.

4. Iniciar el IDE y para importar el proyecto ir a `File > Import > Maven > Existing Maven Projects`.

5. Seleccionar en `Browse` el directorio del proyecto para detectar el archivo `pom.xml`. Presionar botón `Finish` para que el IDE descargue las dependencias necesarias para el proyecto (en este caso solamente la dependencia Web). En la parte inferior derecha se verá el progreso de la descarga.

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\IDE importar proyecto porcentaje descarga.png)

### Iniciar y detener un proyecto

Configuración inicial: Para que la versión Java del proyecto coincida con la versión instalada en el equipo clic secundario al `JRE System Library > Properties > WorkSpace Default JRE (jdk-11.0.12)` y aplicar la configuración.

![](D:\Spring Boot Udemy\Apuntes\imagenes\Asignar version actual de JDK al proyecto.png)

Si tu puerto 8080 está ocupado, podrás cambiarlo en `src/main/resources > application.properties` y escribir la línea:

```java
server.port=7070
```

![](D:\Spring Boot Udemy\Apuntes\imagenes\Cambiar puerto del servidor del proyecto.png)

* Para iniciar el proyecto ir a la zona inferior izquierda del IDE y utilizar el botón `Start or restart`. Si desea detener el proyecto usar botón `Stop`. NOTA: En la imagen se observa una flecha verde apuntando hacia arriba, significa que el proyecto está andando.

  ![](D:\Spring Boot Udemy\Apuntes\imagenes\Iniciar o detener un proyecto.png)

* Para realizar la comprobación de funcionamiento de la aplicación inicia un navegador y dirígete a `http://localhost:8080` donde debe aparecer el error 404. Este error hace referencia a que el servidor Apache Tomcat de nuestra aplicación esta funcionando en blanco.

  <img src="D:\Spring Boot Udemy\Apuntes\imagenes\Error 404 de apache confirmando el funcionamiento del servidor.png" style="zoom:67%;" />

* Si se detiene el proyecto y refresca la pagina aparecerá una nueva información con el mensaje de que "No se puede acceder a este sitio", lo que confirma el funcionamiento correcto de Apache Tomcat.

  <img src="D:\Spring Boot Udemy\Apuntes\imagenes\Comprobacion de no funcionamiento de Apache Tomcat.png" style="zoom: 50%;" />

### Crear un controlador

El directorio del `src/main/java` contendrá las clases java. Al momento de importar el proyecto se creó automáticamente un paquete llamado `net.jorge.holaMundo` el cual contiene el archivo principal `HolaMundoApplication.java` donde se inicia el proyecto.

Para crear un controlador hacemos clic secundario sobre el paquete `net.jorge.holaMundo > New > Package` y lo llamaremos `net.jorge.holaMundo.controller`. Para crear nuestro primer controlador hacemos `clic secundario sobre este nuevo paquete > New > Class` y lo nombramos `HomeController` en el cual escribiremos el siguiente código:

```java
package net.jorge.holaMundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String Inicio() {
		return "Hola Mundo";
	}

}
```

De esta manera el método `Inicio()` se ejecutará cuando hagamos una petición HTTP tipo `GET` a la url `/` que es el directorio raíz de la aplicación. Iniciamos el proyecto y navegamos a `http://localhost:7070/` y obtenemos:

![](D:\Spring Boot Udemy\Apuntes\imagenes\holaMundo inicial.png)



***



## SECCION 2: Spring Boot y Thymeleaf - Introducción

### Spring MVC

Es un modulo de Spring Framework que permite crear aplicaciones implementando la arquitectura Modelo Vista Controlador. Internamente utiliza servlets para procesar las peticiones de los usuarios. Está diseñado con el patrón de diseño Front Controller el cual es un servlet llamado Dispatcher Servlet. El Front Controller también se encarga de enviar las peticiones (request) a los manejadores (handlers) para que sean procesadas.

* Modelo: son los datos de la aplicación, por lo general son clases Java (llamados comúnmente beans).
* Vista: interfaz grafica que el usuario recibe a trabes de su navegador de internet. Por lo general es código HTML.
* Controlador: son clases especiales destinadas a procesar todas las peticiones HTTP de los usuarios y generar el modelo que será renderizado en el navegador de internet.

### Thymeleaf

Es una librería de Java que implementa un motor de plantillas para aplicaciones web. Aplica procesamiento a los archivos HTML para producir contenido web. Suele utilizarse con Spring Boot para generar vistas con código HTML para aplicaciones web. En el archivo `pom.xml` podemos ver la dependencia de Thymeleaf:

```java
<dependency> 
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

Para utilizar la libreria de Thymeleaf hay que poner el namespace en la vista. Veremos el ejemplo de una vista llamada `home.html` que muestra un mensaje contenido en una variable llamada ***mensaje*** del controlador llamado `HomeController.java`:

`home.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"><!-- Aca esta el namespace-->
<head>
<meta charset="UTF-8">
<title>Titulo</title>
</head>
<body>
<h1 th:text="${mensaje}"></h1><!-- Despliega el mensaje contenido en la variable del controlador-->
</body>
</html>
```

`HomeController`:

```java
@Controller
public class HomeController {
    
	@GetMapping("/")
	public String mostrarHome(Model model) {
	model.addAttribute("mensaje", "Hola Mundo"); //
	return "home";
	}
}
```

### Creación del proyecto base Empleos

Creamos el proyecto tal como el proyecto anterior pero con los siguientes datos:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Crear proyecto empleos Spring Initializr.png)

NOTA: las dependencias son Web, Thymeleaf y Spring Boot DevTools. Debemos importar el proyecto según lo vimos [mas arriba](###Crear-proyecto-en-Spring-Initializr).

### Anotación @Controller: ¿Qué es un Controlador en Spring MVC?

Un controlador (controller) es una clase Java normal a la cual le hemos agregado la anotación `@Controller`. Dentro de esta clase podemos tener uno o más métodos los cuales tienen anotaciones como `@GetMapping`, `@PostMapping` y `@RequestMapping`. Estas anotaciones por lo general llevan un parámetro de tipo `String` que es la URL a la cual estarán mapeados estos métodos. El siguiente código de ejemplo muestra un controlador con el método `mostrarHome()` que retorna una cadena y se activará al visitar la URL `http://localhost:7070/miURL` mostrando como resultado la vista `home.html` ubicada en el directorio `src/main/resources/templates`. Nótese que la cadena "home" retornada por el método no se concatena con ".html" gracias a Thymeleaf.

```java
@Controller

public class HomeController{
    @GetMapping("/miURL")
    public String mostrarHome(){
        //lógica de negocio
        return "home";
    }
}

```

TIP: Indentar código en Spring Boot IDE: `CTRL` + `SHIFT` + `F`

### Encontrar plantillas HTML

Existe la posibilidad de no encontrar la plantilla HTML para las vistas en `New > Other > Other > HTML File`. Para solucionarlo debemos buscar el plugin de Thymeleaf en `Help > Eclipse Marketplace` y buscar "thymeleaf" para instalarlo.

![](D:\Spring Boot Udemy\Apuntes\imagenes\Encontrar plantillas HTML en Spring Boot.png)

Aceptamos el acuerdo de licencia.

<img src="D:\Spring Boot Udemy\Apuntes\imagenes\Encontrar plantillas HTML en Spring Boot parte 2.png" style="zoom:67%;" />

Se necesita reiniciar Spring Boot IDE.

### Creación del controlador HomeController para el proyecto Empleos

1. Creamos un paquete llamado `net.jorge.controller` y dentro creamos una clase Java llamada `HomeController` con el siguiente código:

   ```java
   package net.jorge.controller;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.GetMapping;
   
   @Controller
   public class HomeController {
   
   	@GetMapping("/")
   	public String mostrarHome() {
   		return "home";
   	}
   }
   ```

   Al ingresar a `http://localhost:7070` seremos redirigidos a la vista (archivo HTML) llamada `home.html`, que crearemos en el siguiente paso.

2. Creamos la plantilla HTML `home.html` que será una vista en el directorio `src/main/resources/templates` destinado para ellas:

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Crear plantilla HTML parte 1.png)

   <img src="D:\Spring Boot Udemy\Apuntes\imagenes\Crear plantilla HTML parte 2.png" style="zoom:67%;" />

   <img src="D:\Spring Boot Udemy\Apuntes\imagenes\Crear plantilla HTML parte 3.png" style="zoom:67%;" />

3. El archivo `home` tendrá este código:

   ```html
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="ISO-8859-1">
   <title>Página principal</title>
   </head>
   <body>
   	<h1>Bienvenido a Empleos App</h1>
   </body>
   </html>
   ```

   El resultado deberá verse así:

   <img src="D:\Spring Boot Udemy\Apuntes\imagenes\Vista home html.png" style="zoom:60%;" />

   

### Agregar datos al modelo para desplegarlo en la vista

NOTA: Para incrementar o reducir el tamaño de la letra del código en Spring Boot IDE utiliza las teclas `CTRL` +`SHIFT` + `(+/-)`

NOTA: Para importar código en Spring Boot IDE utiliza las teclas `CTRL` + `SHIFT` + `O`.

1. En `HomeController` agregar al método `mostrarHome` (el nombre del método puede ser otro) un parámetro de tipo ***Model*** el cual tiene un método `addAttribute(String attributeName, Object attributeValue) : Model - Model` que utilizaremos para enviar datos a la vista. Generaremos el atributo ***mensaje*** que contiene el String "Bienvenidos a Empleos App" y el atributo ***fecha*** que contiene la fecha actual.

   ```java
   package net.jorge.controller;
   
   import java.util.Date;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.ui.Model;
   import org.springframework.web.bind.annotation.GetMapping;
   
   @Controller
   public class HomeController {
   
   	@GetMapping("/")
   	public String mostrarHome(Model model) {
   		model.addAttribute("mensaje", "Bienvenidos a Empleos App");
   		model.addAttribute("fecha", new Date());
   		return "home";
   	}
   }
   
   ```

2. En la vista `home.html` agregamos la línea `xmlns:th="http://www.thymeleaf.org"` al tag inicial `<html>` para poder utilizar Thymeleaf. Luego dentro del tag `<h1>` agregamos la línea `th:text="${mensaje}"` para obtener el atributo ***mensaje*** del controlador, el cual reemplazará a todo lo que esté entre los tags de apertura y cierre de `<h1>`. En este ejemplo, el texto "Bienvenido a Empleos" será reemplazado por "Bienvenido a Empleos App". La misma lógica aplica para el tag `<h2>` pero de otra manera en la cual utilizamos doble corchete fuera del tag:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
   <head>
   <meta charset="ISO-8859-1">
   <title>Pagina principal</title>
   </head>
   <body>
   	<h1 th:text="${mensaje}">Bienvenido a Empleos</h1>
   	<h2>Hoy es [[${fecha}]]</h2>
   </body>
   </html>
   ```

   Este es el resultado

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Vista home html con atributos traidos del controlador.png)

   

### Configurar la plantilla HTML con el namespace de Thymeleaf por defecto

Al momento de crear un nuevo archivo HTML es preciso incorporar el namespace de Thymeleaf por defecto cada vez que una vista sea creada. Para ello debemos configurar las plantillas HTML en `Window > Preferences > Web > HTML Files > Editor > Templates` y en la tabla que muestra las plantillas seleccionar `New HTML file (5) > Edit...` y escribir el namespace.

![](D:\Spring Boot Udemy\Apuntes\imagenes\Configuracion plantilla HTML con namespace de Thymeleaf por defecto.png)

### Agregar tipos de datos simples al modelo y desplegarlos en la vista

Modificaremos el `HomeController` agregando los tipos de dato `String`, `Date`, `double` y `boolean` al ***Model***.

```java
package net.jorge.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		 * model.addAttribute("mensaje", "Bienvenidos a Empleos App");
		 * model.addAttribute("fecha", new Date());
		 */
		String nombre = "Auxiliar Contable";
		Date fechaPub = new Date();
		double salario = 9000.0;
		boolean vigente = true;

		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		return "home";
	}
}
```

Luego en `home.html` los mostraremos con Thymeleaf de esta manera:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Pagina principal</title>
</head>
<body>
	<!-- 	<h1 th:text="${mensaje}">Bienvenido a Empleos</h1> -->
	<!-- 	<h2>Hoy es [[${fecha}]]</h2> -->
	<h1>Bienvenido</h1>
	<h2>Oferta de trabajo</h2>
	<h3 th:text="'Titulo:' + ${nombre}"></h3>
	<h3 th:text="'Fecha Pub:' + ${fecha}"></h3>
	<h3 th:text="'Salario ofrecido:' + ${salario}"></h3>
	<h3 th:text="'Vigente:' + ${vigente}"></h3>
</body>
</html>
```

El resultado de `http://localhost:7070` es: 

![](D:\Spring Boot Udemy\Apuntes\imagenes\Vista home html de los atributos traidos del controlador.png)

### Iteraciones en Thymeleaf: Expresión `<th:each> `

Es similar a un `for` en Java. La expresión `<th:each> ` puede usarse para iterar sobre diferentes tipos de datos como `List`, `Map` o `Iterable`.

Se observa el controlador `HomeController` en el método `mostrarListado(Model model)`

```java
@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero en Informatica");
		lista.add("Contador");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
	}
```

En la vista `detalle.html` declaramos una variable temporal con nombre (*cualquier nombre sirve*) `tmpEmp` la cual contendrá la lista de ofertas de trabajo. La línea `<li th:each="tmpEmp:${empleos}" th:text="${tmpEmp}"></li>` se interpreta así: ***haz una lista por cada empleo mostrando el texto del empleo***.

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Listado de ofertas de Trabajo</title>
</head>
<body>
	<h1>Vacantes disponibles</h1>
	<ol>
	<li th:each="tmpEmp:${empleos}" th:text="${tmpEmp}"></li>
	</ol>
</body>
</html>
```

El resultado de `http://localhost:7070/listado` es el siguiente:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Vista listado html del listado de ofertas de trabajo traida del controlador.png)

### Crear la clase Vacante para representar una oferta de trabajo

1. Crear un nuevo paquete llamado `net.jorge.model` en el cual crear la clase de Java `Vacantes`.

2. Escribir los atributos a utilizar (importar`java.util.Date` para utilizar el tipo de dato `Date`):

   ```java
   	private Integer id;
   	private String nombre;
   	private String descripcion;
   	private Date fecha;
   	private Double salario;
   ```

3. Creamos los Getter y Setter con `clic derecho > Source > Generate Getters and Setters` y presionar botón `Select All`:

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Generar Getters y Setters.png)

4. Sobre escribimos el método `ToString` (para poder imprimir en la consola todos los valores de los atributos en el método `ToString` un objeto de tipo Vacante) `clic derecho > Source > Generate ToString` para seleccionar los atributos (Fields):

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Sobre escribir el metodo ToString.png)



### Crear un objeto Vacante y desplegarlo en el modelo

1. En HomeController creamos el método `mostrarDetalle` que retornará a la URL `http://localhost:7070/detalle` y agregamos datos a desplegar:

   ```java
   @GetMapping("/detalle")
   	public String mostrarDetalle(Model model) {
   		Vacante vacante = new Vacante();
   		vacante.setNombre("Ingeniero Informatico");
   		vacante.setDescripcion("Se necesita ingeniero para dar soporte a web");
   		vacante.setFecha(new Date());
   		vacante.setSalario(4500000.0);
   		
   		model.addAttribute("vacante", vacante);
   		
   		return "detalle";
   	}
   ```

2. Creamos una vista llamada `detalle.html` que contenga el código con Thymeleaf para desplegar los datos del objeto `Vacante`:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
   <head>
   <meta charset="ISO-8859-1">
   <title>Detalle oferta</title>
   </head>
   <body>
   	<h1>Detalle de la oferta de trabajo</h1>
   	<h3 th:text="'Nombre: '+${vacante.nombre}"></h3>
   	<h3 th:text="'Descripcion: '+${vacante.descripcion}"></h3>
   	<h3 th:text="'Salario ofrecido: '+${vacante.salario}"></h3>
   	<h3 th:text="'Fecha: '+${vacante.fecha}"></h3>
   </body>
   </html>
   ```

3. El resultado de la URL `http://localhost:7070/detalle` debe ser:

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Resultado mostrar objeto Vacante en la url detalle.png)

### Crear objeto `List<Vacante>` y desplegarlo en el modelo



1. En HomeController creamos el método `getVacantes` con algunos objetos de tipo `Vacante`:

   ```java
   private List<Vacante> getVacantes() {
   		
   	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   	List<Vacante> lista = new LinkedList<Vacante>();
   	try {
   		Vacante vacante1 = new Vacante();
   		vacante1.setId(1);
   		vacante1.setNombre("Ingeniero Espacial");
   		vacante1.setDescripcion("Solicitamos Ing Espacial para diseñar cohete.");
   		vacante1.setFecha(sdf.parse("01-12-2021"));
   		vacante1.setSalario(9500000.0);
           
   		Vacante vacante2 = new Vacante();
   		vacante2.setId(2);
   		vacante2.setNombre("Astronauta");
   		vacante2.setDescripcion("Solicitamos Astronauta para vuelo tripulado.");
   		vacante2.setFecha(sdf.parse("24-11-2021"));
   		vacante2.setSalario(1400000.0);
   
   		Vacante vacante3 = new Vacante();
   		vacante3.setId(3);
   		vacante3.setNombre("Bombero");
   		vacante3.setDescripcion("Solicitamos Bombero para trabajar en Stgo.");
   		vacante3.setFecha(sdf.parse("12-12-2021"));
   		vacante3.setSalario(500000.0);
   
   		Vacante vacante4 = new Vacante();
   		vacante4.setId(4);
   		vacante4.setNombre("Bailarin");
   		vacante4.setDescripcion("Solicitamos Bailarin para programa de TV.");
   		vacante4.setFecha(sdf.parse("22-11-2021"));
   		vacante4.setSalario(900000.0);
   			
   		lista.add(vacante1);
   	    lista.add(vacante2);
   		lista.add(vacante3);
   		lista.add(vacante4);
   		} catch (ParseException e) {
   			// TODO: handle exception
   			System.out.println("Error: " + e.getMessage());
   		}
   	return lista;
   	}
   ```

   

2. En la parte superior del código del HomeController escribimos el método `mostrarTabla` con el siguiente código:

   ```java
   	@GetMapping("/tabla")
   	public String mostrarTabla(Model model) {
   		List<Vacante> lista = getVacantes();
   		model.addAttribute("vacantes", lista);
   		return "tabla";
   	}
   ```

   

3. Dentro de la carpeta de las vistas (`src/main/resources -> templates`) creamos el archivo *tabla.html* con el código para mostrar los registros de las vacantes. Se debe usar Thymeleaf por cada fila (`<tr>`) donde `vacante` será el nombre de una variable a recorrer mientras que `${vacantes}` será el objeto obtenido desde el HomeController en el cual podemos acceder a sus atributos `id`, `nombre`, `fecha`, `salario` y `descripcion`:

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
   <head>
   <meta charset="ISO-8859-1">
   <title>Listado de Vacantes</title>
   </head>
   <body>
   <h1>Lista de Vacantes</h1>
   <table style="width:100%" border="2">
     <tr>
       <th>Id</th>
       <th>Nombre</th>
       <th>Fecha de publicacion</th>
       <th>Salario</th>
       <th>Descripcion</th>
     </tr>
     <tr th:each="vacante: ${vacantes} ">
       <td th:text="${vacante.id}"></td>
       <td th:text="${vacante.nombre}"></td>
       <td th:text="${vacante.fecha}"></td>
       <td th:text="${vacante.salario}"></td>
       <td th:text="${vacante.descripcion}"></td>
     </tr>
   </table>
   </body>
   </html>
   ```

4. El resultado de la URL `http://localhost:7070/tabla` debe ser:

   ![](D:\Spring Boot Udemy\Apuntes\imagenes\Resultado mostrar objeto Lista de Vacantes en la url tabla.png)

### Integrar Bootstrap (vía CDN)

Sirve para aplicar diseño a la aplicación. Debemos navegar a la pagina principal de Bootstrap y buscar la opción Download. Luego copiar el link CDN.:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Bootstrap link de CDN.png)

Pegar la etiqueta `<link>` dentro de la etiqueta `<head>` mientras que la etiqueta `<script>` debe ir antes del cierre de la etiqueta `<body>` en `table.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Listado de Vacantes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>Lista de Vacantes</h1>
<table style="width:100%" border="2">
  <tr>
    <th>Id</th>
    <th>Nombre</th>
    <th>Fecha de publicacion</th>
    <th>Salario</th>
    <th>Descripcion</th>
  </tr>
  <tr th:each="vacante: ${vacantes} ">
    <td th:text="${vacante.id}"></td>
    <td th:text="${vacante.nombre}"></td>
    <td th:text="${vacante.fecha}"></td>
    <td th:text="${vacante.salario}"></td>
    <td th:text="${vacante.descripcion}"></td>
  </tr>

</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
```

Si le agregamos a la tabla la clase `class="table table-striped table-hover table-bordered"` nos quedaría así:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Bootstrap tabla.png)

### Condicionales en Thymeleaf

* Operador `ELVIS`: en este ejemplo `<td th:text="${usuario.estatus == 1} ? 'ACTIVO' : 'BLOQUEADO'"/>` la expresión *activo* se renderizará si la expresión en Thymeleaf es verdadera y en caso contrario se renderizará *bloqueado*.

* Operador `if - unless`: en el ejemplo se renderizará una etiqueta `span` si el condicional `==` lo permite.

  ```html
  <td>
  	<span th:if="${alumno.genero == 'F'}">Femenino</span>
  	<span th:unless="${alumno.genero == 'F'}">Masculino</span>
  </td>
  ```

* En la clase de modelo `Vacante` agregar una nueva propiedad `private Integer destacado` con sus *getters* y *setters*. 

  ```java
  private Integer destacado;
  
  public Integer getDestacado() {
  		return destacado;
  	}
  	public void setDestacado(Integer destacado) {
  		this.destacado = destacado;
  	}
  ```

* Agregar al HomeController modificar el método `getVacantes` agregando el atributo destacado con valores 1 y 0 (en representación del estado destacado y no destacado) repartidos en cada vacante. 

  ```java
  vacante1.setDestacado(1);
  vacante2.setDestacado(0);
  vacante3.setDestacado(0);
  vacante4.setDestacado(1);
  ```

* Finalmente en la vista `tabla.html` agregar la columna *destacado* a la tabla junto con *badges* de Bootstrap con *success* si la propiedad es igual a 1 y *danger* si es igual a 0:

  ```html
  <table class="table table-striped table-hover table-bordered">
  		<tr>
  			<th>Id</th>
  			<th>Nombre</th>
  			<th>Fecha de publicacion</th>
  			<th>Salario</th>
  			<th>Descripcion</th>
  			<th>Destacada</th>
  		</tr>
  		<tr th:each="vacante: ${vacantes} ">
  			<td th:text="${vacante.id}"></td>
  			<td th:text="${vacante.nombre}"></td>
  			<td th:text="${vacante.fecha}"></td>
  			<td th:text="${vacante.salario}"></td>
  			<td th:text="${vacante.descripcion}"></td>
  			<!--<td th:text="${vacante.destacado}"></td>-->
  			<!--<td th:text="${vacante.destacado == 1 ? 'SI' : 'NO'}"></td>-->
  			<td>
  				<span th:if="${vacante.destacado == 1}" class="badge bg-success">Si</span>
  				<span th:unless="${vacante.destacado == 1}" class="badge bg-danger">No</span>
  			</td>
  		</tr>
  	</table>
  ```

* El resultado debería verse así

  ![](D:\Spring Boot Udemy\Apuntes\imagenes\Bootstrap tabla con columna Destacado.png)

### URLs relativas al ContextPath

Son las urls relativas al directorio raíz (root) de una aplicación web cuando ya están publicadas en el servidor. Inician con diagonal (`/`) para referenciar un recurso (imágenes, css, js, pdf, etc). Cuando se usa Thymeleaf los recursos deben guardarse en el directorio `src/resources/static`. En este código se muestran expresiones de ejemplo:

```html
<!-- Para incluir el archivo "estilos.css"-->
<link th:href="@{/css/estilos.css}" rel="stylesheet">

<!-- Para incluir el archivo "funciones.js"-->
<script th:src="@{/js/funciones.js}"></script>

<!-- Para incluir la imagen "foto.png"-->
<img th:src="@{/imagenes/foto.png}" width="136" height="136">

<!--Para incluir archivos CSS y Javascript via CDN se usa la sintaxis estándar sin expresiones Thymeleaf-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script	
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"      	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 		crossorigin="anonymous"></script>

```

### Incluir imágenes estáticas en la vista

Crear tres carpetas dentro de la carpeta `static`: una `images`, otra `js` y finalmente `css`. Copiar una imagen (en este ejemplo es logo.png) dentro del directorio `images`. Para incluir esta imagen utilizamos este código `<img th:src="@{/images/logo.png}" width="136" height="136" >` antes de la etiqueta `<h1>`. Una vez hechos los cambios, detener el proyecto y actualizarlo mediante `clic derecho en empleos ]root] [devtools] > Refresh`

```html
<h1>Lista de Vacantes</h1>
<img th:src="@{/images/logo.png}" width="136" height="136" >
```

### Incluir imágenes dinámicas en la vista

Agregar dentro del directorio `images` diferentes logos llamados `empresa1.png`, `empresa2.png`, `empresa3.png` y `no-image.png` para la imágen por defecto. En la clase Vacante.java agregar un nuevo atributo llamado imagen iniciado con el string "no-image.png" para la imagen por defecto, con sus respectivos `getters` y `setters`:

```java
private String imagen = "no-image.png";
public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
```

En el controlador `HomeController` dentro del método `getVacantes` agregar a cada vacante (menos a una cualquiera) la línea `vacanteN.setImagen("empresaN.png")`.

Finalmente en la vista `tabla.html` agregar un nuevo encabezado `<th>` a la tabla llamado Logo y luego una nueva fila `<td>` que contenga el código que obtiene dinamicamente las imágenes:

```html
<table class="table table-striped table-hover table-bordered">
		<tr>
			<th>Logo</th>
			<th>Id</th>
			<th>Nombre</th>
			<th>Fecha de publicacion</th>
			<th>Salario</th>
			<th>Descripcion</th>
			<th>Destacada</th>
		</tr>
		<tr th:each="vacante: ${vacantes} ">
			<td>
				<img th:src="@{/images/{img}(img=${vacante.imagen})}" width="136" height="136" >
			</td>
			<td th:text="${vacante.id}"></td>
			<td th:text="${vacante.nombre}"></td>
			<td th:text="${vacante.fecha}"></td>
			<td th:text="${vacante.salario}"></td>
			<td th:text="${vacante.descripcion}"></td>
			<!--<td th:text="${vacante.destacado}"></td>-->
			<!--<td th:text="${vacante.destacado == 1 ? 'SI' : 'NO'}"></td>-->
			<td>
				<span th:if="${vacante.destacado == 1}" class="badge bg-success">Si</span>
				<span th:unless="${vacante.destacado == 1}" class="badge bg-danger">No</span>
			</td>
		</tr>
	</table>
```

El resultado debería verse así:

<img src="D:\Spring Boot Udemy\Apuntes\imagenes\Mostrar imagenes dinamicas y estaticas .png" />



### Ciclo de vida de una petición HTTP en Spring Web MVC

1.- Un usuario hace una solicitud (a una URL o envía un formulario) a una aplicación desarrollada en Spring Boot MVC en un servidor web. Este servidor web por lo general tiene integrado un motor para procesar `Servlets` y `JSP` (en el ejemplo muestra Apache Tomcat).

2.- La petición es recibida por el `Front Controller` que es un Servlet llamado `Dispatcher Servlet` el cual recibe todas las peticiones HTTP.

3.- El `Front Controller` analiza la URL a la cual fue hecha la petición y de acuerdo a su configuración el va a buscar el controlador que esta mapeado a dicha URL. En caso de no encontrarla muestra error 404.

4.- Si existe un controlador encargado de procesar la URL, recibe la petición y la procesa (haciendo uso de la lógica de recibir los datos del usuario, por ejemplo los datos de un formulario podrían ser almacenados en base de datos, hacer cálculos, generar reportes, etc). Esta lógica de negocio puede usar componentes de la capa de servicios (`@Service`), los cuales a su vez hacen uso de componentes de la capa de datos (`@Repository`).

5.- Se genera el modelo.

6.- El controlador debe indicar cual será la vista encargada de renderizar el modelo previamente generado. El controlador envía el modelo con el nombre de la lista al `Front Controller` (View Resolver: componente de Spring MVC que se encarga de buscar las vistas en la aplicación).

7.- Envía el modelo al motor de plantillas para renderizar la vista final que verá el usuario.

8.- El motor de plantillas regresa el flujo al `Front Controller`.

9.- El `Front Controller` envía la respuesta al navegador de internet en formato HTML.

10.- Se muestra el resultado HTML en forma gráfica para el usuario.

![](D:\Spring Boot Udemy\Apuntes\imagenes\Ciclo de vida de una petición HTTP en Spring Boot MVC.png)



## SECCION 3: Spring Boot y Thymeleaf - Controladores

### Anotación @RequestMapping a nivel de método

La anotación `@RequestMapping` (cuando se incluye antes de la declaración de un método en un controlador) sirve para especificar la URL y el `verbo HTTP` (`POST`, `GET`, `DELETE`, `PUT`, etc) al que estará mapeado el método. (Funcionamiento similar al `@GetMapping` y `@PostMapping`).

| anotaciones (spring 4.3+)  | Mapeo con la anotación @requestmapping                       | uso común                              |
| -------------------------- | ------------------------------------------------------------ | -------------------------------------- |
| @GetMapping("/lista")      | @RequestMapping(value="/lista", method=RequestMethod.GET)    | Aplicaciones web y RestFul WebServices |
| @PostMapping("/guardar")   | @RequestMapping(value="/guardar", method=RequestMethod.POST) | Aplicaciones web y RestFul WebServices |
| @DeleteMapping("/borrar")  | @RequestMapping(value="/borrar", method=RequestMethod.DELETE) | Desarrollo de RestFul WebServices      |
| @PutMapping("/actualizar") | @RequestMapping(value="/actualizar", method=RequestMethod.PUT) | Desarrollo de RestFul WebServices      |
|                            |                                                              |                                        |

Crear la dentro del paquete `controller` el controlador `CategoriasController.java` con el siguiente código:

```java
@Controller
public class CategoriasController {
	// @GetMapping("/index")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
	return "categorias/listCategorias";
	}
	// @GetMapping("/create")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear() {
	return "categorias/formCategoria";
	}
	// @PostMapping("/save")
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar() {
	return "categorias/listCategorias";
	}
}
```

Se debe crear el directorio `categorias` y las vistas `listCategorias.html` y `formCategoria.html` los cuales contendrán solo un título `<h1>Lista de Categorias</h1>` y `<h1>Creacion de Categorias</h1>` respectivamente. Al visitar la URL `http://locahost:7070/index` (por ahora no veremos la URL terminada en `save`) se renderizará la vista `listCategorias.html` que debería estar dentro del directorio categorías. De la misma manera, al visitar `http://localhost:7070/create` se renderizará la vista `formCategoria.html`.

Al visitar la dirección web `http://localhost:7070/index` debería obtener:

<img src="D:\Spring Boot Udemy\Apuntes\imagenes\Resultado de index en requestmapping.png" style="zoom:67%;" />

### Anotación @RequestMapping a nivel de clase

Si se escribe `@RequestMapping(value="categorias")` antes de la declaración de clase implica que para acceder a las URLs que existen en los métodos de la clase habrá que poner el prefijo `categorias/`. En este ejemplo, para proceder a la URL `http://localhost:7070/index` se debe navegar a `http://localhost:7070/categorias/index`. Del mismo modo se debe acceder a la URL `save`:

```java
@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
@RequestMapping(value="/index", method=RequestMethod.GET)
public String mostrarIndex(Model model) {
    return "categorias/listCategorias";
}
@RequestMapping(value="/save", method=RequestMethod.POST)
public String guardar() {
	return "categorias/listCategorias";
}
}
```

En la vista se puede tener como ejemplo el siguiente código de formulario:

```html
<form th:action="@{/categorias/save}" method="post">
Categoria
<input type="text" name="nombre">
<input type="submit" value="Guardar">
</form>
```

En tiempo de ejecución el `action` del `<form>` se convierte a `<form action="/categorias/save">`. A efectos del proyecto, en el controlador `CategoriasController` pondremos la línea `@RequestMapping(value="/categorias")` a nivel de clase. De esta manera las URL dentro de este controlador deberán tener el prefijo `categorías/`.

### Anotación @PathVariable - URLs dinámicas

Se usan para manejar variables de plantillas en el mapeo de una solicitud y establecerlas como parámetros de método. En este ejemplo la variable es llamada id y se utiliza en la URL `/detalle/{id}` la cual podría ser por ejemplo `/detalle/13`:

```java
@GetMapping("/detalle/{id}")
public String mostrarDetalle(@PathVariable("id") int idVacante){
System.out.println("PathVariable: " + idVacante);
return "detalle";
}
```

Un método puede tener cualquier número de anotaciones `@PathVariable`: 

```java
public String mostrarDetalle(@PathVariable("id") int idVacante, @PathVariable("fecha") Date fecha){
```

Para hacer un ejemplo práctico crea un nuevo controlador `VacantesController` que contenga el siguiente código:

```java
@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.print("idVacante: " + idVacante);
		model.addAttribute("idVacante", idVacante);
		//Buscar los detalles de la vacante en la base de datos
		return "vacantes/detalle";
	}
}
```

A su ves crear una carpeta `vacantes` dentro del directorio `templates` que contenga la vista `detalle.html` con el código:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Detalle de la Vacante</title>
</head>
<body>
	<h1 th:text="'El id es: ' + ${idVacante}"></h1>
</body>
</html>
```

Luego en la vista tabla.html pondremos un nuevo titulo <th> y un nuevo <td> con los siguientes códigos:

```html
<th>Detalle</th>
(...)
<td>
<a th:href="@{/vacantes/view/{id} (id=${vacante.id}) }" class="btn btn-success">Detalle</a>
</td>
```

De tal manera que al presionar el botón Detalle de la vacante con id = 30 se verá:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Peticion a la url vacantes view 30.png)

### Anotación @RequestParam

Sirve para extraer parámetros en URL y vincularlos con los del método dentro de un controlador. Si el parámetro no se encuentra en la URL, se disparará error porque los parámetros especificados en `@RequestParam` son requeridos. Si se quiere que el parámetro sea opcional, se tiene que agregar el atributo `required = false`. Por defecto los parámetros llegan al servidor con tipo `String` pero Spring MVC tiene un componente de conversión que convierte de `String` al tipo indicado en el método del controlador. Como ejemplo se puede ver este código en un controlador:

```java
@GetMapping("/detalle")
public String verDetalle(@RequestParam("idVacante") int idVacante){
// Procesamiento del parámetro. Aquí, ya se hizo la conversión a String a int.
System.out.println("RequestParam: " + idVacante);
return "someView";
}
```

Hay un parámetro `idVacante` el cual Spring MVC intentará encontrarlo para convertirlo a tipo `int` y asignarlo a `idVacante`. Luego se imprime en la consola el texto indicado.

Acá vemos un link HTML tipo GET con el query string idVacante:

```html
<a th:href="@{/detalle(idVacante=${vacante.id}) }"> Ver detalles </a>
```

Este link se convierte en `localhost:7070/detalle?idVacante=11` suponiendo que el id tiene el valor 11.

Para vincular los parámetros en una solicitud tipo POST vemos el siguiente ejemplo de formulario HTML:

```html
<form action="save" method="POST">
	Titulo
<input type="text" name="titulo"/>
<button type="submit" >Guardar</button>
</form>
```

En el controlador tenemos:

```java
@PostMapping("/save")
public String guardar(@RequestParam("titulo") String tituloTmp){
System.out.println("Titulo:" + tituloTmp);
return "detalle";
}
```

El formulario HTML se dirige a la URL `save` e intenta extraer el valor de la variable `titulo` (si existe) asignándola al parámetro `tituloTmp` dentro del método `guardar`. Luego, se imprime el texto indicado y se retorna a la vista `detalle.html`

Para poder ver el funcionamiento crearemos el método `delete` dentro de `VacantesController`:

```java
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con id: " + idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";
	}
```

Por cada peticion HTTP tipo GET a la URL `localhost:7070/delete?id=numero` se activará el método `eliminar`, el cual imprimirá en consola el mensaje ejemplo *Borrando vacante con id: 9*, luego el método enviará el atributo `id` con el valor del `idVacante` a la vista `mensaje.html`. Esta vista la creamos directamente en `templates` y tiene sólo una línea `<h1>` con el código:

```html
<h1>Vacante con id [[${id}]] eliminada</h1>
```

Luego, en la vista `tabla.html` haremos el botón *borrar* para cada vacante. El código es un nuevo título `<th>` en la tabla y un nuevo `<td>` el siguiente

```html
<th>Borrar</th>
(...)
			<td>
				<a th:href="@{/vacantes/delete(id=${vacante.id}) }" class="btn btn-danger">Borrar</a>
			</td>
```

De esta manera se debería ver la vista al borrar vacante con id = 1:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Resultado boton borrar en tabla vacantes.png)

Para recibir los datos de un formulario HTML que se va a enviar en una petición HTTP tipo POST primero debemos crear el formulario en la vista `formCategoria.html`:

```html
<form th:action="@{/categorias/save}" method="POST">
    <label for="fname">Nombre:</label>
    <br> 
    <input type="text" name="nombre" value="">
    <br> 
    <label for="lname">Descripcion:</label>
    <br> 
    <input type="text" name="descripcion" value="">
    <br>
    <input type="submit" value="Guardar">
</form>
```

Es importante que en el `action` del formulario se especifique la petición para dirigirse a `/categorias/save` (ya que el el valor categorías esta a nivel de clase controlador). Luego en `CategoriasController` modificamos el método `guardar` de la siguiente manera:

```java
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
	System.out.println("Categoria: " + nombre);
	System.out.println("Descripcion: " + descripcion);
	return "categorias/listCategorias";
}
```

Es importante que en las anotaciones `@RequestParam` esté especificado el mismo nombre que esta descrito en el atributo `name` de cada `input` en el formulario. Los datos se imprimirán en la consola. Si hacemos una prueba en la URL `localhost:7070/categorias/create` y llenamos los campos podremos comprobar el funcionamiento:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Formulario categorias para probar metodo guardar.png)

En la consola se imprimen los datos enviados:

![](D:\Spring Boot Udemy\Apuntes\imagenes\Resultado de probar metodo guardar en el IDE.png)



## SECCION 4: Spring Boot y Thymeleaf - Inyección de Dependencias

### Clase de Servicio VacantesServiceImpl

NOTA: Una interfaz en Java es una clase que contiene definiciones de métodos sin su implementación. Otras clases pueden implementar interfaces de tal manera que implementan todos sus métodos. Muchas clases pueden implementar una interfaz y una clase puede implementar muchas interfaces (pero solo una clase abstracta). A diferencia de las clases abstractas, las interfaces no pueden implementar métodos.

Crear paquete de servicios llamado `net.jorge.services` y dentro una Interface llamada `IVacantesService` con el código:

```java
package net.jorge.service;
import java.util.List;
import net.jorge.model.Vacante;

public interface IVacantesService {
	List<Vacante> buscarTodas();
}

```

Crear una clase en el paquete de servicios que se llame `VacantesServiceImpl` para implementar la interface creada:

```java
package net.jorge.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import net.jorge.model.Vacante;

public class VacantesServiceImpl implements IVacantesService {
	
	private List<Vacante> lista = null;

	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Espacial");
			vacante1.setDescripcion("Solicitamos Ing Espacial para diseñar vuelo tripulado.");
			vacante1.setFecha(sdf.parse("01-12-2021"));
			vacante1.setSalario(9500000.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Astronauta");
			vacante2.setDescripcion("Solicitamos Astronauta para vuelo tripulado.");
			vacante2.setFecha(sdf.parse("24-11-2021"));
			vacante2.setSalario(1400000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Bombero");
			vacante3.setDescripcion("Solicitamos Bombero para trabajar en Stgo.");
			vacante3.setFecha(sdf.parse("12-12-2021"));
			vacante3.setSalario(500000.0);
			vacante3.setDestacado(0);

			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Bailarin");
			vacante4.setDescripcion("Solicitamos Bailarin para programa de TV.");
			vacante4.setFecha(sdf.parse("22-11-2021"));
			vacante4.setSalario(900000.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}

}
```

En el constructor `public VacantesServiceImpl()` ha quedado el código que agrega los objetos de tipo `Vacante` y se elimina la línea de `return`. El atributo lista queda a nivel de la clase para quede accesible para todos los métodos de la clase de servicio. El método implementado `buscarTodas()` retorna la lista de vacantes.

SIgooo
