drop table ventas;

create table ventas(
clienteid int not null,
productoid int not null,
cantidad int,
fecha Timestamp,
facturaid int 
)Engine Innodb;

alter table ventas add primary key (clienteid, productoid);
alter table ventas add constraint fk_clienteid foreign key (clienteid)references clientesp (clienteid);
alter table ventas add constraint fk_productoid foreign key (productoid) references productosp (productoid);

select * from ventas;

desc ventas;