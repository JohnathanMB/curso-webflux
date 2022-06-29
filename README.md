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
1. Creamos el modelo Estudiante que vamos a usar en la práctica
    - gradle generateModel --name=Estudiante
2. Creamos driven Adapter JPA para consumo de base de datos
    - gradle generateDrivenAdapter --type=jpa
    - Verificamos creacion de modelo y cambios en el archivo application.yaml
        - Con este paso se debe crear la configuración para conectar a base de datos y una base de datos local con H2
    - Creamos clase EstudianteData
    - Renombramos las clases JPARepository y JPARepositoryAdapter
    - Ajustamos parametros de las clase de repositorio
    - creamos archivo update.sql y agregamos script de inserción de data
    - Ajuste de application.yaml - se agregan las siguientes variables:
        spring.sql.init.mode: always
        spring.sql.init.data-locations: classpath:update.sql
3. Creamos entryPoint para consumir servicios de entidad
    - gradle generateEntryPoint --type=webflux
    - Verificamos la creacion del módulo
    - Renombramos las clases Handler y RouterRest

### feature/practica/2
1. Creamos el caso de uso para llevar a cabo la lógica de negocio de nuestro proyecto
    - gradle generateUseCase --name=EstudianteUseCase
    - Se verifica que se cree la clase EstudianteUseCase.java en el paquete usecase
2. Usamos el caso de uso EstudianteUseCase en EstudianteHandler
3. Creamos un método en el caso de uso que nos responda un Mono<String> para validar que la conexión se haga adecuadamente
4. Creamos método en handler para usar el método de ejemplo
5. Creamos método ruta en RouterRest para poder probar servicio desde postman
6. Se prueba desde postman y nos debe responder el String que definimos en el método del usecase

### feature/practica/3
1. Crear servicio consultar todos los estudiantes en nuestra base de datos.
    - se crea el método para consultar todos los registros en la interface EstudianteRepository.java
    - se crea implementación del anterior método en EstudianteRepositoryAdapter
    - En la implementación se usa el repository (ahora nombrado EstudianteDataRepository) para consultar todos los registros y luego convertirlos a los objetos Estudiante
    - Se crea parametro **final** de EstudianteRepository en EstudianteUseCase
    - Se crea método para consultar todos los estudiantes en el caso de uso
    - Se crea método en handler
    - Se crea método en EstudianteRouteRest
    - Se consume desde postman

### feature/practica/4
1. Crear servicio para notificar a todos los estudiantes

### feature/practica/5
1. El mísmo método anterior pero con funcionamiento paralelo explicito

