CREATE table Showcases(
                    uuid int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                    name varchar not null ,
                    address varchar not null ,
                    type varchar not null ,
                    datecreate date ,
                    datechange timestamp
);
CREATE table Product(
                    uuid int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                    showcases_id int references Showcases(uuid) on delete set null,
                    position int not null check ( price>0 ),
                    name varchar not null ,
                    type varchar not null ,
                    price int not null check ( price>0 ),
                    datecreate date ,
                    datechange timestamp
);
drop table Product;
drop table Showcases;