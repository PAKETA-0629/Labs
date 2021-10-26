
INSERT INTO p_master(name, surname, email, password) VALUES
('Zina', 'Miller', 'zinaM@gmail', '$2y$12$.XDDEGEXjca7xACdX7.IQeaqa9o2jqvBXok.bjVJinXyqLtbk1Ewi'),
('Brianna', 'Solis', 'briannaSO@gmail', '$2y$12$Dij890q8mXlSzlAZQgGHNeWtyHpEiNVWceIMeLcc7Ys0w6TzSjuHu'),
('Nina', 'Garza', 'ninaGAR@gmail', '$2y$12$/sy9XOUQRnkZhr0vpHIPM.5JvykkMwpkds1LwZ0UlDup7mQzw/nnK'),
('Charlotte', 'Ganzales', 'charlotteGANZ@gmail', '$2y$12$2cwP1ST3VLNXmr9L4i6gKOT1mtBy94z8Bo/0Bmz/3.c/nLOnbWnra'),
('Layla', 'Baker', 'laylaBAK@gmail', '$2y$12$g47iii7Ko7TGegXw6zb.9eQcIlc5Td4oo8r2rKj8BP1kWeQ9x38Wu');

INSERT INTO p_client(name, surname, email, password) VALUES
('Aniela','Duke','anielaDUk@gmail','$2y$12$LYAKoxEaZL3R4kVwC00Gc.NBZxy0Jbu23w8EPNsuPiaNoeFM4Bczq'),
('Kelan','Kaur','kelanKAuR@gmail','$2y$12$V9S2TOgT0AmzHTSucBjt6.MXhYWOKtYersH7BM6UlImfnCo1uo4xO'),
('Shola','Norman','sholaNorm@gmail','$2y$12$Vk02Hmo2uMqEypPP5KkcFe66ys.AF4ndF18GOgB/VPJDiJVbq3JuK'),
('Harlan','Gilliam','harlanGil@gmail','$2y$12$qIk4.YROoOgrUT0Hllv0BupH5Wzu7DpWNK3HvxqZJerMH/ln30zTu'),
('Arif','Rooney','arifRonnf@gmail','$2y$12$XmlCCEsg0BHhZMqP479S5O53ty4nJRO/BN99SAh3h9w0QKFGNkeHa');

INSERT INTO p_pet(name, client_id) VALUES ('dog1',1),
                                              ('dog2',2),
                                              ('dog3',3),
                                              ('dog4',4),
                                              ('dog5',5);




INSERT INTO p_treatment(name, price) VALUES
('Ear cleaning',200),
('tartar removal',400),
('Skin treatment',300),
('Washing',200),
('Haircut',300);


INSERT INTO  p_master_treatment (master_id,treatment_id) VALUES
(1,2),(1,3),(1,4),(1,5),(2,1),(2,3),(2,2),(2,4),(3,2),(3,3),(3,5),
(4,1),(4,2),(4,3),(4,4),(5,1),(5,2);


INSERT INTO p_review(review_content,date_time,client_id) VALUES
('Love my new pet haircut. Thank you','2021-02-21 13:00',1),
('Had a great time everyone nice and friendly and love my new pet hair do','2021-02-21 15:00',2),
('First class treatments today with Zina Miller! From top to toe literally
- pedicure with gel polish, delighted with the results! Felt very safe and applaud the professionalism of all staff Beauty.','2021-02-21 19:00',3),
('Love my hair. Charlotte made a great job as usual.','2021-02-21 20:00',4),
('Absolutely in love with my new colour done by Layla. Brilliant treatment, as always!','2021-02-21 22:00',5);

