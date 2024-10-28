SELECT p.patient_id
FROM patient p
         INNER JOIN appointments.appointment a on p.patient_id = a.patient_id
         INNER JOIN appointments.medical_review mr
                    on a.patient_id = mr.patient_id and a.appointment_date = mr.appointment_date
         INNER JOIN appointments.doctor d on mr.doctor_id = d.doctor_id and p.patient_city = d.doctor_city
GROUP BY p.patient_id
HAVING count(distinct (d.doctor_id)) = (SELECT count(distinct (d2.doctor_id))
                        FROM doctors_per_patients d2
                        WHERE d2.patient_id = p.patient_id);

