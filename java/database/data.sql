BEGIN TRANSACTION;

INSERT INTO users (username, password_hash, role) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username, password_hash, role) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3001, 'UserTestGreg','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW97pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3002, 'UserTestEmily','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW98pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO title (title_id, title_name)
VALUES (0, 'Patient'), (1, 'Doctor'), (2, 'Nurse');

INSERT INTO office (office_id, office_address, office_city_name, office_state_acronym, office_phone_number, office_open_time, office_close_time)
VALUES (1000, '1234 HELPSTREET', 'Burrito', 'OH', '440-469-1337', '9:00 AM', '6:00 PM'),
       (1001, '1337 STREET', 'Vermon', 'PA', '340-400-4269', '9:00 AM', '6:00 PM'),
       (1003, '14m3 STREET', 'Vermon', 'PA', '340-500-4269', '6:00 PM', '9:00 AM');

INSERT INTO patient (patient_id, first_name, last_name, title_id, user_id)
VALUES (2000, 'Greg', 'Westendorf', 0, 3001);

INSERT INTO provider (provider_id, office_id, user_id, first_name, last_name, title_id, date_availibility)
VALUES (4000, 1003, 3002, 'Emily', 'LeFebvre', 1, '2000-10-11');

INSERT INTO review (review_id, review_title, review_desc, user_id, provider_id)
VALUES (8000, 'Dr. Emily Strikes Out!', 'Dr. Emily is horrible, and left me with broken ankles!', 3001, 4000),
       (8000, 'Dr. Emily has another victim', 'Poor Lazlo... he was the finest mind of our generation!', 3001, 4000),
       (8000, 'Dr. Emily Strikes Out!', 'Dr. Emily is horrible, and left me with broken ankles!', 3001, 4000);
       

INSERT INTO appointment (apt_id, apt_name, apt_status, apt_agenda, apt_date, user_id, provider_id)
VALUES (5001, 'Check-Up', 'Ongoing', 'Just a quick check up!', '2023-05-10', 3001, 4000);

COMMIT TRANSACTION;
