# Proyecto Final - Estructura de Datos

## Carrera: Computación  
**Asignatura:** Estructura de Datos – Segundo Interciclo  
**Número de Práctica:** 5  
**Título de la Práctica:** Implementación de un Algoritmo para Encontrar la Ruta Óptima en un Laberinto Aplicando Programación Dinámica y Estructuras de Datos  

---

## **Objetivo**

Desarrollar una aplicación que implemente un algoritmo para encontrar la ruta óptima desde un punto de inicio (A) hasta un punto de destino (B) en un laberinto. Para ello, se utilizarán conceptos avanzados de programación dinámica y estructuras de datos lineales y no lineales.

---

## **Instrucciones**

1. **Leer y comprender el requerimiento:** Es importante analizar el enunciado para entender la problemática antes de comenzar a programar.
2. **Implementar la solución:** Desarrollar el código necesario para resolver cada una de las tareas asignadas.
3. **Ejecutar y probar el código:** Validar el correcto funcionamiento con diferentes casos de prueba.
4. **Generar el informe del proyecto:** Incluir toda la información relevante y capturas de pantalla de la implementación en este archivo README.md.
5. **Subir el proyecto:** Realizar commit y push del código en un repositorio.
   - Formato de versión: `1.0.0`
   - Mensaje de versión: `"Proyecto Final – Estructura de Datos"`
6. **Cargar la URL del repositorio en el AVAC.**

---

## **Actividades por desarrollar**

### **Comprensión de Algoritmos**
- Implementar algoritmos de búsqueda y optimización para encontrar rutas en grafos y laberintos.
- Comparar estrategias de búsqueda como BFS (Breadth-First Search), DFS (Depth-First Search) y A*.

### **Descripción del Problema**
- Representar el laberinto como una matriz de celdas transitables o no transitables.
- Definir los puntos de inicio (A) y destino (B).

### **Implementación del Algoritmo**
- Desarrollo de al menos cuatro métodos para encontrar la ruta:
  - Método recursivo simple
  - Método aplicando cache (programación dinámica)
  - BFS (Breadth-First Search)
  - DFS (Depth-First Search)
- Utilizar estructuras de datos adecuadas para almacenar rutas.
- Aplicar el patrón MVC para organizar el código.

### **Interfaz de Usuario**
- Diseño de una UI para ingresar laberintos y visualizar la ruta óptima.
- Permitir la configuración del tamaño del laberinto y las celdas transitables o no.
- Permitir la selección de puntos de inicio y destino desde la interfaz.

### **Versión Extra**
- Implementar una visualización de la mejor ruta en la UI.
- Comparar la eficiencia de cada algoritmo en términos de pasos y tiempo de ejecución.
- Mostrar los resultados en la UI e incluir capturas en el informe.

---

# **Proyecto Final - Estructura de Datos**


