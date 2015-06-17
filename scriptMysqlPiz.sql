--delete from productosp;

--drop table productosp;

create table productosp(
productoid int auto_increment not null,
nombrep varchar(50) not null,
precio double,
primary key(productoid)
)Engine Innodb;

insert into productosp (nombrep, precio) values ("margarita", 7.90);
insert into productosp (nombrep, precio) values ("carbonara", 8.70);
insert into productosp (nombrep, precio) values ("4quesos", 9.00);
insert into productosp (nombrep, precio) values ("serrana", 9.30);

select * from productosp;

--delete from clientesp;

--drop table clientesp;

create table clientesp(
clienteid int auto_increment not null,
nombrec varchar(50) not null,
direccion varchar(50) not null,
primary key(clienteid)
)Engine Innodb;

insert into clientesp (nombrec, direccion) values ("john", "liverpool");
insert into clientesp (nombrec, direccion) values ("paul", "liverpool");
insert into clientesp (nombrec, direccion) values ("george", "liverpool");
insert into clientesp (nombrec, direccion) values ("ringo", "liverpool");

select * from clientesp;