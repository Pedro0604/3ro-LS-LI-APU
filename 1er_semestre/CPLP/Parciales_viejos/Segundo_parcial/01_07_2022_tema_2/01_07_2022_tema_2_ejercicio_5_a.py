a = [0, 1, 2, 3, 4]
def imprime_pos(y):
    print(("Resultado"), a[y]/a[y]-4)

for y in range(6):
    try:
        imprime_pos(y)
    except IndexError:
        print("Ocurrió un error en el índice")
    except ZeroDivisionError:
        print("Ocurrió una divisón por cero")
    else:
        print("Se pudo acceder correctamente")
    finally:
        print("Vuelve a probar")