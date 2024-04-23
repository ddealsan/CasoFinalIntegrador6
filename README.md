## ENLACE REPOSITORIO: 


# Proyecto de Gestión de Datos

Este proyecto implementa varias funcionalidades para la gestión de datos, incluyendo la asociación de datos y la indexación y visualización de archivos.

## Mapas y Asociación de Datos

Esta parte del proyecto permite al usuario asociar claves y valores en un mapa. El usuario puede agregar elementos al mapa y recuperar elementos del mapa. Los elementos se agregan y recuperan a través de una interfaz gráfica de usuario.

El mapa se implementa utilizando la clase `GestionMapas`, que utiliza un `HashMap` para almacenar los elementos. La interfaz gráfica de usuario se implementa en la clase `VentanaMapasAsociacion`, que permite al usuario agregar y recuperar elementos del mapa.

## Indexación y Visualización de Archivos

Esta parte del proyecto permite al usuario indexar los nombres de los archivos y sus rutas en un directorio seleccionado. Los archivos se indexan de manera recursiva, lo que significa que también se indexan los archivos en los subdirectorios. Los nombres de los archivos y sus rutas se muestran en una interfaz gráfica de usuario.

La indexación de archivos se implementa utilizando la clase `IndexadorArchivos`, que utiliza un `TreeMap` para almacenar los nombres de los archivos y sus rutas. La interfaz gráfica de usuario se implementa en la clase `VentanaIndexacionVisualizacion`, que permite al usuario seleccionar un directorio para indexar y muestra los nombres de los archivos y sus rutas.

## Cómo ejecutar el proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en tu IDE preferido (este proyecto fue desarrollado en IntelliJ IDEA).
3. Ejecuta la clase principal para iniciar la aplicación.

## Tecnologías utilizadas

- Java
- Swing para la interfaz gráfica de usuario
- Maven para la gestión de dependencias
