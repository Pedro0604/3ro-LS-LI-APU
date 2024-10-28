DELIMITER //
CREATE PROCEDURE insert_complete_appointment(IN patient_id INT, IN doctor_id INT, IN appointment_duration INT,
                                             IN contact_phone VARCHAR(255), IN appointment_address VARCHAR(255),
                                             IN medication_name VARCHAR(255))
BEGIN
    DECLARE appointment_date DATETIME;

    SET appointment_date = NOW();

    START TRANSACTION;
    INSERT INTO appointments.appointment (appointments.appointment.patient_id,
                                          appointments.appointment.appointment_date,
                                          appointments.appointment.appointment_duration,
                                          appointments.appointment.contact_phone, appointments.appointment.observations,
                                          appointments.appointment.payment_card)
    VALUES (patient_id, appointment_date, appointment_duration,
            contact_phone, NULL,
            NULL);

    INSERT INTO appointments.prescribed_medication (appointments.prescribed_medication.patient_id,
                                                    appointments.prescribed_medication.appointment_date,
                                                    appointments.prescribed_medication.medication_name)
    VALUES (patient_id, appointment_date, medication_name);

    INSERT INTO appointments.medical_review (appointments.medical_review.patient_id,
                                             appointments.medical_review.appointment_date,
                                             appointments.medical_review.doctor_id)
    VALUES (patient_id, appointment_date, doctor_id);
    COMMIT;
end//
DELIMITER ;