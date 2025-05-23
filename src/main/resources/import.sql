INSERT INTO tb_tipo (descricao) VALUES ('Eletrônicos');
INSERT INTO tb_tipo (descricao) VALUES ('Alimentos');
INSERT INTO tb_tipo (descricao) VALUES ('Roupas');

INSERT INTO tb_produto(titulo, descricao, preco, estoque, id_tipo) VALUES ('Titulo A', 'Descrição A', 100.99, 10.00, 1);
INSERT INTO tb_produto(titulo, descricao, preco, estoque, id_tipo) VALUES ('Titulo B', 'Descrição B', 200.00, 20.00, 2);
INSERT INTO tb_produto(titulo, descricao, preco, estoque, id_tipo) VALUES ('Titulo C', 'Descrição C', 150.00, 140.20, 3);
INSERT INTO tb_produto(titulo, descricao, preco, estoque, id_tipo) VALUES ('Titulo D', 'Descrição D', 300.00, 10.50, 1);

INSERT INTO tb_usuario(nome, login, senha) VALUES ('Odilon', 'odilon@odilon', '123');
INSERT INTO tb_usuario(nome, login, senha) VALUES ('Crislaine', 'crisl@crisl', '456');
INSERT INTO tb_usuario(nome, login, senha) VALUES ('Admin', 'admin@admin', 'root');

