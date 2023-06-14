delete from usuarios where id > 1;
delete from roles where id > 1;

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
insert into comportamientos (id,`nombre_comportamientos`) values ('1', 'bueno'),
                                        ('2', 'desobediente'),
                                        ('3', 'agresivo');
insert into sexo (id,`descripcion`) values ('1', 'hembra'),
                                                                 ('2', 'macho');

insert into tipo_cuidados (id,`descripcion`,nombre) values ('1', 'comer dos veces al día','alimentacion'),
                                           ('2', 'comer 3 veces al día','alimentacion 3');

insert into especie (id,`nombre_especie`) values ('1', 'perro'),
                                           ('2', 'gato'),
                                                 (3,'politico');