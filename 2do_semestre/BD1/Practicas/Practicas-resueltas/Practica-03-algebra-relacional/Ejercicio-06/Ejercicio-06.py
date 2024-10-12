import sys, os

script_dir = os.path.dirname(os.path.abspath(__file__))
parent_dir = os.path.abspath(os.path.join(script_dir, ".."))

sys.path.append(parent_dir)

from generate_table import generate_table

sys.path.append(script_dir)

CANT_DUENIOS = 10
CANT_CHOFERES = 10
CANT_AUTOS = 10
CANT_VIAJES = 10

columns_dueno = [
    ("id_dueno", "id"),
    ("nombre", "name"),
    ("telefono", "telefono"),
    ("direccion", "direccion"),
    ("dni", "dni"),
]

columns_chofer = [
    ("id_chofer", "id"),
    ("nombre", "name"),
    ("telefono", "telefono"),
    ("direccion", "direccion"),
    ("fecha_licencia_desde_dia", "dia"),
    ("fecha_licencia_desde_mes", "mes"),
    ("fecha_licencia_desde_anio", "anio"),
    ("fecha_licencia_hasta_dia", "dia"),
    ("fecha_licencia_hasta_mes", "mes"),
    ("fecha_licencia_hasta_anio", "anio"),
    ("dni", "dni"),
]

columns_auto = [
    ("patente", "patente"),
    ("id_dueno", "number", (1, CANT_DUENIOS)),
    ("id_chofer", "number", (1, CANT_CHOFERES)),
    ("marca", "marca"),
    ("modelo", "string"),
    ("anio", "anio"),
]

columns_viaje = [
    ("patente", "extra-patente"),
    ("hora_desde", "hora"),
    ("hora_hasta", "hora"),
    ("origen", "ciudad"),
    ("destino", "ciudad"),
    ("tarifa", "float", (100, 10_000)),
    ("metraje", "float", (1, 500)),
]


nombre_grupo = "Ejercicio-06"
output_file = os.path.join(script_dir, "Tablas-para-relaX.txt")

with open(output_file, "w") as f:
    f.write("-- https://dbis-uibk.github.io/relax/landing\n\n")
    f.write(f"group: {nombre_grupo}\n\n")

# Generar tablas de ejemplo
generate_table("DUENIO", CANT_DUENIOS, columns_dueno, output_file=output_file)
generate_table("CHOFER", CANT_CHOFERES, columns_chofer, output_file=output_file)
autos = generate_table("AUTO", CANT_AUTOS, columns_auto, output_file=output_file)
patentes = [auto["patente"] for auto in autos]
generate_table("VIAJE", CANT_VIAJES, columns_viaje, output_file, extra_columns={"extra-patente": ["string", patentes]})
