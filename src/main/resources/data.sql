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