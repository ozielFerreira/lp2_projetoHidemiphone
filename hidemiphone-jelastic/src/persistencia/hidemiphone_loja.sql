
create database hidemiphone_loja;

use hidemiphone_loja;

create table admin(
idAdmin bigint auto_increment primary key,
email varchar(50) not null,
senha varchar(255) not null,
nome varchar(50) not null
)DEFAULT CHARSET = utf8;

insert into admin values(
null,'hidemiphone@gmail.com',md5('123'),'Rodrigo Hidemi'
);

create table tb_cliente (
idCliente bigint auto_increment primary key,
nome varchar(50) not null,
email varchar(50) not null,
cep varchar(20) not null
)DEFAULT CHARSET = utf8;

create table lista_telefonica (
idTel bigint auto_increment primary key,
cliente_id bigint not null,
telefone varchar(20) not null,
foreign key(cliente_id) references tb_cliente(idCliente)
)DEFAULT CHARSET = utf8;

create table tb_endereco (
idEndereco bigint auto_increment primary key,
endereco varchar(50) not null,
numero varchar(20) not null,
bairro varchar(50) not null,
cidade varchar(50) not null,
endereco_fk bigint not null,
foreign key(endereco_fk) references tb_cliente(idCliente)
)DEFAULT CHARSET = utf8;

create table tb_produto (
idProduto bigint auto_increment primary key,
nomeProd varchar(50) not null,
imagem_produto varchar(255) not null,
descricaoProd text not null,
preco double (10,2) not null
)DEFAULT CHARSET = utf8;

create table tb_servico (
idServico bigint auto_increment primary key,
nomeServ varchar(50) not null,
servico_imagem varchar(255) not null
)DEFAULT CHARSET = utf8;


create table tb_servico_descricao (
idServicoDescricao bigint auto_increment primary key,
descricaoServ text not null,
valorServ double (10,2) not null,
servico_desc_fk bigint not null,
FOREIGN KEY(servico_desc_fk)REFERENCES tb_servico(idServico)
)DEFAULT CHARSET = utf8;

-----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_categoria_produto (
  idCatProd bigint(20) NOT NULL,
  iphone varchar(50) NOT NULL,
  ipad varchar(50) NOT NULL,
  acessorio varchar(50) NOT NULL,
  categoria_fk bigint NOT NULL
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS tb_categoria_servico (
  idCatServ bigint(20) NOT NULL,
  servico_iphone varchar(50) NOT NULL,
  servico_ipad varchar(50) NOT NULL,
  cat_servico_fk bigint NOT NULL
) DEFAULT CHARSET=utf8;

-----------------------------------------------------

create table tb_ordem_servico (
idManutencao bigint auto_increment primary key,
idCliente bigint not null,
ModeloAparelhoServ varchar(50) not null,
tipoManut varchar(50) not null,
descricaoServFeito text not null,
valorServFeito double (10,2) not null,
FOREIGN KEY(idCliente)REFERENCES tb_cliente(idCliente)
)DEFAULT CHARSET = utf8;

create table tb_dadosAparelho (
idDadosAparelho bigint auto_increment primary key,
idCliente bigint not null,
numeroIMEI varchar(50) not null,
equipamento varchar(50) not null,
modelo varchar(50) not null,
origem varchar(50) not null,
corTela varchar(225) not null,
problema varchar(255) not null,
descricaoProblema text not null,
imagem3 varchar(255) not null,
dadosAparelho_fk bigint not null,
FOREIGN KEY(dadosAparelho_fk)REFERENCES tb_cliente(idCliente),
FOREIGN KEY(idCliente)REFERENCES tb_cliente(idCliente) ON DELETE CASCADE ON UPDATE NO ACTION
)DEFAULT CHARSET = utf8;

create table tb_orcamento_cliente (
idServico bigint auto_increment primary key,
idCliente bigint not null,
nomeAparelho varchar(225) not null,
solucao text not null,
valor double (10,2) not null,
orcamento_fk bigint not null,
FOREIGN KEY(idCliente)REFERENCES tb_cliente(idCliente),
FOREIGN KEY(orcamento_fk)REFERENCES tb_dadosAparelho(idDadosAparelho)    
)DEFAULT CHARSET = utf8;
