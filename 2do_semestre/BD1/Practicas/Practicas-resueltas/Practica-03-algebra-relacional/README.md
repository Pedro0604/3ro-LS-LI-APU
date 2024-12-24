# Funcionamiento de la [creación de tablas](https://github.com/Pedro0604/3ro-LS-LI-APU/blob/main/2do_semestre/BD1/Practicas/Practicas-resueltas/Practica-03-algebra-relacional/generate_table.py) para la calculadora de algebra relacional [RelaX](https://dbis-uibk.github.io/relax/landing)
### Tiene cargada la información necesaria para generar las tablas a usar en los ejercicios de la práctica, pero se pueden agregar más tipos de columnas
> [!IMPORTANT]  
> Requiere la librería faker<br>
> Para eso, en la terminal, correr:
> ```
> pip install faker
> 
> ```
#### Para añadir un tipo se puede:
* Añadirlo a los tipos extra:
  * Hay que añadirlo al diccionario tipos_extra y definir el nombre y los valores posibles
* Añadir un if (los profes de OO2 se mueren si ven eso 😂):
  * Dentro del if hay que asignarle a value el valor
  * Se puede usar un rango de python bajo el nombre column_range en caso de ser necesario (debería chequearse que exista)

## Funcionalidad:
* Genera una tabla para usar en [RelaX](https://dbis-uibk.github.io/relax/landing)
* La función generate table toma como parámetros:
  * table_name: el nombre de la tabla
  * size: la cantidad de tuplas de la tabla
  * columns: las columnas de la tabla
    * Las columnas son un array de tuplas (de python no de base de datos 😂)
    * La primera entrada de la tupla es el nombre de la columna (no usar caracteres especiales)
    * La segunda entrada de la tupla es el tipo de la columna (alguno de los definidos en los if o en tipos_extra)
    * La tercera entrada de la tupla (opcional) es el rango de la columna (para los números define un rango en el que puedan estar)

## Uso
### Se ejecuta el programa y se debe:
1. Seleccionar el ejercicio que se desea (el default es el 13)
2. Seleccionar el algoritmo que se desea (el default es el FCFS)
3. Listo 😃
