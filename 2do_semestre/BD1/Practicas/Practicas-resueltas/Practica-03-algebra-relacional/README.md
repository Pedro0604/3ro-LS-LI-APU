# Funcionamiento de la [creación de tablas](https://github.com/Pedro0604/3ro-LS-LI-APU/blob/main/2do_semestre/BD1/Practicas/Practicas-resueltas/Practica-03-algebra-relacional/generate_table.py) para la calculadora de algebra relacional [RelaX](https://dbis-uibk.github.io/relax/landing)
## [Manual de RelaX](https://dbis-uibk.github.io/relax/help)
### Tiene cargada la información necesaria para generar las tablas a usar en los ejercicios de la práctica, pero se pueden agregar más tipos de columnas
> [!IMPORTANT]  
> Requiere la librería faker<br>
> Para eso, en la terminal, correr:
> ```
> pip install faker
> 
> ```

> [!IMPORTANT]  
> Si se crean archivos que llamen a la función generate_table se debe hacer un append del path del directorio que contiene al archivo generate_table.py para poder importar dicha función <br>
> En los archivos que hice esto lo hago de la siguiente manera:
> ``` python
> import sys, os
>
> script_dir = os.path.dirname(os.path.abspath(__file__))
> parent_dir = os.path.abspath(os.path.join(script_dir, ".."))
>
> sys.path.append(parent_dir)
>
> from generate_table import generate_table
> ```
> Lo hago así ya que en todos los casos, el archivo generate_table.py está en el directorio padre de donde está el archivo actual

#### Para añadir un tipo se puede:
* Añadirlo a los tipos extra:
  * Hay que añadirlo al diccionario tipos_extra y definir el nombre y los valores posibles
* Añadir un if (los profes de OO2 se mueren si ven eso 😂):
  * Dentro del if hay que asignarle a value el valor
  * Se puede usar un rango de python bajo el nombre column_range en caso de ser necesario (debería chequearse que exista)

## Funcionalidad
* Genera una tabla para usar en [RelaX](https://dbis-uibk.github.io/relax/landing)
* La función generate table toma como parámetros:
  * table_name: el nombre de la tabla
  * size: la cantidad de tuplas de la tabla
  * columns: las columnas de la tabla
    * Las columnas son un array de tuplas (de python no de base de datos 😂)
    * La primera entrada de la tupla es el nombre de la columna (no usar caracteres especiales)
    * La segunda entrada de la tupla es el tipo de la columna (alguno de los definidos en los if o en tipos_extra)
    * La tercera entrada de la tupla (opcional) es el rango de la columna (para los números define un rango en el que puedan estar)
  * output_file: el archivo donde va a escribirse la generación de las tablas (se escribe al final del archivo, así que si se lo llama múltiples veces se debería borrar su contenido previamente)
  * extra_columns: sirve para definir tipos nuevos:
    * Es un diccionario donde la clave es el nombre del tipo, y el valor es un array donde el primer valor es el tipo de relaX (string, number o boolean) y el segundo valor es la lista de valores a elegir
    * En el [Ejercicio-06.py](https://github.com/Pedro0604/3ro-LS-LI-APU/blob/main/2do_semestre/BD1/Practicas/Practicas-resueltas/Practica-03-algebra-relacional/Ejercicio-06/Ejercicio-06.py) hay un ejemplo donde las patentes de los viajes se generan en base a las patentes de los autos y en el [Ejercicio-07.py](https://github.com/Pedro0604/3ro-LS-LI-APU/blob/main/2do_semestre/BD1/Practicas/Practicas-resueltas/Practica-03-algebra-relacional/Ejercicio-07/Ejercicio-07.py) un ejemplo donde las carrearas de los estudiantes se generan en base a los distintos codigos de carrera generados previamente
  * La función devuelve un array de diccionarios donde cada key es el nombre de la columna y el valor es el valor que toma dicha columna
    * Puede servir para realizar tipos extras basados en otras tablas generadas previamente como se mencionó previamente que se hace en el [Ejercicio-06.py](https://github.com/Pedro0604/3ro-LS-LI-APU/blob/main/2do_semestre/BD1/Practicas/Practicas-resueltas/Practica-03-algebra-relacional/Ejercicio-06/Ejercicio-06.py) y en el [Ejercicio-07.py](https://github.com/Pedro0604/3ro-LS-LI-APU/blob/main/2do_semestre/BD1/Practicas/Practicas-resueltas/Practica-03-algebra-relacional/Ejercicio-07/Ejercicio-07.py)

## Uso
* En cada una de las carpetas de los ejercicios resueltos hay un archivo Ejercicio-XX.py que tiene:
  * La definición de las columnas necesarisa para el archivo de RelaX
  * El llamado a la función generate_table
  * Una cabecera con:
    * Un comentario indicando la página utilizada
    * El nombre del grupo (obligatorio para que sea leido en [RelaX](https://dbis-uibk.github.io/relax/landing))
* En cada una de las carpetas de los ejercicios resueltos hay un archivo Taablas-para-relaX.txt que contiene una posible tabla a usar para el ejercicio en cuestión
* Las tablas que están disponibles contemplan los diferentes escenarios que se necesitan probar en los distintos ejercicios, ya que fueron ligeramente modificadas luego de su creación para cubrir todos los casos que se presentan en la práctica

## Cargar las tablas generadas en [RelaX](https://dbis-uibk.github.io/relax/landing)
1. Ir a la sección de Group Editor de [la calculadora](https://dbis-uibk.github.io/relax/calc/local/uibk/local/0)
2. Copiar el contenido del archivo generado
3. Hacer click en preview para visualizar cómo quedarían las tablas generadas
4. Hacer click en use group in editor para poder realizar consultas de álgebra relacional

## Ejercicios
* Los ejercicios resueltos en los archivos .txt pueden ser copiados directamente a la calculadora de álgebra relacional
* No sucede lo mismo con los ejercicios del pdf de la [práctica 3 resuelta](https://github.com/Pedro0604/3ro-LS-LI-APU/blob/main/2do_semestre/BD1/Practicas/Practicas-resueltas/Practica-03-algebra-relacional/Practica-03-resuelta.pdf), ya que no usan la sintaxis de [RelaX](https://dbis-uibk.github.io/relax/landing) sino la de la cátedra
