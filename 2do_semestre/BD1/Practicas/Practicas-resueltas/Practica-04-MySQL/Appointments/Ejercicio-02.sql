SELECT *
FROM patient p
WHERE p.patient_id NOT IN (SELECT distinct(p.patient_id)
                   FROM patient p
                            inner join appointments.appointment a on p.patient_id = a.patient_id
                   WHERE a.contact_phone = p.secondary_phone);