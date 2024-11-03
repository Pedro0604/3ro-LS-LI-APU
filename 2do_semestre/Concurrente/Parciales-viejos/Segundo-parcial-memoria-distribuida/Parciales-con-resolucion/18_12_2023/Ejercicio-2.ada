PROCEDURE ejercicio_3 IS
TASK Central IS
	ENTRY enviarCantidadVentas(cantidad: IN integer);
END Central;

TASK TYPE Sucursal IS
	ENTRY consultar(id: IN integer);
END Sucursal;

TASK BODY Central IS
	idArticulo, totalVentas: integer;
BEGIN
	LOOP
		idArticulo:= generarArticulo();
		FOR [i:= 1..100] DO
			sucursales[i].consultar(idArticulo);
		END FOR;
		
		totalVentas:= 0;
		FOR [i:= 1..100] DO
			ACCEPT enviarCantidadVentas(cantidad: IN integer) DO
				totalVentas+= cantidad;
			END enviarCantidadVentas;
		END FOR;
	END LOOP;
END Central;

TASK BODY Sucursal IS
	cantidadVentas, idArticulo: integer;
BEGIN
	LOOP
		ACCEPT consultar(id: IN integer) DO
			idArticulo:= id;
		END consultar;
		
		cantidadVentas:= ObtenerVentas(idArticulo);
		
		Central.enviarCantidadVentas(cantidadVentas);
	END LOOP;
END Sucursal;

sucursales: ARRAY [1..100] OF Sucursal;

BEGIN
	NULL;
END ejercicio_3;
