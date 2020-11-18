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
	nomeVeiculo VARCHAR(45) NOT NULL UNIQUE,
	data TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS PECA_DEFEITOS(
	fkIdDefeito INT NOT NULL,
	fkIdPeca INT NOT NULL,
	data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (fkIdDefeito) REFERENCES DEFEITOS(idDefeito),
	FOREIGN KEY (fkIdPeca) REFERENCES PECAS(idPeca)
);

CREATE TABLE IF NOT EXISTS VEICULO_PECAS(
	fkIdPeca INT NOT NULL,
	fkIdVeiculo INT NOT NULL,
	data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (fkIdPeca) REFERENCES PECAS(idPeca),
	FOREIGN KEY (fkIdVeiculo) REFERENCES VEICULOS(idVeiculo)
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

INSERT INTO VEICULOS (tipoVeiculo, nomeVeiculo) VALUES
('Carro', 'Fusca'),
('Carro', 'Corolla'),
('Moto', 'Harley Davidson'),
('Moto', 'Suzuki'),
('Barco', 'Argos'),
('Barco', 'Mariner'),
('Navio', 'Costa Cruzeiros'),
('Helicóptero', 'Eurocopter'),
('Avião', 'Boeing 787');

INSERT INTO PECA_DEFEITOS(fkIdPeca, fkIdDefeito) VALUES
(1, 4),
(1, 5),
(2, 1),
(2, 6),
(3, 2),
(3, 3),
(4, 1);

INSERT INTO VEICULO_PECAS(fkIdVeiculo, fkIdPeca) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);


