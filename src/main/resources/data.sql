insert into ROLES (id,role_Name) values ('1', 'ROLE_ADMIN'),
('2', 'ROLE_USER'),
('3', 'ROLE_ANONIMOUS');
insert into usuarios (
                       active
                     ,apellido1
                     ,apellido2
                     ,email
                     ,foto
                     ,nombre_usuario
                     ,password
                     ,sexo
                     , telefono
                     ,valoracion
                     ,alojamientos
                     ,role_id) values (
                                          true, 'Apell1', 'Apell2', 'admin@petstay.com', NULL, 'Alba', '$2a$10$GM78bWCZHQF8xnUqh.DyNOdjc6hsa/.ssrXBozbzgiJGslO7RljG6', NULL, NULL, NULL, NULL, '1'

                                      );
insert into especie(id, nombre_especie) values ('1', 'Perro'),
('2', 'Gato'),
('3', 'Conejo'),
('4', 'Hámster'),
('5', 'Tortuga'),
('6', 'Pez'),
('7', 'Pájaro'),
('8', 'Reptil');

insert into comportamientos (id, nombre_comportamientos) values ('1', 'Dócil'),
('2', 'Obediente'),
('3', 'Agresivo'),
('4', 'Cariñoso'),
('5', 'Asustadizo'),
('6', 'Desobediente'),
('7', 'Juguetón'),
('8', 'Dormilón');

insert into sexo (id, descripcion) values ('1', 'Hembra'), ('2', 'Macho');

insert into tamanio (id, nombre_tamanio) values ('1', 'Pequeño'), ('2', 'Mediano'), ('3', 'Grande');

insert into tipo_cuidados (id, descripcion, nombre) values ('1', 'Alimentar 1 vez al día', 'Alimentación'),
('2', 'Alimentar 2 veces al día'),
('3', 'Pasear 2 veces al día'),
('4', 'Pasear 3 veces al día'),
('5', 'Bañar'),
('6', 'Limpiar arenero'),
('7', 'Limpiar jaula'),
('8', 'Peinar 1 vez al día');
