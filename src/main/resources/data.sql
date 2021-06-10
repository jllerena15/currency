create table currency
(
    id integer not null,
    origin_currency varchar(255) not null,
    destination_currency varchar(255) not null,
    exchange_rate decimal(18,7) not null,
    PRIMARY KEY (id)
);

insert into currency(id, origin_currency, destination_currency, exchange_rate) values(1, 'USD', 'PEN', 3.85);
insert into currency(id, origin_currency, destination_currency, exchange_rate) values(2, 'EUR', 'PEN', 4.68);