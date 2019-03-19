CREATE TABLE pessoa (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	data_nascimento DATE NOT NULL,
	ddd VARCHAR(2),
	telefone_fixo VARCHAR(10),
	celular VARCHAR(10),
	email VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, cpf, data_nascimento, ddd, telefone_fixo, celular, email) values ('José da Silva', '95061372000', '1990-02-16', '61', '23487563', '991063150', 'jose_s@gmail.com');
INSERT INTO pessoa (nome, cpf, data_nascimento, ddd, telefone_fixo, celular, email) values ('Maria Eugênia ', '02358172014', '1993-07-22', '62', '34827390', '985159722', 'maria.eugenia@outlook.com');
INSERT INTO pessoa (nome, cpf, data_nascimento, ddd, telefone_fixo, celular, email) values ('Ana Clara Sousa', '65140007037', '1985-04-11', '61', '22003948', '996006747', 'ana.c.sousa@gmail.com');
INSERT INTO pessoa (nome, cpf, data_nascimento, ddd, telefone_fixo, celular, email) values ('João Severo', '51318791081', '1989-12-27', '61', '23076453', '995250910', 'jsevero@yahoo.com');
INSERT INTO pessoa (nome, cpf, data_nascimento, ddd, telefone_fixo, celular, email) values ('Antônio Bastista', '78188222089', '1981-03-17', '11', '24369867', '983607142', 'antonio-batista@gmail.com');
INSERT INTO pessoa (nome, cpf, data_nascimento, ddd, telefone_fixo, celular, email) values ('Carla Teixeira', '29225209002', '1978-06-07', '34', '34513458', '988195327', 'carla_tx@uol.com');
INSERT INTO pessoa (nome, cpf, data_nascimento, ddd, telefone_fixo, celular, email) values ('Mauricio Fernandes', '94294144025', '2001-11-15', '41', '41246578', '991932465', 'mauricio.fer@outlook.com');
