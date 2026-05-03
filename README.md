 Proyecto de Contenidos Audiovisuales - POO

Este proyecto es una práctica de Programación Orientada a Objetos en Java.  
El objetivo fue ampliar un proyecto base agregando nuevas clases, subclases y relaciones entre objetos.

## ¿Qué hace el proyecto?

El programa crea diferentes tipos de contenidos audiovisuales y muestra su información en consola.

Los contenidos principales son:

- Película
- Serie de TV
- Documental
- Podcast
- Transmisión en vivo

También se agregaron clases relacionadas como:

- Actor
- Temporada
- Investigador

## Conceptos de POO usados

En el proyecto se aplican estos conceptos:

- **Herencia:** `Pelicula`, `SerieDeTV`, `Documental`, `Podcast` y `TransmisionEnVivo` heredan de `ContenidoAudiovisual`.
- **Asociación:** `Pelicula` se relaciona con `Actor`, `Podcast` con `Investigador` y `TransmisionEnVivo` con `Actor`.
- **Agregación:** `Documental` se relaciona con `Investigador`.
- **Composición:** `SerieDeTV` contiene una `Temporada`.
- **Polimorfismo:** se usa un arreglo de `ContenidoAudiovisual` para guardar varios tipos de contenidos.

## Estructura del proyecto

```text
poo_unidad1_tarea2
├── src
│   ├── poo
│   │   └── PruebaAudioVisual.java
│   └── uni1a
│       ├── Actor.java
│       ├── ContenidoAudiovisual.java
│       ├── Documental.java
│       ├── Investigador.java
│       ├── Pelicula.java
│       ├── Podcast.java
│       ├── SerieDeTV.java
│       ├── Temporada.java
│       └── TransmisionEnVivo.java
└── module-info.java
