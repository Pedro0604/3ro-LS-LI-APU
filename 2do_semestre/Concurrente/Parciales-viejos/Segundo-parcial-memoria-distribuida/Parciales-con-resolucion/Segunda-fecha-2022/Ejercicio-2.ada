PROCEDURE ejercicio_2 IS
TASK Central IS
	ENTRY enviarStock(cantidad: IN integer);
	ENTRY recibirModelo(m: OUT modelo);
END Central;

TASK TYPE Sede;

TASK BODY Central IS
	modelo: Modelo;
	stockTotal: integer;
BEGIN
	LOOP
		modelo:= getModelo();
		stockTotal:= 0;
		FOR [_:= 1..S] DO
			ACCEPT recibirModelo(m: OUT modelo) DO
				m:= modelo;
			END recibirModelo;
		END FOR;
		FOR [_:= 1..S] DO
			ACCEPT enviarStock(cantidad: IN integer) DO
				stockTotal:= stockTotal + cantidad;
			END enviarStock;
		END FOR;
		informarTotal(stockTotal);
	END LOOP;
END Central;

TASK BODY Sede IS
	modelo: Modelo;
	cantidad: integer;
BEGIN
	LOOP
		Central.recibirModelo(modelo);
		DevolverStock(modelo, cantidad);
		Central.enviarStock(cantidad);
	END LOOP;
END Sede;

sedes: ARRAY [1..S] OF Sede;

BEGIN
	NULL;
END ejercicio_2;