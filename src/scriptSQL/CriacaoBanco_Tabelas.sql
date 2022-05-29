/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  esrae
 * Created: 21 de mai. de 2022
 */

CREATE DATABASE Livraria;

USE Livraria;

CREATE TABLE livros (
    idLivro INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    autor VARCHAR(80) NOT NULL,
    assunto VARCHAR(60), 
    status BOOLEAN DEFAULT TRUE
);


CREATE TABLE usuario (
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nomeCompleto VARCHAR(50) NOT NULL,
    cpf INT NOT NULL,
    nascimento DATE NOT NULL,
    sexo CHAR NOT NULL, 
    email VARCHAR(70) NOT NULL,
    senha VARCHAR(64) NOT NULL,
    celular INT UNSIGNED,
    telefone INT UNSIGNED
);