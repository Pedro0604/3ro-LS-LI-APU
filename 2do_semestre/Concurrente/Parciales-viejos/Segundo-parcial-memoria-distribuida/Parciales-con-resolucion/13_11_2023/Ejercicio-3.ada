PROCEDURE ejercicio_3 IS
TASK Banco;

TASK TYPE API IS
	ENTRY consultarPrecio(precioCompra: OUT real, precioVenta: OUT real);
END API;

TASK BODY Banco IS
	precios: array [1..2][1..20] of real;
	precioCompra, precioVenta: real;
BEGIN
	LOOP
		FOR [i:= 1..20] DO
			SELECT
				API[i].consultarPrecio(precioCompra, precioVenta);
				precios[1][i]:= precioCompra;
				precios[2][i]:= precioVenta;
			OR DELAY 5*60
				precios[1][i]:= -1;
				precios[2][i]:= -1;
			END SELECT;
		END FOR;
		mostrar(precios);
	END LOOP;
END Banco;

TASK BODY API IS
BEGIN
	LOOP
		ACCEPT consultarPrecio(precioCompra: OUT real, precioVenta: OUT real) DO
			precioCompra:= getPrecioCompraActual();
			precioVenta:= getPrecioVentaActual();
		END consultarPrecio;
	END LOOP;
END API;

apis: array [1..20] of API;

BEGIN
	NULL;
END ejercicio_3;