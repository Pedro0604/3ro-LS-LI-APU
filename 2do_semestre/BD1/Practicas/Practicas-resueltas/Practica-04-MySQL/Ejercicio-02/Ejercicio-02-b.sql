SELECT e.nombreCompleto
FROM ESTUDIANTE as e
WHERE e.nacionalidad = 'Argentina'
    AND codigoDeCarrera <> 'LI07'