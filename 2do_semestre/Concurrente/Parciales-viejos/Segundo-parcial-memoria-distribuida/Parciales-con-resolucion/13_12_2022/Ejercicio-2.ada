PROCEDURE ejercicio_2 IS
TASK DB IS
	ENTRY accesoEscritor();
	ENTRY accesoLector();
	ENTRY liberarEscritor();
	ENTRY liberarLector();
END DB;

TASK TYPE Escritor;

TASK TYPE Lector;

TASK BODY DB IS
	cantLectores:= 0, cantEscritores:= 0: integer;
BEGIN
	LOOP
		SELECT
			WHEN (accesoEscritor'count == 0 AND cantEscritores == 0) -> ACCEPT accesoLector();
			cantLectores ++;
		OR
			ACCEPT liberarLector();
			cantLectores --;
		OR
			WHEN (cantLectores == 0 AND cantEscritores == 0) -> ACCEPT accesoEscritor();
			cantEscritores ++;
		OR
			ACCEPT liberarEscritor();
			cantEscritores --;
		END SELECT;
	END LOOP;
END DB;

TASK BODY Escritor IS
	
BEGIN
	LOOP
		SELECT
			DB.accesoEscritor();
			escribirDB();
			DB.liberarEscritor();
		OR ELSE
			delay(60);
		END SELECT;
	END LOOP;
END Escritor;

TASK BODY Lector IS
	
BEGIN
	LOOP
		SELECT
			DB.accesoLector();
			leerDB();
			DB.liberarLector();
		OR DELAY 2*60
			delay(5*60);
		END SELECT;
	END LOOP;
END Lector;

lectores: array [1..L] of Lector;
escritores: array [1..E] of Escritor;

BEGIN
	NULL;
END ejercicio_2;