# Proyecto 1: Análisis de redes sociales.

## Proyecto de Estructura de Datos   
**Integrantes:**  
Rodrigo Di Giulio  
Andres Perez  
Jesus Angulo  

# Instrucciones
## Contexto preliminar
En el siguiente proyecto, usted tendrá que realizar una investigación documental que le permita obtener información sobre el contexto del problema. En tal sentido, se sugiere que comience por realizar la siguiente lectura relativa a grafos, pero tome en cuenta que es solo un recurso inicial que debe ser complementado con la búsqueda autónoma de información por parte de los integrantes del equipo de trabajo:

https://drive.google.com/file/d/1Q65Rh-Tx6qwJODUlsmWVfw_-bzqttwiI/view?usp=sharing

## Problema
Una empresa lo ha contratado para desarrollar un programa para analizar un grafo que representa una red social, el proyecto se enfocará en la detección de la fuerte conectividad y la identificación de componentes fuertemente conectados en esta estructura de datos.

En la red social, cada usuario se representa como un nodo en un grafo dirigido, y las relaciones de amistad (que básicamente implica que un usuario sigue a otro usuario) entre los usuarios se modelan como las aristas de dicho grafo. El objetivo de este proyecto es desarrollar una aplicación que permita a la empresa determinar si en un grafo que representa parte de los usuarios y relaciones entre estos en una red social, existen componentes fuertemente conectados, es decir, grupos de amigos o comunidades dentro de la red.

En el contexto de la teoría de grafos, una conectividad fuerte implica que desde cualquier nodo de un grafo, exista por lo menos un camino que lo conecte con cada uno de los demás nodos del grafo, es decir, que no exista ningún subconjunto de nodos aislados.


