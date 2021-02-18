CREATE SEQUENCE cod_cliente_seq;
CREATE TABLE tb_cliente(
	cod_cliente				INTEGER NOT NULL DEFAULT NEXTVAL('cod_cliente_seq'),
	email					VARCHAR(256) NOT NULL UNIQUE,
	senha					VARCHAR(32) NOT NULL,
	nome_completo			VARCHAR(60) NOT NULL,
	cpf						VARCHAR(11) NOT NULL,
	data_nascimento			DATE,
	CONSTRAINT pk_cliente_cod_cliente PRIMARY KEY(cod_cliente)
);
ALTER SEQUENCE cod_cliente_seq OWNED BY tb_cliente.cod_cliente;

CREATE SEQUENCE cod_endereco_seq;
CREATE TABLE tb_endereco(
	cod_endereco			INTEGER NOT NULL DEFAULT NEXTVAL('cod_endereco_seq'),
	cep						VARCHAR(8),
	cidade					VARCHAR(50) NOT NULL,
	bairro					VARCHAR(72) NOT NULL,
	rua						VARCHAR(70) NOT NULL,
	numero					VARCHAR(4) NOT NULL,
	complemento				VARCHAR(100),
	CONSTRAINT pk_endereco_cod_endereco PRIMARY KEY(cod_endereco)
);
ALTER SEQUENCE cod_endereco_seq OWNED BY tb_endereco.cod_endereco;

CREATE TABLE tb_endereco_cliente(
	cod_endereco			INTEGER NOT NULL,
	cod_cliente				INTEGER NOT NULL,
	CONSTRAINT pk_end_cli_cod_end_cod_cli PRIMARY KEY(cod_endereco, cod_cliente),
	CONSTRAINT fk_end_cli_cod_end FOREIGN KEY(cod_endereco)
		REFERENCES tb_endereco(cod_endereco),
	CONSTRAINT fk_end_cli_cod_cli FOREIGN KEY(cod_cliente)
		REFERENCES tb_cliente(cod_cliente)
);

CREATE SEQUENCE cod_compra_seq;
CREATE TABLE tb_compra(
	cod_compra				INTEGER NOT NULL DEFAULT NEXTVAL('cod_compra_seq'),
	valor_total				NUMERIC(4,2) NOT NULL,
	data_compra				DATE NOT NULL,
	observacoes				VARCHAR(200),
	cod_cliente				INTEGER NOT NULL,
	cod_endereco			INTEGER NOT NULL,
	CONSTRAINT pk_compra_cod_compra PRIMARY KEY(cod_compra),
	CONSTRAINT fk_compra_cod_cliente FOREIGN KEY(cod_cliente)
		REFERENCES tb_cliente(cod_cliente),
	CONSTRAINT fk_compra_cod_endereco FOREIGN KEY(cod_endereco)
		REFERENCES tb_endereco(cod_endereco)
);
ALTER SEQUENCE cod_compra_seq OWNED BY tb_compra.cod_compra;

CREATE SEQUENCE cod_produto_seq;
CREATE TABLE tb_produto(
	cod_produto				INTEGER NOT NULL DEFAULT NEXTVAL('cod_produto_seq'),
	nome_produto			VARCHAR(60) NOT NULL,
	preco_produto			NUMERIC(5,2),
	listado					BOOLEAN,
	fg_ativo				BOOLEAN,
	CONSTRAINT pk_produto_cod_produto PRIMARY KEY(cod_produto)
);
ALTER SEQUENCE cod_produto_seq OWNED BY tb_produto.cod_produto;

CREATE TABLE tb_compra_produto(
	cod_compra				INTEGER NOT NULL,
	cod_produto				INTEGER NOT NULL,
	quantidade_produto		INTEGER,
	CONSTRAINT pk_com_pro_cod_com_cod_pro PRIMARY KEY(cod_compra, cod_produto),
	CONSTRAINT fk_com_pro_cod_com FOREIGN KEY(cod_compra)
		REFERENCES tb_compra(cod_compra),
	CONSTRAINT fk_com_pro_cod_pro FOREIGN KEY(cod_produto)
		REFERENCES tb_produto(cod_produto)
);

CREATE SEQUENCE cod_cat_ingred_seq;
CREATE TABLE tb_categoria_ingrediente(
	cod_categoria_ingrediente	INTEGER NOT NULL DEFAULT NEXTVAL('cod_cat_ingred_seq'),
	categoria_ingrediente		VARCHAR(20) NOT NULL,
	CONSTRAINT pk_cat_ingred_cod_cat_ingred PRIMARY KEY(cod_categoria_ingrediente)
);
ALTER SEQUENCE cod_cat_ingred_seq OWNED BY tb_categoria_ingrediente.cod_categoria_ingrediente;

CREATE SEQUENCE cod_ingrediente_seq;
CREATE TABLE tb_ingrediente(
	cod_ingrediente				INTEGER NOT NULL DEFAULT NEXTVAL('cod_ingrediente_seq'),
	nome_ingrediente			VARCHAR(60) NOT NULL,
	preco_ingrediente			NUMERIC(5,2),
	unidade_ingrediente			VARCHAR(10),
	cod_categoria_ingrediente	INTEGER NOT NULL,
	fg_ativo					BOOLEAN,
	CONSTRAINT pk_ingred_cod_ingred PRIMARY KEY(cod_ingrediente),
	CONSTRAINT fk_ingred_cod_cat_ingred FOREIGN KEY(cod_categoria_ingrediente)
		REFERENCES tb_categoria_ingrediente(cod_categoria_ingrediente)
);
ALTER SEQUENCE cod_ingrediente_seq OWNED BY tb_ingrediente.cod_ingrediente;

CREATE TABLE tb_produto_ingrediente(
	cod_produto				INTEGER NOT NULL,
	cod_ingrediente			INTEGER NOT NULL,
	quantidade_ingrediente	INTEGER,
	CONSTRAINT pk_prod_ingred_cod_prod_cod_ingred PRIMARY KEY(cod_produto, cod_ingrediente),
	CONSTRAINT fk_prod_ingred_cod_prod FOREIGN KEY(cod_produto)
		REFERENCES tb_produto(cod_produto),
	CONSTRAINT fk_prod_ingred_cod_ingred FOREIGN KEY(cod_ingrediente)
		REFERENCES tb_ingrediente(cod_ingrediente)
);
