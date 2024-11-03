PROCEDURE ejercicio_2 IS
TASK TYPE Persona;

TASK Cajero IS
	ENTRY pagarSuperPrioridad(boletas: IN List<Boleta>, dinero: IN integer, vuelto: OUT integer, recibos: OUT List<Recibo>);
	ENTRY pagarPrioridad(boletas: IN List<Boleta>, dinero: IN integer, vuelto: OUT integer, recibos: OUT List<Recibo>);
	ENTRY pagar(boletas: IN List<Boleta>, dinero: IN integer, vuelto: OUT integer, recibos: OUT List<Recibo>);
END Cajero;

TASK BODY Cajero IS
BEGIN
	LOOP
		SELECT
			ACCEPT pagarSuperPrioridad(boletas: IN List<Boleta>, dinero: IN integer, vuelto: OUT integer, recibos: OUT List<Recibo>) DO
				procesarPago(boletas, dinero, vuelto, recibos);
			END pagarSuperPrioridad;
		OR
			WHEN (pagarSuperPrioridad'count == 0) -> ACCEPT pagarPrioridad(boletas: IN List<Boleta>, dinero: IN integer, vuelto: OUT integer, recibos: OUT List<Recibo>) DO
				procesarPago(boletas, dinero, vuelto, recibos);
			END pagarPrioridad;
		OR
			WHEN (pagarSuperPrioridad'count == 0 AND pagarPrioridad'count == 0) -> ACCEPT pagar(boletas: IN List<Boleta>, dinero: IN integer, vuelto: OUT integer, recibos: OUT List<Recibo>) DO
				procesarPago(boletas, dinero, vuelto, recibos);
			END pagar;
		END SELECT;
	END LOOP;
END Persona;

TASK BODY Persona IS
	boletas: List<Boleta>;
	recibos: List<Recibo>;
	dinero, vuelto: integer;
BEGIN
	boletas = getBoletas();

	IF (esAnciana() OR estaEmbarazada()) THEN
		Cajero.pagarSuperPrioridad(boletas, dinero, recibos, vuelto);
	ELSE IF (boletas.length()<5) THEN
		Cajero.pagarPrioridad(boletas, dinero, recibos, vuelto);
	ELSE
		Cajero.pagar(boletas, dinero, recibos, vuelto);
	END IF;
END Persona;

personas: array (1..P) of Persona;

BEGIN
	null;
END ejercicio_2;