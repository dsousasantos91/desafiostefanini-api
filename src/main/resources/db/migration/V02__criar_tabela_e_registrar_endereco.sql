CREATE TABLE endereco (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	cep VARCHAR(8) NOT NULL,
	logradouro VARCHAR(100) NOT NULL,
	numero INT NOT NULL,
	complemento VARCHAR(100),
	bairro VARCHAR(50),
	cidade VARCHAR(50) NOT NULL,
	uf VARCHAR(2) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	pessoa_id BIGINT(20),
	FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('72855307', 'Quadra 7', 10, 'Rua 6', 'Parque Residencial Faro', 'Luziânia', 'GO', 'RESIDENCIAL', 1);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('72872520', 'Conjunto Residencial 1 Condomínio 2', 101, 'Bloco B', 'Parque das Cachoeiras', 'Valparaíso de Goiás', 'GO', 'ENTREGA', 1);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('71640200', 'SHIS QI 16', 4, '', 'Setor de Habitações Individuais Sul', 'Brasília', 'DF', 'COMERCIAL', 1);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('72852520', 'Rua Copacabana', 11, 'Quadra 8', 'Jardim Flamboyant', 'Luziânia', 'GO', 'RESIDENCIAL', 2);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('72872340', 'Rua 55', 23, '(Quadras 105 e 106)', 'Pacaembu', 'Valparaíso de Goiás', 'GO', 'COMERCIAL', 2);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('71940720', 'Rua 19', 35, 'Bloco H', 'Sul (Águas Claras)', 'Brasília', 'DF', 'RESIDENCIAL', 3);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('70070120', 'SBS Quadra 2', 101, '', 'Asa Sul', 'Brasília', 'DF', 'COMERCIAL', 3);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('71559100', 'Rodovia DF-001', 27, '(Est Prq Contorno)', 'Varjão', 'Brasília', 'DF', 'RESIDENCIAL', 4);
INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, uf, tipo, pessoa_id) values ('71587100', 'Quadra 1 Conjunto 2 Lote 2 Bloco E', 12, '', 'Paranoá Parque (Paranoá)', 'Brasília', 'DF', 'RESIDENCIAL', 5);
