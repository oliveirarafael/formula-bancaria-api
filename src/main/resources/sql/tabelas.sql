CREATE TABLE simulado (
	id serial CONSTRAINT pk_simulado PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	nome varchar(255) NOT NULL,
	descricao text,
	quantidade_questao_por_execucao integer NOT NULL,
	data_hora_criacao timestamp NOT NULL
);

CREATE TABLE modulo (
	id serial CONSTRAINT pk_modulo PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	nome varchar(255) NOT NULL,
	descricao text,
	percentaul integer NOT NULL,
	data_hora_criacao timestamp NOT NULL,
	FOREIGN KEY (id_simulado) REFERENCES simulado (id)
);

CREATE TABLE questao (
	id serial CONSTRAINT pk_questao PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	assunto varchar(150) NOT NULL,
	enunciado varchar(150) NOT NULL,
	comentario varchar(255),
	data_hora_criacao timestamp NOT NULL
);

CREATE TABLE modulo_questao(
	FOREIGN KEY (id_modulo) REFERENCES modulo (id),
    FOREIGN KEY (id_questao) REFERENCES questao (id)
);

