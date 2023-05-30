CREATE TABLE Usuario (
  ID INT PRIMARY KEY,
  foto VARCHAR(255),
  nombre_usuario VARCHAR(255) UNIQUE,
  apellido1 VARCHAR(255),
  apellido2 VARCHAR(255),
  valoracion DECIMAL(3,2),
  sexo VARCHAR(10),
  email VARCHAR(255),
  telefono VARCHAR(20)
);

CREATE TABLE Tamaños (
  ID INT PRIMARY KEY,
  nombre VARCHAR(255)
);

CREATE TABLE Comportamiento (
  ID INT PRIMARY KEY,
  nombre VARCHAR(255)
);

CREATE TABLE Especie (
  ID INT PRIMARY KEY,
  nombre VARCHAR(255)
);

CREATE TABLE Raza (
  ID INT PRIMARY KEY,
  nombre VARCHAR(255),
  especie_id INT,
  FOREIGN KEY (especie_id) REFERENCES Especie(ID)
);



CREATE TABLE Mascotas (
  ID INT PRIMARY KEY,
  foto VARCHAR(255),
  nombre VARCHAR(255),
  edad INT,
  raza_id INT,
  tamaño_id INT,
  sexo VARCHAR(10),
  cartilla_vacunacion VARCHAR(255),
  valoracion DECIMAL(3,2),
  FOREIGN KEY (raza_id) REFERENCES Raza(ID),
  FOREIGN KEY (tamaño_id) REFERENCES Tamaños(ID)
);

CREATE TABLE Tipos_de_cuidados (
  ID INT PRIMARY KEY,
  nombre VARCHAR(255),
  duracion_servicio INT,
  coste_hora DECIMAL(6,2),
  coste_unidad DECIMAL(6,2)
);

CREATE TABLE Mascotas_Has_comportamiento (
  mascota_id INT,
  comportamiento_id INT,
  FOREIGN KEY (mascota_id) REFERENCES Mascotas(ID),
  FOREIGN KEY (comportamiento_id) REFERENCES Comportamiento(ID),
  PRIMARY KEY (mascota_id, comportamiento_id)
);

CREATE TABLE Mascotas_requiere_cuidados (
  mascota_id INT,
  tipo_cuidado_id INT,
  FOREIGN KEY (mascota_id) REFERENCES Mascotas(ID),
  FOREIGN KEY (tipo_cuidado_id) REFERENCES Tipos_de_cuidados(ID),
  PRIMARY KEY (mascota_id, tipo_cuidado_id)
);

CREATE TABLE Oferta (
  ID INT PRIMARY KEY,
  valoracion_media DECIMAL(3,2),
  comentarios TEXT
);

CREATE TABLE Oferta_implica_cuidados (
  oferta_id INT,
  tipo_cuidado_id INT,
  FOREIGN KEY (oferta_id) REFERENCES Oferta(ID),
  FOREIGN KEY (tipo_cuidado_id) REFERENCES Tipos_de_cuidados(ID),
  PRIMARY KEY (oferta_id, tipo_cuidado_id)
);

CREATE TABLE Contratacion (
  ID INT PRIMARY KEY,
  factura VARCHAR(255),
  oferta_id INT,
  usuario_id INT,
  FOREIGN KEY (oferta_id) REFERENCES Oferta(ID),
  FOREIGN KEY (usuario_id) REFERENCES Usuario(ID)
);

CREATE TABLE Pagos (
  ID INT PRIMARY KEY,
  tipo_pago VARCHAR(255),
  tipo_tarjeta VARCHAR(255),
  factura_id INT,
  FOREIGN KEY (factura_id) REFERENCES Contratacion(ID)
);
