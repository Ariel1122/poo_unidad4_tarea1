 Proyecto de CODIGO LIMPIO EN Contenidos Audiovisuales - POO

Este proyecto es una práctica de Programación Orientada a Objetos en Java.  
El objetivo fue ampliar un proyecto base agregando nuevas clases, subclases y relaciones entre objetos.

## ¿Qué hace el proyecto?

El programa permite administrar diferentes tipos de contenidos audiovisuales desde consola.

El sistema puede:

Cargar contenidos desde un archivo CSV.
Mostrar la lista de contenidos registrados.
Agregar nuevos contenidos audiovisuales.
Guardar los contenidos actualizados en un archivo.
Ejecutar pruebas unitarias para verificar el funcionamiento del código.

Los contenidos principales son:

Película
Serie de TV
Documental
Podcast
Transmisión en vivo

También se utilizan clases relacionadas como:

Actor
Temporada
Investigador

## Conceptos de POO usados

En este proyecto se aplican varios conceptos importantes de Programación Orientada a Objetos y programación limpia:

Herencia: Pelicula, SerieDeTV, Documental, Podcast y TransmisionEnVivo heredan de ContenidoAudiovisual.
Polimorfismo: se usa una lista de ContenidoAudiovisual para manejar diferentes tipos de contenidos.
Asociación: algunas clases se relacionan con otras, como Pelicula con Actor.
Agregación: Documental y Podcast se relacionan con Investigador.
Composición: SerieDeTV contiene una Temporada.
Manejo de archivos: los datos se leen y se guardan en un archivo CSV.
Código limpio: el proyecto se separó en paquetes con responsabilidades claras.
SOLID: se aplicaron principios para mejorar la organización y mantenimiento del código.
MVC: se separó el modelo, la vista y el controlador.
JUnit: se agregaron pruebas unitarias para validar funcionalidades principales.
Estructura del proyecto
poo_unidad4_tarea1
├── src
│   ├── controlador
│   │   └── ContenidoControlador.java
│   │
│   ├── poo
│   │   └── PruebaAudioVisual.java
│   │
│   ├── repositorio
│   │   ├── ContenidoRepositorio.java
│   │   └── ArchivoContenidoRepositorio.java
│   │
│   ├── servicio
│   │   └── ContenidoServicio.java
│   │
│   ├── uni1a
│   │   ├── Actor.java
│   │   ├── ContenidoAudiovisual.java
│   │   ├── Documental.java
│   │   ├── Investigador.java
│   │   ├── Pelicula.java
│   │   ├── Podcast.java
│   │   ├── SerieDeTV.java
│   │   ├── Temporada.java
│   │   └── TransmisionEnVivo.java
│   │
│   └── vista
│       └── ConsolaVista.java
│
├── test
│   └── pruebas
│       ├── ArchivoContenidoRepositorioTest.java
│       ├── ContenidoServicioTest.java
│       ├── DocumentalTest.java
│       └── PeliculaTest.java
│
├── data
│   └── contenidos.csv
│
├── README.md
└── module-info.java

Descripción de paquetes
poo

Contiene la clase principal del programa.
Desde aquí se inicia el sistema.

controlador

Contiene la clase que controla el flujo del programa.
Recibe las opciones del usuario y conecta la vista con el servicio.

vista

Contiene la clase encargada de mostrar el menú, pedir datos y presentar resultados en consola.

servicio

Contiene la lógica principal del sistema.
Administra la lista de contenidos audiovisuales.

repositorio

Contiene las clases encargadas de leer y guardar información en archivos CSV.

uni1a

Contiene las clases del modelo, es decir, las clases que representan los contenidos audiovisuales y sus relaciones.

test

Contiene las pruebas unitarias realizadas con JUnit.
