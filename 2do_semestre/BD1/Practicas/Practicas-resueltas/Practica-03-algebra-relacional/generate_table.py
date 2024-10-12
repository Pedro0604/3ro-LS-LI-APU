from faker import Faker
import random

# Inicializar faker para generar datos aleatorios
fake = Faker()


def map_column_type(column_type):
    """
    Convierte tipos personalizados a tipos válidos (number, string, boolean).
    """
    if column_type in ["id", "dni", "anio", "number", "dia", "mes", "float"]:
        return "number"
    elif column_type in ["name", "asiento", "aeropuerto", "string"]:
        return "string"
    elif column_type == "boolean":
        return "boolean"
    else:
        return column_type


def generate_table(table_name, size, columns, output_file):
    """
    Genera una tabla con datos aleatorios.

    :param table_name: Nombre de la tabla
    :param size: Número de filas
    :param columns: Lista de tuplas (nombre_columna, tipo_dato)
    """
    with open(output_file, "a") as f:
        f.write(f"{table_name} = {{\n")
        # Crear cabecera de la tabla
        header = ", ".join([f"{col[0]}:{map_column_type(col[1])}" for col in columns])
        f.write(f"    {header}\n")

        for i in range(1, size + 1):
            row = []
            for column_info in columns:
                column_type = column_info[1]
                column_range = (
                    column_info[2] if len(column_info) > 2 else None
                )  # Rango opcional

                if column_type == "number":
                    min_val, max_val = column_range if column_range else (1, 10000)
                    row.append(random.randint(min_val, max_val))
                elif column_type == "string":
                    row.append(f'"{fake.word()}"')  # Palabras aleatorias
                elif column_type == "dni":
                    row.append(
                        fake.random_number(digits=8)
                    )  # Números de DNI aleatorios
                elif column_type == "name":
                    row.append(f'"{fake.first_name()}"')  # Nombres aleatorios
                elif column_type == "float":
                    min_val, max_val = column_range if column_range else (100, 1000)
                    row.append(f"{round(random.uniform(min_val, max_val), 2)}")
                elif column_type == "asiento":
                    row.append(
                        f'"{random.randint(1, 30)}{random.choice(["A", "B", "C", "D", "E", "F"])}"'
                    )  # Asientos aleatorios
                elif column_type == "dia":
                    row.append(random.randint(1, 31))  # Días entre 1 y 31
                elif column_type == "mes":
                    row.append(random.randint(1, 12))  # Meses entre 1 y 12
                elif column_type == "anio":
                    row.append(random.randint(2023, 2025))  # Años entre 2024 y 2025
                elif column_type == "aeropuerto":
                    row.append(
                        f'"{random.choice(["Buenos Aires", "Ministro Pistarini", "Cordoba", "Rosario"])}"'
                    )  # Aeropuertos aleatorios
                elif column_type == "id":
                    row.append(i)

            f.write(f"    {', '.join(map(str, row))}\n")

        f.write("}\n\n")