![Logo de la Universidad](https://github.com/Jona142004/Proyecto-FInal/blob/main/logo_ups.png?raw=true)


- **Universidad:** Universidad Politécnica Salesiana
- **Carrera:** Ingeniería en Ciencias de la Computación
- **Asignatura:** Estructura de Datos
- **Estudiante:** Jonnathan Josue Parraga Riera ([jparragar1@est.ups.edu.ec] )
- **Estudiante:** Maria Veronica Cobos Arevalo ([mcobosa@est.ups.edu.ec] )
- **Estudiante:** Dayanna Carolina Fortman Sanchez ([dfortmann@est.ups.edu.ec] )
- **Docente:** Ing. Pablo Torres

---

## **Descripción del Problema**
El proyecto consiste en la implementación de un algoritmo para encontrar la ruta óptima en un laberinto desde un punto de inicio (A) hasta un punto de destino (B). El laberinto se representa como una matriz de celdas, donde cada celda puede ser transitable o no transitable. Se deben aplicar técnicas de búsqueda óptima y estructuras de datos para encontrar la mejor ruta posible.

---

## **Propuesta de Solución**

### **Marco Teórico**
- **Programación Dinámica:** Técnica de optimización que permite reducir el tiempo de ejecución almacenando resultados intermedios. Fue desarrollado por Richard Bellman, matemático y economista. El planteamiento de Bellman para estos problemas consistía en dividirlos en subproblemas más pequeños y resolver los subproblemas del más pequeño al más grande. Después almacenaba los resultados de los subproblemas y los reutilizaba para resolver subproblemas más grandes. Esta es la idea principal de la programación dinámica.
- **BFS (Breadth-First Search):** Es un algoritmo de recorrido de grafos que explora los vértices de un Grafo en niveles, visitando todos los vértices a una distancia 'd' del vértice origen antes de visitar los vértices a una distancia 'd+1'. El algoritmo BFS puede ser aplicado a grafos dirigidos o no dirigidos, y se utiliza en una variedad de aplicaciones, como encontrar el camino más corto en un grafo no ponderado, determinar la conectividad de un grafo o realizar búsquedas en estructuras de datos jerárquicas como árboles y redes sociales.
- **DFS (Depth-First Search):** Es un algoritmo de recorrido de Grafo que explora el grafo siguiendo un camino desde el vértice origen hasta llegar a un vértice sin vecinos no visitados. Cuando se encuentra un vértice sin vecinos no visitados, el algoritmo retrocede a lo largo del camino hasta encontrar un vértice con vecinos no visitados y continúa la exploración desde allí. El proceso se repite hasta que se visitan todos los vértices alcanzables desde el vértice origen.

### **Descripción de la Solución**
- **Lenguaje de Programación:** Java
- **Interfaz gráfica:** Implementada con **JFrame** en Java.
- **Patrón de Diseño:** **Modelo-Vista-Controlador (MVC)**  Herramienta útil para un proyecto organizado, separa la interfaz de usuario, los datos y la lógica de la aplicación.
- **Estructuras de Datos Utilizadas:**
  - **Matriz:** Para representar el laberinto.
  - **Listas y Pilas:** Para almacenar y explorar rutas posibles.
  - **HashSet:** Para evitar revisitar celdas ya exploradas.

### **Participación de los Integrantes**
- **Jonnathan Parraga:** Desarrollo del modelo y controlador, implementación de BFS y DFS, y documentación del proyecto.
- **Verónica Cobos:** Desarrollo de métodos implementados dentro de los botones, implementación de DPController.
- **Carolina Fortmann:** Desarrollo de la Interfaz Gráfica, sus elementos y funcionamiento, implementación de DPController.

### **Capturas de Pantalla**
### **Interfaz**
![Interfaz-imagen](https://github.com/Jona142004/Proyecto-FInal/blob/main/Interfaz.png)

La imagen muestra una interfaz gráfica diseñada con elementos incluidos en un JFrame, como JButton, JPanel y JTextField, que contribuyen a una apariencia atractiva y estética para el usuario. Esta interfaz permite crear un laberinto de tamaño personalizado, donde el usuario puede definir el punto de inicio, el destino y los obstáculos. 

En la parte inferior, se encuentran los botones que permiten seleccionar el tipo de recorrido para resolver el laberinto. Además, se incluyen opciones para realizar un recorrido más rápido, reiniciar el laberinto y comparar el tiempo estimado de ejecución de cada método de resolución.

---
### **Metodo "BFS"**
![MetodoBFS-imagen](https://github.com/Jona142004/Proyecto-FInal/blob/main/bfs.png)

El resultado visual del primer recorrido BFS (Breadth-First Search) muestra que el algoritmo exploró de manera uniforme desde el punto de inicio, llenando el espacio con nodos visitados (en rojo) hasta encontrar la ruta óptima. Es un claro ejemplo de cómo funciona este algoritmo, ya que explora los vértices de este laberinto en niveles, visitando todos los recuadros a una distancia 'd' del vértice origen antes de visitar los vértices a una distancia 'd+1'.

---
### **Metodo "DFS"**
![MetodoDFS-imagen](https://github.com/Jona142004/Proyecto-FInal/blob/main/dfs.png)

El resultado visual del recorrido DFS (Depth-First Search) muestra que el algoritmo exploró el laberinto de manera secuencial, avanzando por un camino hasta llegar a un punto sin salida antes de retroceder y probar una ruta diferente. Este método se refleja en el laberinto con un camino que serpentea a través de los recuadros hasta encontrar la salida. Es un claro ejemplo de cómo funciona este algoritmo, ya que explora los recuadros del laberinto en profundidad, priorizando la exploración de un camino completo antes de considerar alternativas. A diferencia de BFS, DFS no garantiza encontrar el camino más corto, pero es eficaz para explorar todas las posibles rutas en el laberinto.

---
### **Metodo "Recursivo"**
![MetodoRecursivo-imagen](https://github.com/Jona142004/Proyecto-FInal/blob/main/Recursivo.png)

El resultado visual del recorrido Recursivo muestra que el algoritmo exploró el laberinto utilizando una estrategia de retroceso (backtracking), avanzando por un camino hasta encontrar un punto sin salida y luego retrocediendo para probar rutas alternativas. Este método se refleja en el laberinto con un camino que avanza y retrocede, marcando los nodos visitados (con rojo) hasta encontrar la salida. Es un claro ejemplo de cómo funciona este algoritmo, ya que explora los vértices del laberinto de manera sistemática, priorizando la exploración de un camino completo antes de considerar alternativas. Al igual que DFS, el método recursivo no garantiza encontrar el camino más corto, pero es eficaz para explorar todas las posibles rutas en el laberinto, utilizando la recursión para manejar la exploración y el retroceso.

---
### **Metodo "Programacion Dinamica"**
![MetodoDP-imagen](https://github.com/Jona142004/Proyecto-FInal/blob/main/DP.PNG)
El resultado visual del recorrido utilizando Programación Dinámica (DP) muestra que el algoritmo optimizó la búsqueda de la ruta más eficiente a través del laberinto. A diferencia de los métodos anteriores, DP se enfoca en descomponer el problema en subproblemas más pequeños y almacenar los resultados intermedios para evitar cálculos redundantes. En el laberinto, esto se refleja en un camino que probablemente evita exploraciones innecesarias de manera más directa hacia la solución óptima.

Este método garantiza encontrar la ruta más corta o más eficiente, ya que utiliza un enfoque sistemático para evaluar todas las posibles rutas y selecciona la mejor basándose en los resultados previamente calculados. La imagen puede mostrar un camino más directo y menos sinuoso en comparación con DFS o el método recursivo, destacando la eficiencia de la programación dinámica en la resolución de problemas de optimización como este laberinto.

---
### **Comparacion resultados**
![Comparacion-imagen](https://github.com/Jona142004/Proyecto-FInal/blob/main/Comparaciontiempos.png)

El botón "Comparar Métodos" en la imagen es una funcionalidad clave que permite al usuario analizar y contrastar los resultados de los diferentes algoritmos utilizados para resolver el laberinto. Al hacer clic en este botón, se muestra una comparación detallada de los métodos, como se indica a continuación:
•	BFS (Breadth-First Search): Encontró el camino en 278 µs y 19 pasos. Este algoritmo es eficiente para encontrar la ruta más corta, ya que explora todos los nodos nivel por nivel.
•	DFS (Depth-First Search): Encontró el camino en 144 µs y 55 pasos. Aunque fue más rápido en tiempo de ejecución, no garantiza la ruta más corta, ya que explora en profundidad antes de considerar alternativas.
•	DP (Programación Dinámica): Encontró el camino en 18 µs y 19 pasos. Este método fue el más rápido y eficiente, ya que optimiza la búsqueda al evitar cálculos redundantes y garantiza la ruta más corta.
•	Recursivo: Encontró el camino en 3868824 µs y 19 pasos. Aunque encontró la ruta más corta, fue significativamente más lento debido a la naturaleza de la recursión y la falta de optimización.
El botón "Comparar Métodos" genera una visualización o un resumen que permite al usuario entender las diferencias en tiempo de ejecución, número de pasos y eficiencia entre los algoritmos. Esto es útil para evaluar cuál método es más 
adecuado dependiendo de las necesidades, como la velocidad o la optimización de la ruta.

---

## **Conclusiones**
Este proyecto es una aplicación en Java que permite la generación y resolución de laberintos utilizando distintos algoritmos. A través de una interfaz gráfica intuitiva, el usuario puede definir el tamaño del laberinto, seleccionar un punto de inicio y un punto de fin, y elegir entre varios métodos de resolución para encontrar el camino óptimo.

El sistema cuenta con cuatro algoritmos de búsqueda: BFS (Breadth-First Search), DFS (Depth-First Search), Recursivo y Programación Dinámica (DP), cada uno con sus propias estrategias para explorar el laberinto. Además, la aplicación permite comparar el desempeño de estos métodos en términos de tiempo de ejecución y número de pasos requeridos.

Visualmente, el laberinto se representa con una cuadrícula donde las celdas pueden ser caminos transitables, paredes que bloquean el paso o parte del recorrido encontrado por los algoritmos. Los colores ayudan a diferenciar los elementos del laberinto: el inicio y el fin se marcan de manera distintiva, los caminos explorados se resaltan en verde, y los nodos visitados en rojo.

Esta herramienta no solo facilita la experimentación con distintos algoritmos de búsqueda, sino que también sirve como un recurso educativo para comprender cómo funcionan en la práctica.

---

## **Recomendaciones**
- Emplear el funcionamiento del Modelo-Vista-Controlador en futuras aplicaciones.
- Refactorizar el código para mejorar la legibilidad y eficiencia.
- Implementar pruebas automatizadas para verificar la validez de los algoritmos.
- Optimizar la interfaz gráfica para hacerla más intuitiva y flexible.
- Explorar otros algoritmos como A* para mejorar la búsqueda de rutas óptimas.
- Aplicar esta solución en otros ámbitos como la robótica y la inteligencia artificial.

---

## **Versión del Proyecto**
- **Versión:** 1.0.0
- **Mensaje de versión:** "Proyecto Final – Estructura de Datos"
- **Repositorio:** [https://github.com/Jona142004/Proyecto-FInal/tree/main]

---

## **Docente**
**Ing. Pablo Torres**



