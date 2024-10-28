create view appointments.doctors_per_patients AS
(
select p.patient_id, d.doctor_id
from patient p
         inner join doctor d on p.patient_city = d.doctor_city);