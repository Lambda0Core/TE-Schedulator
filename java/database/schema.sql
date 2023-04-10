BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS office;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE title (
	 title_id SERIAL,
	 title_name varchar(50) NOT NULL,  
	
	CONSTRAINT PK_title PRIMARY KEY (title_id)
);


CREATE TABLE office (
	office_id SERIAL,
    office_address varchar(100) NOT NULL,
    office_city_name varchar(50) NOT NULL,
    office_state_acronym varchar(2) NOT NULL,  	
	office_phone_number varchar(20) NOT NULL,
    office_open_time varchar(50) NOT NULL,
    office_close_time varchar(50) NOT NULL,
	CONSTRAINT PK_office PRIMARY KEY (office_id)
);


CREATE TABLE patient (
	 patient_id SERIAL,
	 first_name varchar(100) NOT NULL,
	 last_name varchar(100) NOT NULL,
	 title_id SERIAL, 
	 user_id SERIAL
	
	CONSTRAINT PK_patient PRIMARY KEY (patient_id),
	CONSTRAINT fk_title_id FOREIGN KEY (title_id) REFERENCES title(title_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO patient (patient_id, first_name, last_name, title_id, user_id)
VALUES (2000, 'Greg', 'Westendorf', 0, 0)

CREATE TABLE provider (
      title_id int not null,
      office_id int not null,
	  first_name varchar(100) NOT NULL,
	  last_name varchar(100) NOT NULL,
	  title_name varchar(50) NOT NULL, 
	  date_availibility date NOT NULL,
	  provider_id SERIAL

      
      CONSTRAINT fk_title_id FOREIGN KEY (title_id) REFERENCES title(title_id),
      CONSTRAINT fk_office_id FOREIGN KEY (office_id) REFERENCES office(office_id),
	  CONSTRAINT fk_title_id FOREIGN KEY (title_id) REFERENCES title(title_id),
	  CONSTRAINT fk_provider_id FOREIGN KEY (provider_id) REFERENCES provider(office_id)        
);

CREATE TABLE review (
	 review_id SERIAL,
	 review_title varchar(50) NOT NULL, 
	 review_desc varchar(200) NOT NULL, 
     user_id SERIAL,
	 provider_id SERIAL

	CONSTRAINT PK_patient PRIMARY KEY (review_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id)    
);


CREATE TABLE appointment (
	 apt_id SERIAL,
	 apt_name varchar(50) NOT NULL, 
	 apt_status varchar(50) NOT NULL, 
	 apt_agenda varchar(200) NOT NULL, 
	 apt_date date NOT NULL,
     user_id SERIAL,
	 provider_id SERIAL

	CONSTRAINT PK_appointment PRIMARY KEY (apt_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id)    
);

COMMIT TRANSACTION;
