PROCEDURE ejercicio_2 IS
TASK Empleado IS
	ENTRY pagarPremiun(pago: IN Pago, comprobante: OUT Comprobante);
	ENTRY pagarRegular(pago: IN Pago, comprobante: OUT Comprobante);
END Empleado;

TASK TYPE Regular;
TASK TYPE Premiun;

TASK BODY Empleado IS
BEGIN
	LOOP
		SELECT
			ACCEPT pagarPremiun(pago: IN Pago, comprobante: OUT Comprobante) DO
				procesarPago(pago, comprobante);
			END pagarPremiun;
		OR
			WHEN (pagarPremiun'count == 0) ACCEPT pagarRegular(pago: IN Pago, comprobante: OUT Comprobante) DO
				procesarPago(pago, comprobante);
			END pagarRegular;
		END SELECT;
	END LOOP;
END Empleado;

TASK BODY Regular IS
	pago: Pago;
	comprobante: comprobante;
BEGIN
	SELECT
		pagarRegular(pago, comprobante);
	OR DELAY 30*60
		NULL;
	END SELECT;
END Regular;


TASK BODY Premiun IS
	pago: Pago;
	comprobante: comprobante;
BEGIN
	pagarPremiun(pago, comprobante);
END Premiun;

regulares: array [1..R] of Regular;
premiums: array [1..P] of Premium;

BEGIN
	NULL;
END ejercicio_2;