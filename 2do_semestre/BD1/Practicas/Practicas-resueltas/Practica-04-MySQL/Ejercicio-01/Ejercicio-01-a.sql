SELECT d.dni,
    d.nombre,
    d.telefono
FROM DUENIO d
WHERE d.id_duenio NOT IN (
        SELECT d.id_duenio
        FROM DUENIO d
            INNER JOIN CHOFER c ON d.dni = c.dni
    );
-- Esta query de abajo corre en la calculadora de RelaX que usé en la práctica 3
SELECT d.dni,
    d.nombre,
    d.telefono
FROM DUENIO as d
EXCEPT
SELECT d.dni,
    d.nombre,
    d.telefono
FROM DUENIO AS d
    INNER JOIN CHOFER as c ON d.dni = c.dni