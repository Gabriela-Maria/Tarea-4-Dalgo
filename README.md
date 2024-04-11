# Tarea-4-Dalgo
Por Gabriela Escobar y Maria Alejandra Pinzon

# Problema 1

Para correr el programa seguir los siguientes pasos:
- Para poder probar el programa, hay que incluir el archivo con los valores de la matriz en la carpeta "data". 
- Correr la clase "CaminosCostosMinimos" y luego Ingresar el nombre del archivo de datos sin la extensión .txt. Por ejemplo, si el archivo se llama distances5.txt, simplemente escribe distances5 cuando el programa lo solicite.
- Luego ingresa el número correspondiente al algoritmo que deseas usar (1 para Dijkstra, 2 para Bellman Ford, 3 para Floyd Warschall).

# Problema 1.1 Dijkstra
|E/S|Descripcion|
|-------|--------|
|Entrada| Una matriz cuadrada donde cada fila (i) y columna (j) representa un vertice del grafo, y el valor en la posición i, j indica el costo de ir directamente del vertice i al vertice j. Hay 3 posibilidades de valores en esta matriz. El valor -1 en la posición i,j significa que no hay un arco del vertice i al vertice j.  El valor de 0  indica que el costo de ir de un vertice a si mismo es nulo. La ultima posibilidad para los valores de esta matriz es que el valor sea positivo representando el costo de ir de un vertice al otro.|
|Salida|  Una matriz de costos mínimos que indica por cada vertice i el costo mínimo para llegar de este vertice a todos los demás vertices j. Esta salida se guarda en 'OUT_dijkstra.txt' de la carpeta data al correr el programa .|

# Problema 1.2 Bellman Ford
|E/S|Descripcion|
|-------|--------|
|Entrada| Una matriz cuadrada donde cada fila (i) y columna (j) representa un vertice del grafo, y el valor en la posición i, j indica el costo de ir directamente del vertice i al vertice j. El valor -1 en la posición i,j significa que no hay un arco del vertice i al vertice j.  El valor de 0  indica que el costo de ir de un vertice a si mismo es nulo. Los otros valores, que pueden ser tanto positivos como negativos, representan el costo de ir de un vertice a otro.|
|Salida|  Una matriz de costos mínimos que indica por cada vertice i el costo mínimo para llegar de este vertice a todos los demás vertices j. Esta salida se guarda en 'OUT_bellmanFord.txt' de la carpeta data al correr el programa.|

# Problema 1.3 Floyd Warschall
|E/S|Descripcion|
|-------|--------|
|Entrada| Una matriz cuadrada donde cada fila (i) y columna (j) representa un vertice del grafo, y el valor en la posición i, j indica el costo de ir directamente del vertice i al vertice j. Hay 3 posibilidades de valores en esta matriz. El valor -1 en la posición i,j significa que no hay un arco del vertice i al vertice j.  El valor de 0  indica que el costo de ir de un vertice a si mismo es nulo. La ultima posibilidad para los valores de esta matriz es que el valor sea positivo representando el costo de ir de un vertice al otro.|
|Salida|  Una matriz de costos mínimos que indica por cada vertice i el costo mínimo para llegar de este vertice a todos los demás vertices j. Esta salida se guarda en 'OUT_floydWarschall.txt' de la carpeta data al correr el programa.|




