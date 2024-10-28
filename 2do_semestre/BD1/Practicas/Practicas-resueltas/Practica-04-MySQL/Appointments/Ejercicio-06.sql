delimiter //
create procedure Ejercicio06()
begin
    DECLARE done INT DEFAULT FALSE;
    DECLARE patient_id INT;
    DECLARE appointment_count INT;
    DECLARE last_update DATETIME;

    DECLARE cursor_appointments CURSOR FOR SELECT patient.patient_id, count(patient.patient_id) as cant
                                           from patient
                                                    inner join appointment on patient.patient_id = appointment.patient_id
                                           group by patient.patient_id;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    start transaction;
    SET last_update = now();
    OPEN cursor_appointments;
    read_loop:
    LOOP
        FETCH cursor_appointments INTO patient_id, appointment_count;
        IF done THEN
            LEAVE read_loop;
        END IF;
        INSERT INTO appointments_per_patient (id_patient, count_appointments, last_update, user)
        VALUES (patient_id, appointment_count, last_update, current_user());
    END LOOP;
    CLOSE cursor_appointments;
    COMMIT;
end //
delimiter ;