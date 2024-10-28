CREATE TRIGGER trigger_ejercicio_07
    AFTER INSERT
    ON appointments.appointment
    FOR EACH ROW
BEGIN
    UPDATE appointments_per_patient
    SET count_appointments = count_appointments + 1,
        last_update        = NOW(),
        user               = CURRENT_USER()
    WHERE id_patient = NEW.patient_id;

    IF ROW_COUNT() = 0 THEN
        INSERT INTO appointments_per_patient (id_patient, count_appointments, last_update, user)
        VALUES (NEW.patient_id, 1, NOW(), CURRENT_USER());
    END IF;
end;
