BEGIN TRANSACTION;

INSERT INTO users (username, password_hash, role) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username, password_hash, role) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3001, 'UserTestGreg','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW97pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3002, 'UserTestEmily','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW98pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3003, 'UserTestBryce','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW98pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3004, 'UserTestLazlo','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW97pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3005, 'UserTestAndy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW98pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3006, 'UserTestMax','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW98pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (user_id, username, password_hash, role) 
VALUES (3007, 'UserTestAlice','$2a$08$UkVvwpULis18S19S5pZFn.YHzPZt3oaqHZnDwqbCW97pft6uFtkXKDC','ROLE_USER');


INSERT INTO title (title_id, title_name)
VALUES (0, 'Patient'), (1, 'Doctor'), (2, 'Nurse');

INSERT INTO office (office_id, office_name, office_address, office_city_name, office_state_acronym, office_phone_number, office_open_time, office_close_time)
VALUES (1000, 'West Medical','1234 HELPSTREET', 'Burrito', 'OH', '440-469-1337', '9:00 AM', '6:00 PM'),
       (1001, 'North Medical','1337 STREET', 'Vermon', 'PA', '340-400-4269', '9:00 AM', '6:00 PM'),
       (1002, 'South Medical','14m3 STREET', 'Vermon', 'PA', '340-500-4269', '6:00 PM', '9:00 AM');

-- For Providers with Offices!
INSERT INTO details (details_id, user_id, first_name, last_name, is_provider, title_id, office_id)
VALUES (4000, 3002, 'Emily', 'LeFebvre', TRUE, 1, 1000),
       (4001, 3005, 'Andy', 'Jocke', TRUE, 1, 1001),
       (4002, 3003, 'Bryce', 'Huhtala', TRUE, 1, 1001),
       (4003, 3006, 'Max', 'Shatskiy', TRUE, 1, 1002),
       (2001, 3007, 'Alice', 'Margatroid', TRUE, 1, 1002);

       INSERT INTO details (details_id, user_id, first_name, last_name, is_provider, title_id)
VALUES (2000, 3001, 'Greg', 'Westendorf', FALSE, 0),
       (2002, 3004, 'Lazlo', 'Westendorf', FALSE, 0);
       
INSERT INTO user_availability (details_id, available_from, available_to)
VALUES (4000, '4/14/2023', '5/14/2023'),
       (4001, '4/14/2023', '5/14/2023'),
       (4002, '4/14/2023', '5/14/2023'),
       (4003, '4/14/2023', '5/14/2023'),
       (2001, '4/14/2023', '5/14/2023');


INSERT INTO office_users (details_id, office_id) 
VALUES (4000, 1000),
       (4001, 1001),
       (4002, 1001),
       (4003, 1002),
       (2001, 1002);

INSERT INTO review (review_id, review_title, review_desc, user_id, details_id)
VALUES (8000, 'Dr. Emily Strikes Out!', 'Dr. Emily is horrible, and left me with broken ankles!', 3001, 4000),
       (8001, 'Dr. Andy has another victim', 'Poor Lazlo... he was the finest mind of our generation!', 3004, 4001),
       (8002, 'Dr. Max should be condemned!', '-his skeleton was missing, and he was never heard from again!! ..Anyways, thats how I lost my medical license...', 3001, 4003),
       (8003, 'Dr. Bryce did a very good job... as a butcher!', 'I went in with a sprained ankle, and left without half my limbs!', 3001, 4003);

INSERT INTO response (response_id, review_id, response_title, response_desc, user_id, details_id)
VALUES (9000, 8000, 'I rather liked Emily :L', 'Shes not so bad!', 3001, 2002),
       (9001, 8001, 'andy wasnt so bad', 'he complimented my dog renardo, hes a basset hound and hes so cute c:', 3004, 2002);

              
       
       

INSERT INTO appointment (apt_id, apt_name, apt_status, apt_agenda, apt_date, user_id, details_id)
VALUES (5001, 'Check-Up', 'Ongoing', 'Just a quick check up!', '2023-05-10', 3001, 4000),
       (5002, 'Amputation Session', 'Ongoing', 'We needed a test subject for our new tools, and you have been late on your medical bills...', '2023-06-10', 3001, 4000),
       (5003, 'Drug Perscription', 'Ongoing', 'We will need to provide experimental new painkillers after your procedure.', '2023-07-10', 3001, 4000);


COMMIT TRANSACTION;
