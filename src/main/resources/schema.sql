CREATE TABLE IF NOT EXISTS DEFEITOS(
	idDefeito INT AUTO_INCREMENT PRIMARY KEY,
	nomeDefeito VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS PECAS(
	idPeca INT AUTO_INCREMENT PRIMARY KEY,
	nomePeca VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS VEICULOS(
	idVeiculo INT AUTO_INCREMENT PRIMARY KEY,
	tipoVeiculo VARCHAR(45) NOT NULL,
	data TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS POSSIVEIS_DEFEITOS_PECA(
	idPossivelDefeitoPeca INT AUTO_INCREMENT PRIMARY KEY,
	fkIdDefeito INT NOT NULL,
	fkIdPeca INT NOT NULL,
	FOREIGN KEY (fkIdDefeito) REFERENCES DEFEITOS(idDefeito),
	FOREIGN KEY (fkIdPeca) REFERENCES PECAS(idPeca)
);

CREATE TABLE IF NOT EXISTS POSSIVEIS_PECAS_VEICULO(
	idPossivelPecaVeiculo INT AUTO_INCREMENT PRIMARY KEY,
	fkIdVeiculo INT NOT NULL,
	fkIdPossivelDefeitoPeca INT NOT NULL,
	FOREIGN KEY (fkIdVeiculo) REFERENCES VEICULOS(idVeiculo),
	FOREIGN KEY (fkIdPossivelDefeitoPeca) REFERENCES POSSIVEIS_DEFEITOS_PECA(idPossivelDefeitoPeca)
);

CREATE TABLE IF NOT EXISTS REGISTROS(
	idRegistro INT AUTO_INCREMENT PRIMARY KEY,
	fkIdPeca INT NOT NULL,
	fkIdDefeito INT NOT NULL,
	fkIdVeiculo INT NOT NULL,
	data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (fkIdVeiculo) REFERENCES VEICULOS(idVeiculo),
	FOREIGN KEY (fkIdDefeito) REFERENCES DEFEITOS(idDefeito),
	FOREIGN KEY (fkIdPeca) REFERENCES PECAS(idPeca)
);

INSERT INTO DEFEITOS (nomeDefeito) VALUES
('Ferrugem'),
('Quebrado'),
('Queimado'),
('Furo'),
('Falta componente'),
('Amassado');

INSERT INTO PECAS (nomePeca) VALUES
('Pneu'),
('Porta'),
('Lanterna'),
('Motor'),
('Mangueira'),
('Asa'),
('Casco'),
('Painel');

INSERT INTO VEICULOS (tipoVeiculo) VALUES
('CARRO'),
('MOTO'),
('BARCO'),
('NAVIO'),
('HELICOPTERO'),
('AVIÃO');

INSERT INTO POSSIVEIS_DEFEITOS_PECA(fkIdPeca, fkIdDefeito) VALUES
(1, 4),
(1, 5),
(2, 1),
(2, 2),
(2, 6),
(3, 2),
(3, 3),
(4, 1),
(4, 5),
(5, 1),
(5, 2),
(6, 1),
(6, 2),
(6, 6),
(7, 2),
(7, 4),
(7, 5),
(7, 6),
(8, 2),
(8, 3),
(8, 5);

INSERT INTO POSSIVEIS_PECAS_VEICULO(fkIdVeiculo, fkIdPossivelDefeitoPeca) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 19),
(1, 20),
(1, 21),
(2, 1),
(2, 2),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 11),
(2, 19),
(2, 20),
(2, 21);

INSERT INTO REGISTROS(fkIdVeiculo, fkIdPeca, fkIdDefeito, data) VALUES
(1, 1, 1, '2020-08-20 12:20:22'),
(1, 2, 1, '2020-07-15 16:40:12'),
(1, 2, 2, '2010-10-20 12:20:22'),
(1, 3, 2, '2018-12-05 18:33:00'),
(1, 4, 1, '2020-07-02 10:40:59'),
(1, 4, 1, '2020-08-20 18:05:33'),
(1, 1, 1, '2020-08-20 22:00:01'),
(1, 2, 1, '2020-08-20 22:30:54'),
(2, 2, 1, '2020-08-20 23:40:21'),
(1, 1, 1, '2015-10-20 12:20:22'),
(1, 3, 1, '2014-08-20 12:20:22');
 
