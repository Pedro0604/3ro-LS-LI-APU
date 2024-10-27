SELECT a.patente,
    a.id_chofer
FROM AUTO a
    INNER JOIN CHOFER c ON a.id_chofer = c.id_chofer
WHERE c.fecha_licencia_hasta = '2024-01-01';
-- Esta query de abajo corre en la calculadora de RelaX que usé en la práctica 3
SELECT a.patente,
    a.id_chofer
FROM AUTO as a
    INNER JOIN CHOFER as c ON a.id_chofer = c.id_chofer
WHERE c.fecha_licencia_hasta_dia = 1
    AND c.fecha_licencia_hasta_mes = 1
    AND c.fecha_licencia_hasta_anio = 2024;