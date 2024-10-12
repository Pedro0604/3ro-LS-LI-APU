import sys, os

script_dir = os.path.dirname(os.path.abspath(__file__))
parent_dir = os.path.abspath(os.path.join(script_dir, ".."))

sys.path.append(parent_dir)

from generate_table import generate_table

sys.path.append(script_dir)

CANT_ESTUDIANTES = 100
CANT_CARRERAS = 15
CANT_INSCRIPCIONES = 125
CANT_MATERIAS = 20


columns_carrera = [
    ("codigoDeCarrera", "codigo_carrera"),
    ("nombre", "string"),
]

columns_estudiante = [
    ("legajo", "id"),
    ("nombreCompleto", "name"),
    ("nacionalidad", "nacionalidad"),
    ("anioDeIngreso", "anio", (2019, 2021)),
    ("codigoDeCarrera", "extra_codigo_carrera"),
]

columns_materia = [
    ("codigoDeMateria", "id"),
    ("nombre", "string"),
]

columns_inscripcion_materia = [
    ("legajo", "number", (1, CANT_ESTUDIANTES)),
    ("codigoDeMateria", "number", (1, CANT_MATERIAS)),
]

nombre_grupo = "Ejercicio-07"
output_file = os.path.join(script_dir, "Tablas-para-relaX.txt")

with open(output_file, "w") as f:
    f.write("-- https://dbis-uibk.github.io/relax/landing\n\n")
    f.write(f"group: {nombre_grupo}\n\n")

carreras = generate_table(
    "CARRERA", CANT_CARRERAS, columns_carrera, output_file=output_file
)
codigos_carrera = [carrera["codigoDeCarrera"] for carrera in carreras]
generate_table(
    "ESTUDIANTE",
    CANT_ESTUDIANTES,
    columns_estudiante,
    output_file=output_file,
    extra_columns={"extra_codigo_carrera": ["string", codigos_carrera]},
)

generate_table(
    "INSCRIPCIONAMATERIA",
    CANT_INSCRIPCIONES,
    columns_inscripcion_materia,
    output_file=output_file,
)

generate_table("MATERIA", CANT_MATERIAS, columns_materia, output_file=output_file)
