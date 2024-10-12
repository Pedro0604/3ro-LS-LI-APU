import sys, os

script_dir = os.path.dirname(os.path.abspath(__file__))
parent_dir = os.path.abspath(os.path.join(script_dir, ".."))

sys.path.append(parent_dir)

from generate_table import generate_table

sys.path.append(script_dir)

CANT_VUELOS = 100
CANT_RESERVAS = 100
CANT_PASAJEROS = 20

# Ejemplo de uso
columns_pasajero = [
    ("pasajero_id", "id"),
    ("nombre", "name"),
    ("dni", "dni"),
    ("puntaje", "float", (0, 10)),
]

columns_vuelo = [
    ("vuelo_id", "id"),
    ("aeropuerto_salida", "aeropuerto"),
    ("aeropuerto_destino", "aeropuerto"),
    ("dia_vuelo", "dia"),
    ("mes_vuelo", "mes"),
    ("anio_vuelo", "anio"),
]

columns_reserva = [
    ("reserva_id", "id"),
    ("vuelo_id", "number", (1, CANT_VUELOS)),
    ("dia_reserva", "dia"),
    ("mes_reserva", "mes"),
    ("anio_reserva", "anio"),
    ("monto", "float", (10_000, 120_000)),
    ("asiento", "asiento"),
]

columns_pasajero_reserva = [
    ("reserva_id", "id"),
    ("pasajero_id", "number", (1, CANT_PASAJEROS)),
]

nombre_grupo = "Ejercicio-04"
output_file = os.path.join(script_dir, "Tablas-para-relaX.txt")

with open(output_file, "w") as f:
    f.write("-- https://sotelo.ia-ugto.mx/archivos/ra/calc.htm\n\n")
    f.write(f"group: {nombre_grupo}\n\n")

# Generar tablas de ejemplo
generate_table("PASAJERO", CANT_PASAJEROS, columns_pasajero, output_file=output_file)
generate_table(
    "PASAJERO_RESERVA", CANT_RESERVAS, columns_pasajero_reserva, output_file=output_file
)
generate_table("RESERVA", CANT_RESERVAS, columns_reserva, output_file=output_file)
generate_table("VUELO", CANT_VUELOS, columns_vuelo, output_file=output_file)
