CREATE DATABASE y_cloud;
USE y_cloud;

DROP TABLE IF EXISTS p_client;


CREATE TABLE p_client(
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL ,
                         surname VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         password VARCHAR(100) NOT NULL
);

CREATE TABLE y_service (

    id INT PRIMARY KEY AUTO_INCREMENT,
    service_name VARCHAR(50),
    price INT
);


INSERT INTO p_client(name, surname, email, password) VALUES
('Aniela','Duke','anielaDUk@gmail','$2y$12$LYAKoxEaZL3R4kVwC00Gc.NBZxy0Jbu23w8EPNsuPiaNoeFM4Bczq'),
('Kelan','Kaur','kelanKAuR@gmail','$2y$12$V9S2TOgT0AmzHTSucBjt6.MXhYWOKtYersH7BM6UlImfnCo1uo4xO'),
('Shola','Norman','sholaNorm@gmail','$2y$12$Vk02Hmo2uMqEypPP5KkcFe66ys.AF4ndF18GOgB/VPJDiJVbq3JuK'),
('Harlan','Gilliam','harlanGil@gmail','$2y$12$qIk4.YROoOgrUT0Hllv0BupH5Wzu7DpWNK3HvxqZJerMH/ln30zTu'),
('Arif','Rooney','arifRonnf@gmail','$2y$12$XmlCCEsg0BHhZMqP479S5O53ty4nJRO/BN99SAh3h9w0QKFGNkeHa');

