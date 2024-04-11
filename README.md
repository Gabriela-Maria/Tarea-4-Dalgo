# Tarea-4-Dalgo
Por Gabriela Escobar y Maria Alejandra Pinzon
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
|Salida| Las callesque ahora deben ser doble vías, los arcos que hacen parte del MST.|
