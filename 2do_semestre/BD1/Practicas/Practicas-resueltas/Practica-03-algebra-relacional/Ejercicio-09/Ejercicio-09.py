import sys, os

script_dir = os.path.dirname(os.path.abspath(__file__))
parent_dir = os.path.abspath(os.path.join(script_dir, ".."))

sys.path.append(parent_dir)

from generate_table import generate_table

sys.path.append(script_dir)

# Cantidades de registros
CANT_TIPOMUEBLES = 5
CANT_FABRICANTES = 15
CANT_TIPOMADERAS = 5
CANT_AMBIENTES = 5
CANT_MUEBLES = 20

# Definición de columnas para cada tabla
columns_tipomueble = [
    ("id_tipomueble", "id"),
    ("descripcion", "string"),
]

columns_fabricante = [
    ("id_fabricante", "id"),
    ("nombrefabricante", "name"),
    ("cuit", "dni"),
]

columns_tipomadera = [
    ("id_tipomadera", "id"),
    ("nombremadera", "tipo_madera"),
]

columns_ambiente = [
    ("id_ambiente", "id"),
    ("descripcionambiente", "ambiente"),
]

columns_mueble = [
    ("id_mueble", "id"),
    ("id_tipomueble", "number", (1, CANT_TIPOMUEBLES)),
    ("id_fabricante", "number", (1, CANT_FABRICANTES)),
    ("id_tipomadera", "number", (1, CANT_TIPOMADERAS)),
    ("precio", "float", (10_000, 250_000)),
    ("dimensiones", "string"),
    ("descripcion", "string"),
]

columns_muebleambiente = [
    ("id_mueble", "number", (1, CANT_MUEBLES)),
    ("id_ambiente", "number", (1, CANT_AMBIENTES)),
]

nombre_grupo = "Ejercicio-09"
output_file = os.path.join(script_dir, "Tablas-para-relaX.txt")

with open(output_file, "w") as f:
    f.write("-- https://dbis-uibk.github.io/relax/landing\n\n")
    f.write(f"group: {nombre_grupo}\n\n")

generate_table("TIPOMUEBLE", CANT_TIPOMUEBLES, columns_tipomueble, output_file=output_file)
generate_table("FABRICANTE", CANT_FABRICANTES, columns_fabricante, output_file=output_file)
generate_table("TIPOMADERA", CANT_TIPOMADERAS, columns_tipomadera, output_file=output_file)
generate_table("AMBIENTE", CANT_AMBIENTES, columns_ambiente, output_file=output_file)
generate_table("MUEBLE", CANT_MUEBLES, columns_mueble, output_file=output_file)
generate_table("MUEBLEAMBIENTE", CANT_MUEBLES, columns_muebleambiente, output_file=output_file)
