from faker import Faker
import random

# Inicializar faker para generar datos aleatorios
fake = Faker()
_tipos_extra = {
    "nacionalidad": [
        "Argentina",
        "Brasil",
        "Chile",
        "Uruguay",
        "Paraguay",
        "Colombia",
        "Peru",
        "Espania",
        "Estados Unidos",
        "Mexico",
        "Venezuela",
        "Bolivia",
        "Ecuador",
        "Cuba",
        "Puerto Rico",
        "Republica Dominicana",
        "Honduras",
        "Guatemala",
        "El Salvador",
        "Nicaragua",
        "Costa Rica",
        "Panama",
        "Portugal",
        "Francia",
        "Alemania",
        "Italia",
        "Reino Unido",
        "Irlanda",
        "Suecia",
        "Noruega",
        "Dinamarca",
        "Paises Bajos",
        "Belgica",
        "Suiza",
        "Grecia",
        "Rusia",
        "Japon",
        "China",
        "India",
        "Corea del Sur",
        "Australia",
        "Nueva Zelanda",
        "Sudafrica",
        "Egipto",
        "Nigeria",
        "Kenia",
        "Israel",
        "Arabia Saudita",
        "Turquia",
    ],
    "codigo_carrera": [
        "LI07",  # Licenciatura en Informática
        "LS12",  # Licenciatura en Sistemas
        "AR01",  # Arquitectura
        "MA02",  # Matemáticas
        "FI03",  # Física
        "QU04",  # Química
        "EN05",  # Ingeniería en Energía
        "EC06",  # Economía
        "AD07",  # Administración de Empresas
        "PS08",  # Psicología
        "HI09",  # Historia
        "SO10",  # Sociología
        "DI11",  # Diseño Gráfico
        "CO12",  # Comunicación
        "MU13",  # Música
        "TE14",  # Teatro
        "PE15",  # Pedagogía
        "GE16",  # Geografía
        "CI17",  # Ciencias de la Computación
        "DA18",  # Desarrollo de Aplicaciones
        "IN19",  # Ingeniería Industrial
        "NT20",  # Nutrición
        "CV21",  # Contabilidad y Finanzas
        "LS22",  # Lengua y Literatura
        "CR23",  # Criminología
        "PH24",  # Filosofía
        "PR25",  # Relaciones Públicas
        "SA26",  # Salud Pública
        "ED27",  # Educación
        "LT28",  # Lenguas Extranjeras
        "ET29",  # Ética
    ],
    "tipo_madera": [
        "Pino",
        "Roble",
        "Nogal",
        "Cerezo",
        "Arce",
        "Abeto",
        "Bambu",
        "Haya",
        "Cedro",
        "Melamina",
        "MDF",
    ],
    "ambiente": [
        "Sala de Estar",
        "Comedor",
        "Cocina",
        "Dormitorio",
        "Banio",
        "Oficina",
        "Estudio",
        "Sala de Juegos",
        "Terraza",
        "Jardin",
        "Bodega",
        "Lavadero",
    ],
}


def _map_column_type(column_type, extra_columns=None):
    """
    Convierte tipos personalizados a tipos validos (number, string, boolean).
    """
    if column_type in [
        "id",
        "dni",
        "anio",
        "number",
        "dia",
        "mes",
        "float",
        "hora",
        "minuto",
    ]:
        return "number"
    elif column_type in [
        "name",
        "asiento",
        "aeropuerto",
        "string",
        "telefono",
        "direccion",
        "patente",
        "email",
        "ciudad",
        "marca",
    ]:
        return "string"
    elif column_type == "boolean":
        return "boolean"
    elif extra_columns is not None and column_type in extra_columns.keys():
        return extra_columns[column_type][0]
    else:
        return "string"


def generate_table(table_name, size, columns, output_file, extra_columns=None):
    """
    Genera una tabla con datos aleatorios.

    :param table_name: Nombre de la tabla
    :param size: Numero de filas
    :param columns: Lista de tuplas (nombre_columna, tipo_dato)
    """
    data = []
    with open(output_file, "a") as f:
        f.write(f"{table_name} = {{\n")
        # Crear cabecera de la tabla
        header = ", ".join(
            [
                f"{col[0]}:{_map_column_type(col[1], extra_columns=extra_columns)}"
                for col in columns
            ]
        )
        f.write(f"    {header}\n")

        for i in range(1, size + 1):
            row = {}
            for column_info in columns:
                column_name = column_info[0]
                column_type = column_info[1]
                column_range = (
                    column_info[2] if len(column_info) > 2 else None
                )  # Rango opcional

                value = None
                if extra_columns is not None and column_type in extra_columns.keys():
                    value = f"{random.choice(extra_columns[column_type][1])}"  # Elige uno random de los valores posibles
                elif column_type == "boolean":
                    value = random.choice(["True", "False"])
                elif column_type == "number":
                    min_val, max_val = column_range if column_range else (1, 10000)
                    value = random.randint(min_val, max_val)
                elif column_type == "string":
                    value = f'"{fake.word()}"'  # Palabras aleatorias
                elif column_type == "dni":
                    value = fake.random_number(digits=8)  # Números de DNI aleatorios
                elif column_type == "name":
                    value = f'"{fake.first_name()}"'  # Nombres aleatorios
                elif column_type == "float":
                    min_val, max_val = column_range if column_range else (100, 1000)
                    value = f"{round(random.uniform(min_val, max_val), 2)}"
                elif column_type == "asiento":
                    value = f'"{random.randint(1, 30)}{random.choice(["A", "B", "C", "D", "E", "F"])}"'  # Asientos aleatorios
                elif column_type == "dia":
                    value = random.randint(1, 31)  # Dias entre 1 y 31
                elif column_type == "mes":
                    value = random.randint(1, 12)  # Meses entre 1 y 12
                elif column_type == "anio":
                    min_val, max_val = column_range if column_range else (2023, 2025)
                    value = random.randint(min_val, max_val)  # Años entre 2024 y 2025
                elif column_type == "aeropuerto":
                    value = f'"{random.choice(["Buenos Aires", "Ministro Pistarini", "Cordoba", "Rosario"])}"'  # Aeropuertos aleatorios
                elif column_type == "id":
                    value = i
                elif column_type == "telefono":
                    value = f'"{fake.phone_number()}"'  # Telefonos aleatorios
                elif column_type == "direccion":
                    value = f'"{fake.address().replace("\n", " ")}"'  # Direcciones aleatorias
                elif column_type == "patente":
                    value = f'"{fake.license_plate()}"'  # Patentes aleatorias
                elif column_type == "hora":
                    value = random.randint(0, 23)  # Hora entre 0 y 23
                elif column_type == "minuto":
                    value = random.randint(0, 59)  # Minuto entre 0 y 59
                elif column_type == "email":
                    value = f'"{fake.email()}"'  # Emails aleatorios
                elif column_type == "origen":
                    value = f'"{fake.city()}"'  # Ciudades de origen aleatorias
                elif column_type == "marca":
                    value = f'"{fake.company()}"'  # Marca aleatoria
                elif column_type in _tipos_extra.keys():
                    value = f'"{random.choice(_tipos_extra[column_type])}"'
                else:
                    raise ValueError(f"Tipo de dato no soportado: {column_type}")

                row[column_name] = value
            f.write(f"    {', '.join(map(str, row.values()))}\n")
            data.append(row)

        f.write("}\n\n")
        return data
