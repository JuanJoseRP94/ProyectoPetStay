insert into ROLES (role_Name) values ( 'ROLE_ADMIN'),
                                     ( 'ROLE_USER'),
                                     ('ROLE_ANONIMOUS');
insert into usuarios (active ,apellido1 ,apellido2 ,email ,foto ,nombre_usuario ,password , telefono ,valoracion ,alojamientos ,role_id)
values (true, 'Apell1', 'Apell2', 'admin@petstay.com', NULL, 'Alba', '$2a$10$GM78bWCZHQF8xnUqh.DyNOdjc6hsa/.ssrXBozbzgiJGslO7RljG6', NULL,  NULL, NULL, '1' );
insert into especie(nombre_especie) values ( 'Perro'),
                                           ( 'Gato'),
                                           ( 'Conejo'),
                                           ( 'Hámster'),
                                           ( 'Tortuga'),
                                           ( 'Pez'),
                                           ( 'Pájaro'),
                                           ( 'Reptil');

insert into comportamientos ( nombre_comportamientos) values ( 'Dócil'),
                                                             ( 'Obediente'),
                                                             ( 'Agresivo'),
                                                             ( 'Cariñoso'),
                                                             ( 'Asustadizo'),
                                                             ( 'Desobediente'),
                                                             ( 'Juguetón'),
                                                             ( 'Dormilón');
insert into sexo ( descripcion) values ( 'Hembra'), ( 'Macho');

insert into tamanio ( nombre_tamanio) values ( 'Pequeño'), ( 'Mediano'), ( 'Grande');

insert into tipo_cuidados (nombre_cuidado) values ('Alimentar 1 vez al día'),
                                                  ('Alimentar 2 veces al día' ),
                                                  ('Pasear 3 veces al día'),
                                                  ( 'Bañar'),
                                                  ( 'Limpiar arenero'),
                                                  (  'Limpiar jaula'),
                                                  (  'Peinar 1 vez al día');

insert into tamanio_alojamiento ( nombre) values ( 'Pequeño'), ( 'Mediano'), ( 'Grande');

insert into tipo_alojamiento ( nombre_tipo_alojamiento) values ( 'Casa'), ('Piso'), ( 'Duplex'), ( 'Estudio'), ( 'Bajo');