# Problema 2
Ejemplo grafico de entrada (distanceDisconnected2):
![Captura de pantalla 2024-04-09 120633](https://github.com/Gabriela-Maria/Tarea-4-Dalgo/assets/123558557/6d018ea9-b6b6-483a-9b0f-2447dc060a3e)

|E/S|Descripcion|
|-------|--------|
|Entrada| Una matriz que tiene como ejes los vertices del grafo. Si el valor de (x,y) es 1, esto indica que existe una relación entre los ejes x y y. Para poder probar el programa, hay que incluir el archivo con los valores de la matriz en la carpeta "data". Adicionalmente, cuando se corra el programa, hay que poner el nombre del archivo que se esta probando. Cuando se ponga el nombre, no se tiene que escribir .txt. Un ejemplo de esto es escribir en consola distancesDisconnected2.|
|Salida| Los componentes conectados con sus vertices. Es una lista, con pilas dentro. Cada pila es un componente conectado y su contenido son los vertices que pertenecen a dicho componente. Sera un tipo de dato ArrayList<Queue<Integer>>. |

# Problema 3
Ejemplo grafico de entrada (mapUndirected):
![Captura de pantalla 2024-04-09 121240](https://github.com/Gabriela-Maria/Tarea-4-Dalgo/assets/123558557/714af488-60b3-462f-accb-0377e034078d)

|E/S|Descripcion|
|-------|--------|
|Entrada| El programa recibe un "mapa" de la ciudad compuesto de las esquinas y el costo de hacer las calles que lo componen doble vía. Se recibe como entrada una matriz de tres columnas: la primera indica la esquina 1 (vertice 1), la segunda la esquina 2 (vertice 2), y la tercera es el costo de convertir la calle que conecta ambas esquinas  en doble vía (peso del arco que conecta esos vertices). Para poder probar el programa, hay que incluir el archivo con los valores de la matriz en la carpeta "data". Adicionalmente, cuando se corra el programa, hay que poner el nombre del archivo que se esta probando. Cuando se ponga el nombre, no se tiene que escribir .txt. Un ejemplo de esto es escribir en consola mapUndirected.|
|Salida| El costo mínimo de hacer las implementaciones necesarias a la ciudad para convertirla en doble vía, el costo mínimo del MST encontrado|
|Salida| Las calles que ahora deben ser doble vías, los arcos que hacen parte del MST.|

# Problema 4

Para correr el programa seguir los siguientes pasos:
1- Para poder probar el programa, hay que incluir el archivo txt de acuerdo a la especificacion de este que se explicará acontinuación, en "data". 
2- Correr la clase "CantidadesMaximas" y luego Ingresar el nombre del archivo de datos sin la extensión .txt. Por ejemplo, si el archivo se llama red.txt, simplemente escribe red cuando el programa lo solicite.

Explicación del archivo .txt que contiene los datos con los que se crea el grafo dirigido que representa una red de distribución : 
Cada línea del archivo `.txt` representa un elemento diferente en la red de distribución, que incluye fábricas, librerías, bodegas y camiones. Aquí se explica cada tipo de línea:

### Fábricas (`F`)

- **Descripción**: Representan los puntos de origen de los libros.
- **Formato**: `F,<id de la fábrica>`
- **Ejemplo**: `F,1` - Una fábrica con identificador `1`.

### Librerías (`L`)

- **Descripción**: Representan los puntos de destino de los libros.
- **Formato**: `L,<id de la librería>`
- **Ejemplo**: `L,8` - Una librería con identificador `8`.

### Bodegas (`B`)

- **Descripción**: Actúan como puntos intermedios de almacenamiento.
- **Formato**: `B,<id de la bodega>,<capacidad de la bodega>`
- **Ejemplo**: `B,4,3` - Una bodega con identificador `4` y capacidad de almacenamiento de `3`.

### Camiones (`C`)

- **Descripción**: Representan las rutas de transporte entre los puntos de la red.
- **Formato**: `C,<id origen>,<id destino>,<capacidad del camión>`
- **Ejemplo**: `C,1,4,1` - Un camión que va de la fábrica `1` a la bodega `4` con una capacidad de `1`.



|E/S|Descripcion|
|-------|--------|
|Entrada| Archivo que define la estructura completa del grafo dirigido. |
|Salida| Cantidad máxima de libros que pueden ser distribuidos desde las fábricas hasta las librerías bajo las restricciones de capacidad de los camiones y bodegas. |
