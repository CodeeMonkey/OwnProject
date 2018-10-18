insert into airline(id, code, name) values (1000, 'LUF', 'Lufthansa');
insert into airline(id, code, name) values (2000, 'SAB', 'Sabena');

insert into login(id, email, password) values (1000, 'timmerel@gmail.com', 'paswoord');
insert into person(id, firstName, lastName, country, mobilePhone, birthDate, version, login_id) values (1000, 'Tom', 'Merel', 'Belgium', '048553322', '1964-12-28', 0.1, 1000);
insert into employee(id, person_id) values (1000, 1000);

insert into login(id, email, password) values (2000, 'geraldBien@gmail.com.com', 'paswoord');
insert into person(id, firstName, lastName, country, mobilePhone, birthDate, version, login_id) values (2000, 'Gerald', 'Bien', 'Belgium', '048553322', '1964-12-28', 0.1, 2000);
insert into partneremployee(id, airline_id, person_id) values (1000, 1000, 2000);

insert into login(id, email, password) values (3000, 'BartBier@gmail.com', 'paswoord');
insert into person(id, firstName, lastName, country, mobilePhone, birthDate, version, login_id) values (3000, 'Bart', 'Bier', 'Belgium', '048553322', '1964-12-28', 0.1, 3000);
insert into partneremployee(id, airline_id, person_id) values (2000, 2000, 3000);

insert into login(id, email, password) values (4000, 'MerelPeeters@gmail.com', 'paswoord');
insert into person(id, firstName, lastName, country, mobilePhone, birthDate, version, login_id) values (4000, 'Merel', 'Peeters', 'Belgium', '048553322', '1964-12-28', 0.1, 4000);
insert into user(id, person_id) values (1000,4000);