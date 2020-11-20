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

CREATE TABLE IF NOT EXISTS PECA_DEFEITOS(
	fkIdDefeito INT NOT NULL,
	fkIdPeca INT NOT NULL,
	data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (fkIdDefeito) REFERENCES DEFEITOS(idDefeito),
	FOREIGN KEY (fkIdPeca) REFERENCES PECAS(idPeca)
);

CREATE TABLE IF NOT EXISTS VEICULO_PECAS_DEFEITOS(
	idRegistro INT AUTO_INCREMENT PRIMARY KEY,
	fkIdVeiculo INT NOT NULL,
	fkIdPeca INT NOT NULL,
	fkIdDefeito INT NOT NULL,
	data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (fkIdVeiculo) REFERENCES VEICULOS(idVeiculo),
	FOREIGN KEY (fkIdPeca) REFERENCES PECAS(idPeca),
	FOREIGN KEY (fkIdDefeito) REFERENCES DEFEITOS(idDefeito)
);

CREATE TABLE IF NOT EXISTS REGISTROS(
	idRegistro INT AUTO_INCREMENT PRIMARY KEY,
	fkIdVeiculo INT NOT NULL,
	fkIdPeca INT NOT NULL,
	fkIdDefeito INT NOT NULL,
	data TIMESTAMP NOT NULL,
	FOREIGN KEY (fkIdVeiculo) REFERENCES VEICULOS(idVeiculo),
	FOREIGN KEY (fkIdPeca) REFERENCES PECAS(idPeca),
	FOREIGN KEY (fkIdDefeito) REFERENCES DEFEITOS(idDefeito)
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

INSERT INTO PECA_DEFEITOS(fkIdPeca, fkIdDefeito) VALUES
(1, 4),
(1, 5),
(2, 1),
(2, 6),
(3, 2),
(3, 3),
(4, 1);
 
INSERT INTO VEICULO_PECAS_DEFEITOS(fkIdVeiculo, fkIdPeca, fkIdDefeito) VALUES
(1, 1, 1),
(1, 1, 2),
(1, 2, 2),
(1, 3, 3),
(1, 4, 4),
(1, 5, 5),
(2, 1, 1),
(2, 2, 2),
(2, 3, 1),
(2, 4, 1),
(2, 5, 1);

INSERT INTO REGISTROS(fkIdVeiculo, fkIdPeca, fkIdDefeito, data) VALUES
(1, 1, 1, '2020-08-20 12:20:22'),
(1, 1, 2, '2020-07-15 16:40:12'),
(1, 2, 2, '2010-10-20 12:20:22'),
(1, 3, 3, '2018-12-05 18:33:00'),
(1, 4, 4, '2020-07-02 10:40:59'),
(1, 5, 5, '2020-08-20 18:05:33'),
(2, 1, 1, '2020-08-20 22:00:01'),
(2, 2, 2, '2020-08-20 22:30:54'),
(2, 3, 1, '2020-08-20 23:40:21'),
(2, 4, 1, '2015-10-20 12:20:22'),
(2, 5, 1, '2014-08-20 12:20:22');
 
