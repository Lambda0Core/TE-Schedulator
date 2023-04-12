BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, title, office, patient, provider, review, appointment;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS title (
	 title_id SERIAL,
	 title_name varchar(50) NOT NULL,  
	
	CONSTRAINT PK_title PRIMARY KEY (title_id)
);


CREATE TABLE IF NOT EXISTS office (
	office_id SERIAL,
	office_name varchar(100) NOT NULL,
    office_address varchar(100) NOT NULL,
    office_city_name varchar(50) NOT NULL,
    office_state_acronym varchar(2) NOT NULL,  	
	office_phone_number varchar(20) NOT NULL,
    office_open_time varchar(50) NOT NULL,
    office_close_time varchar(50) NOT NULL,
	CONSTRAINT PK_office PRIMARY KEY (office_id)
);


CREATE TABLE IF NOT EXISTS patient (
	 patient_id SERIAL,
	 first_name varchar(100) NOT NULL,
	 last_name varchar(100) NOT NULL,
	 title_id SERIAL, 
	 user_id SERIAL,
	
	CONSTRAINT fk_title FOREIGN KEY (title_id) REFERENCES title(title_id),
	CONSTRAINT fk_patient_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT PK_patient PRIMARY KEY (patient_id)
);

CREATE TABLE provider (
	  provider_id SERIAL,
      office_id int not null,
	  user_id int not null,
	  first_name varchar(100) NOT NULL,
	  last_name varchar(100) NOT NULL,
	  title_id SERIAL, 
	  date_availability date NOT NULL,

	  CONSTRAINT PK_provider PRIMARY KEY (provider_id),      
      CONSTRAINT fk_office_id FOREIGN KEY (office_id) REFERENCES office(office_id),
	  CONSTRAINT fk_provider_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	  CONSTRAINT fk_title_id FOREIGN KEY (title_id) REFERENCES title(title_id)   
);


CREATE TABLE IF NOT EXISTS review (
	 review_id SERIAL,
	 review_title varchar(50) NOT NULL, 
	 review_desc varchar(200) NOT NULL, 
     user_id SERIAL,
	 provider_id SERIAL,

	CONSTRAINT PK_review PRIMARY KEY (review_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id)    
);


CREATE TABLE IF NOT EXISTS appointment (
	 apt_id SERIAL,
	 apt_name varchar(50) NOT NULL, 
	 apt_status varchar(50) NOT NULL, 
	 apt_agenda varchar(200) NOT NULL, 
	 apt_date date NOT NULL,
     user_id SERIAL,
	 provider_id SERIAL,

	CONSTRAINT PK_appointment PRIMARY KEY (apt_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id)    
);

COMMIT TRANSACTION;
