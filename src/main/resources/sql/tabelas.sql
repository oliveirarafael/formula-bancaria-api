DROP TABLE IF EXISTS simulado, modulo, 
questao, resposta, modulo_questao, perfil, usuario;

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
	percentual integer NOT NULL,
	data_hora_criacao timestamp NOT NULL,
	simulado integer NOT NULL,
	FOREIGN KEY (simulado) REFERENCES simulado (id)
);

CREATE TABLE questao (
	id serial CONSTRAINT pk_questao PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	assunto varchar(150) NOT NULL,
	enunciado varchar(150) NOT NULL,
	comentario varchar(255),
	data_hora_criacao timestamp NOT NULL
);

CREATE TABLE resposta(
	id serial CONSTRAINT pk_resposta PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	descricao varchar(255) NOT NULL,
	correta boolean NOT NULL DEFAULT FALSE,
	questao integer NOT NULL,
	FOREIGN KEY (questao) REFERENCES questao (id)
);

CREATE TABLE modulo_questao(
	modulo integer NOT NULL,
	questao integer NOT NULL,
	FOREIGN KEY (modulo) REFERENCES modulo (id),
    FOREIGN KEY (questao) REFERENCES questao (id)
);

CREATE TABLE perfil(
	id serial CONSTRAINT pk_perfil PRIMARY KEY,
	nome varchar(150) UNIQUE NOT NULL
);

CREATE TABLE usuario(
	id serial CONSTRAINT pk_usuario PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	nome varchar(150) NOT NULL,
	sobrenome varchar(200) NOT NULL,
	email varchar(100) NOT NULL,
	senha varchar(500) NOT NULL,
	assinante boolean NOT NULL DEFAULT FALSE,
	data_hora_criacao timestamp NOT NULL
);

CREATE TABLE perfil_usuario(
	perfil integer NOT NULL,
	usuario integer NOT NULL,
	FOREIGN KEY (perfil) REFERENCES perfil (id),
    FOREIGN KEY (usuario) REFERENCES usuario (id)
);

CREATE TABLE simulado_respondido(
	id serial CONSTRAINT pk_simulado_respondido PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	data_hora_criacao timestamp NOT NULL,
    simulado integer NOT NULL,
	usuario integer NOT NULL,
	FOREIGN KEY (simulado) REFERENCES simulado(id),
	FOREIGN KEY (usuario) REFERENCES usuario(id)	
);

CREATE TABLE questao_respondida(
	id serial CONSTRAINT pk_questao_respondida PRIMARY KEY,
	uuid varchar(255) UNIQUE NOT NULL,
	data_hora_criacao timestamp NOT NULL,
    simulado_respondido integer NOT NULL,
	questao integer NOT NULL,
	resposta integer NOT NULL,
	FOREIGN KEY (simulado_respondido) REFERENCES simulado_respondido(id),
	FOREIGN KEY (questao) REFERENCES questao(id),
	FOREIGN KEY (resposta) REFERENCES resposta(id)	
);