![image](https://github.com/RodrigoDiGiulio/Proyecto_1/assets/145570964/ba2ef023-6cb1-41fb-9e3a-c22cb6d92c2e)

**Figura1. Grafo fuertemente conectado**


![image](https://github.com/RodrigoDiGiulio/Proyecto_1/assets/145570964/0b3d4746-7672-48fa-9728-4cb68a32ccea)

**Figura 2. Grafo débilmente conectado**

Los componentes fuertemente conectados se refieren a sub grafos que exhiben la propiedad de fuerte conectividad previamente mencionada. En otras palabras, son conjuntos de nodos en los que cada nodo puede alcanzar cualquier otro nodo dentro del mismo sub grafo a través de caminos dirigidos.

![image](https://github.com/RodrigoDiGiulio/Proyecto_1/assets/145570964/4cec99cf-933e-4a87-afad-ee3e4a074e46)

**Figura 2. Grafo con componentes fuertemente conectados. En este ejemplo se muestran dos componentes.**

## Requerimientos funcionales
### A. Cargar archivo: 
El usuario puede seleccionar a través de JFileChooser un archivo txt (archivo de texto plano) para ser cargado en el sistema, el cual contará con la información necesaria para la creación del grafo, es decir: usuarios y sus conexiones. Cuando el usuario cargue un nuevo archivo, el sistema debe enviar un mensaje de alerta indicando al usuario la necesidad de guardar los datos actualmente cargados en memoria. La estructura del archivo de datos (archivo de texto plano) se indicará posteriormente.
### B. Modificar grafo: 
El usuario podrá seleccionar usuarios para ser eliminados. De igual forma, el usuario podrá agregar un nuevo usuario, indicando la relación que tenga con otros usuarios dentro del grafo.
### C. Actualizar repositorio: 
Esta función permitirá que la información cargada en memoria, referente a los usuarios y sus conexiones, sea actualizada en el repositorio. Es decir, los cambios realizados en cualquiera de estos deben actualizarse en el archivo texto de tal forma que cuando se vuelva a cargar ese archivo contenga todos los cambios realizados. Al iniciarse el programa por primera vez debe cargarse el archivo de texto dado al final del enunciado (debe de mantener el mismo formato).
### D. Mostrar grafo: 
El sistema deberá mostrar una representación visual del grafo según la información contenida en la memoria, es decir, las relaciones entre los usuarios y su información. Nota: Puede hacer uso de librerías para dicha representación
### E. Identificación de componentes fuertemente conectados: 
Encontrar los componentes fuertemente conectados utilizando el algoritmo de Kosaraju con búsqueda en profundidad (DFS). Debe mostrarse el grafo indicando los componentes existentes mediante colores (un color para cada componente identificado). 

## Requerimientos técnicos
### Requerimiento 1. 
La solución debe ser implementada con base en un grafo, que a su vez puede ser implementado mediante una matriz de adyacencia o una lista de adyacencia.
### Requerimiento 2. 
Puede utilizar cualquier otra estructura auxiliar de ser necesario. Sin embargo, NO podrá utilizar librerías para la implementación del tipo de dato abstracto, solo podrá utilizar librerías para lo relativo a la representación gráfica del grafo.
### Requerimiento 3. 
El programa debe poder representar el grafo correspondiente de manera gráfica.
### Requerimiento 4. 
La aplicación debe ofrecer una interfaz gráfica al usuario.
### Requerimiento 5. 
El programa debe poder cargar un archivo de texto para la lectura de datos. Para ello, es requerido el uso del componente JFileChooser.
### Requerimiento 6. 
Debe documentar el proyecto con Javadoc.
### Requerimiento 7. 
Junto al programa, cada equipo deberá presentar un Diagrama de clases (arquitectura detallada) que explique la solución obtenida.

## Archivo de texto
Puede tomar el siguiente ejemplo como referencia en lo relativo a la estructura del archivo a utilizar. Tome en cuenta que el archivo de prueba tendrá la misma estructura pero no los mismos datos.

usuarios  
@pepe  
@mazinger  
@juanc  
@xoxojaime  
@tuqui33  
@sancho23  
@terciopelo  
@caribedoble  
@africa  
@totalfree  
@radiogaga  
@cipriano  
@newageforever  
relaciones  
@pepe, @mazinger  
@mazinger, @juanc  
@mazinger, @tuqui33  
@tuqui33, @xoxojaime  
@xoxojaime, @pepe  
@juanc, @sancho23  
@sancho23, @mazinger  
@sancho23, @terciopelo  
@terciopelo, @newageforever  
@terciopelo, @caribedoble  
@caribedoble, @africa  
@africa, @cipriano  
@cipriano, @totalfree  
@cipriano, @radiogaga  
@totalfree, @africa  
@totalfree, @radiogaga  
@radiogaga, @caribedoble

En la siguiente figura se muestra una representación del grafo congruente con la información contenida en el archivo de texto. El sistema que su equipo de trabajo construirá, deberá generar un gráfico parecido a este, mostrando los Componentes fuertemente conectados. En este caso específico, se muestran 3 componentes.

![image](https://github.com/RodrigoDiGiulio/Proyecto_1/assets/145570964/5137ee96-d2a5-4031-95a0-c210c1d31acf)

## Consideraciones
- Los proyectos podrán ser sometidos a defensa, es decir, el facilitador convocará al equipo para una revisión.
- Los equipos de trabajo deberán utilizar GitHub para el control de versiones y facilitar el trabajo en equipo de manera remota. De esta forma, podrán comenzar a crear su portafolio de trabajos, elemento que puede ser importante a la hora de buscar trabajo. En el registro se deberá reflejar la participación activa y significativa de los integrantes.
- Los proyectos que no tengan interfaz gráfica, serán calificados con 0 (cero).
- Los proyectos que sean iguales o parecidos, serán calificados con 0 (cero).
- Los programas que “no corran”, serán calificados con 0 (cero).
- Los equipos pueden tener como máximo 3 personas.
## Criterios de evaluación
- Funcionalidad: Capacidad para proporcionar las funcionalidades que satisfacen las necesidades explícitas e implícitas bajo unas ciertas condiciones. (60%)
- Adecuación: El programa ofrece todas funcionalidades que respondan a las necesidades, tanto explícitas (contenidas en el documento descriptivo del proyecto) como implícitas; entendiendo como necesidades implícitas, aquellas que, no estando descritas en el documento, surgen como resultado de un concienzudo análisis del problema planteado y que aseguran el correcto funcionamiento del programa.
- Exactitud: El programa genera los resultados o efectos correctos o acordados, con el grado necesario de precisión.
- Fiabilidad: Capacidad para mantener un nivel especificado de prestaciones cuando se usa bajo ciertas condiciones.
- Madurez: El programa no presenta fallas originadas por errores de programación, análisis o diseño. (10%)
- Tolerancia a fallos: El programa responde adecuadamente al manejo inadecuado del usuario; es decir, mantiene su correcto funcionamiento aun cuando el usuario introduzca datos erróneos o manipule inadecuadamente las interfaces de usuario. (10%)
- Usabilidad: Capacidad del proyecto para ser entendido, aprendido, usado y al mismo tiempo, ser atractivo para el usuario, cuando se usa bajo condiciones específicas.
- Comprensibilidad: El programa ofrece una interfaz de fácil comprensión, facilitando su aprendizaje y correcta utilización. El programa emite mensajes de alerta cuando se introducen valores erróneos. Existen elementos informativos que indican al usuario como operar el programa. (5%)
- Capacidad de ser atractivo: El diseño de la interfaz de usuario, esto es: disposición de controles, esquema de colores, utilización de cajas de diálogo y demás elementos gráficos; es atractivo para el usuario. (5%)
- Eficiencia: Capacidad para proporcionar prestaciones apropiadas, relativas a la cantidad de recursos utilizados, bajo condiciones determinadas.
- Estructuras de datos: Utiliza eficientemente las estructuras de datos para la solución del problema. (10%)
