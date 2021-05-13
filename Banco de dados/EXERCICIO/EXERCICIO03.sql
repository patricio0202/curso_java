CREATE TABLE UZUARIOS(
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20),
    sobrenome VARCHAR(50),
    idade INT
);

RENAME TABLE UZUARIOS TO USUARIOS;

ALTER TABLE USUARIOS ADD EMAIL VARCHAR (40);

ALTER TABLE USUARIOS DROP COLUMN EMAIL;

ALTER TABLE USUARIOS DROP COLUMN SOBRENOME;

SELECT * FROM USUARIOS;

INSERT INTO USUARIOS VALUES
(NULL, 'Adailton', 22, 'adailton.maas@yahoo.com.br'),
(NULL, 'Andressa', 36, 'dessa.simas@uol.com.br'),
(NULL, 'Mayra', 24, 'mayra.antunes@gmail.com'),
(NULL, 'Cristiane', 14, 'criss.maya@gmail.com'),
(NULL, 'Leonardo', 15, 'leo.kopff@terra.com.br'),
(NULL, 'Carina', 27, 'carina.almeida@gmail.com'),
(NULL, 'Clóvis', 29, 'clovis.simao@hotmail.com'),
(NULL, 'Gabriela', 23, 'gabriela.braga@live.com'),
(NULL, 'Cibele', NULL, 'cibele.lins@uol.com.br');

SELECT * FROM USUARIOS