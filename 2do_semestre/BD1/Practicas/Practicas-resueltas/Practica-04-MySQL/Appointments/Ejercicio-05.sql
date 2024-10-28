CREATE TABLE appointments_per_patient (
    idApP integer(11) primary key auto_increment,
    id_patient integer(11),
    count_appointments integer(11),
    last_update datetime,
    user varchar(32),
    constraint foreign key (id_patient) references patient(patient_id)
);