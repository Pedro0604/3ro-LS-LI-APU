import sys, os

script_dir = os.path.dirname(os.path.abspath(__file__))
parent_dir = os.path.abspath(os.path.join(script_dir, ".."))

sys.path.append(parent_dir)

from generate_table import generate_table

sys.path.append(script_dir)

CANT_EMPLEADOS = 20
CANT_DEPARTAMENTOS = 3
CANT_CURSOS = 4
CANT_CURSOS_REALIZADOS = 25

columns_lugar_trabajo = [
    ("empleado", "id"),
    ("departamento", "number", (1, CANT_DEPARTAMENTOS)),
]

columns_curso_exigido = [
    ("departamento", "number", (1, CANT_DEPARTAMENTOS)),
    ("curso", "id"),
]

columns_curso_realizado = [
    ("empleado", "number", (1, CANT_EMPLEADOS)),
    ("curso", "number", (1, CANT_CURSOS)),
]

nombre_grupo = "Ejercicio-08"
output_file = os.path.join(script_dir, "Tablas-para-relaX.txt")

with open(output_file, "w") as f:
    f.write("-- https://dbis-uibk.github.io/relax/landing\n\n")
    f.write(f"group: {nombre_grupo}\n\n")

generate_table(
    "LUGAR_TRABAJO", CANT_EMPLEADOS, columns_lugar_trabajo, output_file=output_file
)
generate_table(
    "CURSO_EXIGIDO", CANT_CURSOS, columns_curso_exigido, output_file=output_file
)
generate_table(
    "CURSO_REALIZADO",
    CANT_CURSOS_REALIZADOS,
    columns_curso_realizado,
    output_file=output_file,
)
