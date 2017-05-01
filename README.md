# spaceApps2017

Aplicación Web desarrollada por el equipo **Ad Astra Per Aspera** para solucionar el reto "And YOU can help fight fires!" propuesto para el SpaceAppsChallenge 2017.

## Descripción de la aplicación
El objetivo era la creación de una aplicación web que facilitara la respuesta rápida de los equipos de extinción de incendios y rescate en el caso de la aparición de un incendio en España.
La aplicación debía consistir en un mapa que mostrara la localización de las anomalías de temperatura (posibles incendios) dentro de España, y permitiera, mediante un click, el cálculo de la ruta más corta entre la localización del usuario (equipo de rescate local, bomberos) y la localización del posible incendio seleccionado.
Además, en el mapa se señalaría también la fuente de agua más cercana al incendio con cantidad de agua suficiente para el llenado de depósitos de agua de helicópteros de extinción de incendios, camiones de bomberos, etc.
Los fuegos, serían marcados con distintos tonos de rojo en el mapa, cada tono correspondiendo a su importancia. La importancia era resultado de diversos factores, como el tamaño del fuego, la distancia a una fuente de agua, la distancia a un espacio natural protegido y su tamaño.

## Desarrolladores de la aplicación:
  - Alberto Martínez Menéndez
  - Beatríz Pérez Cancer
  - Pablo Piedrafita Castañeda
  - Rubén Langarita Benítez
  
## Tecnologías utilizadas
  - AngularJS para el front-end
  - Leaflets para la presentación de la información en un mapa
  - Spring para el back-end
  - Postgre/PostGIS como servidor de la aplicación
  - QuantumGIS y KNIME para la visualización y la limpieza de datos
 
## Datos utilizados
  - Información sobre fuegos activos o anomalías de temperatura obtenida de la NASA
  - Información sobre cuencas hidrográficas españolas obtenida de --
  - Información sobre espacios naturales protegidos españoles obtenida de --
