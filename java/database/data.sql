BEGIN TRANSACTION;

INSERT INTO users (username, password_hash, role) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username, password_hash, role) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO title (title_id, title)
VALUES (0, 'Patient'), (1, 'Doctor'), (2, 'Nurse');

INSERT INTO office (office_id, office_address, office_city_name, office_state_acronym, office_phone_number, office_open_time, office_close_time)
VALUES (1000, '1234 HELPSTREET', 'Burrito', 'OH', '440-469-1337', '9:00 AM', '6:00 PM'),
       (1001, '1337 STREET', 'Vermon', 'PA', '340-400-4269', '9:00 AM', '6:00 PM'),
       (1001, '14m3 STREET', 'Vermon', 'PA', '340-500-4269', '6:00 PM', '9:00 AM');

COMMIT TRANSACTION;
