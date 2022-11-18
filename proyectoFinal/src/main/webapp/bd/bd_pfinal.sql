Drop database if exists rastreo_cib_2022;
create database rastreo_cib_2022;
use rastreo_cib_2022;


create table tb_modCompra(
codmod int primary key,
modalidad varchar(30)
);

create table tb_estacion(
codestacion int primary key,
estacion varchar(25)
);


create table tb_pcomprados(
codprod int primary key,
descripcion varchar(50),
cant int,
feccompra date,
fecllegada date,
direntrega varchar(100),
codmod int,
codEstacion int,
foreign key (codmod) references tb_modCompra(codmod),
foreign key (codEstacion) references tb_estacion(codestacion)
);

create table tb_ecivil(
codecivil int primary key,
ecivil varchar(50)
);

create table tb_tipoUsuario(
codtipo int primary key,
tipo varchar(25)
);

create table tb_eusuario(
codeusuario int primary key,
eusuario varchar(25)
);

create table tb_rusuario(
codusu int auto_increment primary key,
nombres varchar(50),
apellidos varchar(50),
usuario varchar(50),
clave varchar(50),
fnac date,
codecivil int,
codtipo int default 1,
codeusuario int default 1,
foreign key (codecivil) references tb_ecivil(codecivil),
foreign key (codtipo) references tb_tipoUsuario(codtipo),
foreign key (codeusuario) references tb_eusuario(codeusuario)
);


-- TABLA tb_modalidad
insert into tb_modCompra values (1,'Delivery');
insert into tb_modCompra values (2,'Recojo en tienda');

-- TABLA tb_estacion
insert into tb_estacion values(1,'ESTACION ABANCAY');
insert into tb_estacion values(2,'ESTACION AREQUIPA');
insert into tb_estacion values(3,'ESTACION CUSCO');
insert into tb_estacion values(4,'ESTACION LIMA');
insert into tb_estacion values(5,'ESTACION TRUJILLO');
insert into tb_estacion values(6,'ESTACION ICA');

-- TABLA tb_pcomprados
insert into  tb_pcomprados values(1001,'PS5', 1, '2022-05-28', '2022-06-06', 'AV.ROBLES 123', 1, 4);
insert into  tb_pcomprados values(1002,'EL MUNDO DE LA ASTRONOMÍA', 3, '2022-05-29', '2022-06-07', 'AV.GIRASOLES 321', 1, 3);
insert into  tb_pcomprados values(1003,'CASACA INVIERNO', 5, '2022-05-30', '2022-06-08', 'AV.PLAMERAS 456', 2, 5);
insert into  tb_pcomprados values(1004,'FUNKOS-VARIOS', 7, '2022-05-31', '2022-06-09', 'AV.SOLES 963', 1, 6);
insert into  tb_pcomprados values(1005,'JUEGO DE SABANAS', 2, '2022-06-01', '2022-06-10', 'AV.PERU 741', 2, 2);
insert into  tb_pcomprados values(1006,'MANDO PS5', 2, '2022-06-02', '2022-06-11', 'AV.CANADA 753', 1, 1);

-- TABLA tb_ecivil
insert into tb_ecivil values (1, 'SOLTERO');
insert into tb_ecivil values (2, 'CASADO');
insert into tb_ecivil values (3, 'VIUDO');
insert into tb_ecivil values (4, 'DIVORCIADO');

-- TABLA tb_tipo
insert into tb_tipoUsuario values(1,'Cliente');
insert into tb_tipoUsuario values(2,'Colaborador');

-- TABLA tb_eusuario
insert into tb_eusuario values (1,'Activo');
insert into tb_eusuario values (2,'Eliminado');
insert into tb_eusuario values (3,'Suspendido');

-- TABLA tb_rusuario
insert into tb_rusuario values (null,'JOSE LUIS', 'FLORES VALDÉZ', 'F001@gmail.com', '101', '1985-06-08', 2, 2, 1);
insert into tb_rusuario values (null,'PABLO', 'GUTIRREZ VERA', 'F002@gmail.com', '102', '1986-06-10', 2, 1, 1);
insert into tb_rusuario values (null,'MARIA JUANA', 'MARITNEZ MONTES', 'F003@gmail.com', '103', '1990-06-20', 3, 1, 1);
insert into tb_rusuario values (null,'CARLOS ANDRES', 'ALVAREZ VASQUEZ', 'F004@gmail.com', '104', '1997-06-30', 1, 1, 1);

select*from tb_rusuario;
select*from tb_pcomprados;
select*from tb_ecivil;