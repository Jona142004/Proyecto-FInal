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
   - Formato de versión: `x.x.x`
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
- **Estudiante:** Jonnathan Parraga ([jparragar1@est.ups.edu.ec] (mailto:jparragar1@est.ups.edu.ec))
- **Estudiante:** Jonnathan Parraga ([mcobosa@est.ups.edu.ec] (mailto:mcobosa@est.ups.edu.ec))
- **Estudiante:** Jonnathan Parraga ([dfortmann@est.ups.edu.ec] (mailto:dfortmann@est.ups.edu.ec))
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
_Agregar imágenes de la interfaz implementada_
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



