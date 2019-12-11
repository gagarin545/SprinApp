-- Table person
CREATE TABLE person(
    idperson int not null primary key GENERATED ALWAYS AS IDENTITY ,
    name varchar(50) not null ,
    password varchar(255) not null ,
    lastname varchar(50) ,
    age int,
    UNIQUE (idperson)

);
CREATE TABLE user_roles(
  user_id int not null ,
  user_roles int not null,
  FOREIGN KEY (user_id) REFERENCES person(idperson),
  FOREIGN KEY (user_roles) REFERENCES roles(id),
  UNIQUE (user_id, user_roles)
);
CREATE TABLE roles(
   id int not null primary key ,
   name varchar(100) not null
) ;
CREATE TABLE product(
    purchase_item int not null primary key GENERATED ALWAYS AS IDENTITY,
    name varchar(255) not null ,
    cost REAL not null,
    UNIQUE (purchase_item)
);
CREATE TABLE pay(
    id int not null primary key GENERATED ALWAYS AS IDENTITY,
    purchase_item int NOT NULL ,
    idperson int NOT NULL ,
    purchase_date TIMESTAMP NOT NULL ,
    cost REAL NOT NULL,
    FOREIGN KEY (idperson) REFERENCES person(idperson),
    FOREIGN KEY (purchase_item) REFERENCES product(purchase_item)
);

