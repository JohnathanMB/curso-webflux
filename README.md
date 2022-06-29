# webflux - basico

Este es un proyecto de ejemplo sobre los métodos más comunes para el procesamiento de Mono y Flux como publicadores reactivos de WebFlux.

## Ramas:

### feature/ejemplosMonoFlux
Esta rama contiene ejemplos de los métodos más comunes que se vieron en la charla inicial sobre webflux sobre una arquitectura hexagonal generada con https://github.com/bancolombia/scaffold-clean-architecture#plugin-implementation 
También se puede encontrar el archivo llamado **Cierre Brecha - WebFlux.postman_collection** que contiene una coleción de postman con los requests para probar los ejemplos como webservices.

### feature/practica/0
Se crea una carpeta con el archivo build.gradle con el pluging para crear proyectos con arquitectura limpia
Se debe correr el siguiente comando: 
gradle cleanArchitecture --package=co.com.sofka --type=reactive --name=webflux-practica-rest --coverage=jacoco --lombok=true

### feature/practica/1
* Contiene la estructura principal creada al momento de correr el comando anteriormente indicado
* Contiene configuración inicial para utilizar H2 como base de datos local
* Contiene Script de inserción a base de datos inicial
* Contiene configuracion inicial para utilizar JPA para consumo de base de datos
* Contiene el modelo Estudiante que vamos a usar en la práctica
* Contiene puerto para consumo de base de datos
