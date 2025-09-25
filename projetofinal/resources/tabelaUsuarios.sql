create table usuarios (
	id integer not null auto_increment primary key,
    nome varchar(50),
    senha varchar(50)
);

create table fornecedores (

	id integer not null auto_increment primary key,
    nome varchar(100),
    cnpj varchar(15),
    telefone varchar(10)
);