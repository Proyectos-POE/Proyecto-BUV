--===============================================|TABLAS|===============================================--
--==============================|usuario|==============================--
DROP TABLE IF EXISTS usuario cascade;
CREATE TABLE usuario
(
    id_usuario VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    email VARCHAR(40) UNIQUE NOT NULL,
    contrasena VARCHAR(40) NOT NULL
);

--==============================|estudiante|==============================--
DROP TABLE IF EXISTS estudiante cascade;
CREATE TABLE estudiante
(
    id_usuario VARCHAR(10) NOT NULL PRIMARY KEY,
    carrera VARCHAR(50) NOT NULL,
    universidad VARCHAR(50) NOT NULL,

    CONSTRAINT id_usuario_estudiante_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

--==============================|empleado|==============================--
DROP TABLE IF EXISTS empleado cascade;
CREATE TABLE empleado
(
    id_empleado VARCHAR(10) NOT NULL PRIMARY KEY,
    cargo VARCHAR(40) NOT NULL,

    CONSTRAINT id_usuario_empleado_fk FOREIGN KEY(id_empleado) REFERENCES usuario(id_usuario)
);

--==============================|area_conocimiento|==============================--
DROP TABLE IF EXISTS area_conocimiento cascade;
CREATE TABLE area_conocimiento
(
    cod_area SERIAL NOT NULL PRIMARY KEY,
    nom_area VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100)
);

--==============================|area_conforma|==============================--
DROP TABLE IF EXISTS area_conforma cascade;
CREATE TABLE area_conforma
(
    cod_area INTEGER NOT NULL,
    cod_area2 INTEGER NOT NULL,

    CONSTRAINT cod_area_conforma_fk FOREIGN KEY(cod_area) REFERENCES area_conocimiento(cod_area),
    CONSTRAINT cod_area2_conforma_fk  FOREIGN KEY(cod_area2) REFERENCES area_conocimiento(cod_area),

    PRIMARY KEY(cod_area,cod_area2)
);

--==============================|profesor|==============================--
DROP TABLE IF EXISTS profesor cascade;
CREATE TABLE profesor
(
    id_usuario VARCHAR(10) NOT NULL PRIMARY KEY,
    dependencia VARCHAR(20) NOT NULL,
    titulo VARCHAR(50) NOT NULL,

    CONSTRAINT id_usuario_profesor_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

--==============================|area_profesor|==============================--
DROP TABLE IF EXISTS area_profesor cascade;
CREATE TABLE area_profesor
(
    id_usuario VARCHAR(10) NOT NULL,
    cod_area INTEGER NOT NULL,

    CONSTRAINT id_usuario_profesor_fk FOREIGN KEY(id_usuario) REFERENCES profesor(id_usuario),
    CONSTRAINT cod_area_profesor_fk FOREIGN KEY(cod_area) REFERENCES area_conocimiento(cod_area)
);

--==============================|editorial|==============================--
DROP TABLE IF EXISTS editorial cascade;
CREATE TABLE editorial
(
    codigo_ed SERIAL NOT NULL PRIMARY KEY,
    nom_ed VARCHAR(40) NOT NULL,
    pagina_web VARCHAR(100) NOT NULL,
    pais_origen VARCHAR(20) NOT NULL
);

--==============================|libro|==============================--
DROP TABLE IF EXISTS libro cascade;
CREATE TABLE libro
(
    isbn VARCHAR(15) NOT NULL PRIMARY KEY,
    titulo VARCHAR(70) NOT NULL,
    codigo_ed INTEGER NOT NULL,
    cod_area INTEGER NOT NULL,
    anho_publi INTEGER NOT NULL,
    num_paginas VARCHAR(5) NOT NULL,
    idioma VARCHAR(15) NOT NULL,

    CONSTRAINT codigo_ed_libro_fk FOREIGN KEY(codigo_ed) REFERENCES editorial(codigo_ed),
    CONSTRAINT cod_area_libro_fk FOREIGN KEY(cod_area) REFERENCES area_conocimiento(cod_area)
);

--==============================|ejemplar|==============================--
DROP TABLE IF EXISTS ejemplar cascade;
CREATE TABLE ejemplar
(
    isbn VARCHAR(15) NOT NULL,
    num_ejemplar SERIAL NOT NULL,
    estante INTEGER NOT NULL,
    num_cajon INTEGER NOT NULL,
    nom_sala VARCHAR(20) NOT NULL,
    num_pasillo INTEGER NOT NULL,
    disponible boolean NOT NULL,

    CONSTRAINT isbn_ejemplar_fk FOREIGN KEY(isbn) REFERENCES libro(isbn),
    PRIMARY KEY(isbn,num_ejemplar)
);

--==============================|digital|==============================--
DROP TABLE IF EXISTS digital cascade;
CREATE TABLE digital
(
    num_digital SERIAL NOT NULL,
    isbn VARCHAR(15) NOT NULL,
    url VARCHAR(500) NOT NULL,
    formato VARCHAR(9) NOT NULL,
    bytes VARCHAR(8) NOT NULL,

    CONSTRAINT isbn_digital_fk FOREIGN KEY(isbn) REFERENCES libro(isbn),
    PRIMARY KEY(isbn)
);

--==============================|descarga|==============================--
DROP TABLE IF EXISTS descarga cascade;
CREATE TABLE descarga
(
    isbn VARCHAR(15) NOT NULL,
    url VARCHAR(500) NOT NULL,
    id_usuario VARCHAR(10) NOT NULL,
    fecha_descarga DATE NOT NULL,
    hora_descarga TIME NOT NULL,
    ip VARCHAR(20) NOT NULL,

    CONSTRAINT isbn_descarga_fk FOREIGN KEY(isbn) REFERENCES digital(isbn) ON DELETE CASCADE,
    CONSTRAINT id_usuario_descarga_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),

    PRIMARY KEY(isbn, id_usuario, fecha_descarga, hora_descarga)
);

--==============================|autor|==============================--
DROP TABLE IF EXISTS autor cascade;
CREATE TABLE autor
(
    codigo_autor SERIAL NOT NULL PRIMARY KEY,
    primer_nom VARCHAR(20) NOT NULL,
    segundo_nom VARCHAR(20),
    primer_apellido VARCHAR(20) NOT NULL,
    segundo_apellido VARCHAR(20) NOT NULL
);

--SELECT setval('autor_codigo_autor_seq', 1001, false);

--==============================|autor_libro|==============================--
DROP TABLE IF EXISTS autor_libro cascade;
CREATE TABLE autor_libro
(
    cod_autor INTEGER NOT NULL,
    isbn VARCHAR(15) NOT NULL,

    CONSTRAINT cod_autor_autorLibro_fk FOREIGN KEY(cod_autor) REFERENCES autor(codigo_autor),
    CONSTRAINT isbn_autorLibro_fk FOREIGN KEY(isbn) REFERENCES libro(isbn),
    PRIMARY KEY(cod_autor,isbn)
);

--==============================|solicitud|==============================--
DROP TABLE IF EXISTS solicitud cascade;
CREATE TABLE solicitud
(
    num_solicitud SERIAL NOT NULL PRIMARY KEY,
    id_usuario VARCHAR(10) NOT NULL,
    isbn VARCHAR(15) NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) ,

    CONSTRAINT id_usuario_solicitud_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

--==============================|prestamo|==============================--
DROP TABLE IF EXISTS prestamo cascade;
CREATE TABLE prestamo
(
    num_prestamo SERIAL NOT NULL  PRIMARY KEY,
    id_usuario VARCHAR(10) NOT NULL,
    id_empleado VARCHAR(15) NOT NULL,
    fecha DATE NOT NULL,

    CONSTRAINT id_usuario_prestamo_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT id_empleado_prestamo_fk FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);

--==============================|prestamo_libro|==============================--
DROP TABLE IF EXISTS prestamo_libro cascade;
CREATE TABLE prestamo_libro
(
    num_prestamo INTEGER NOT NULL,
    isbn VARCHAR(15) NOT NULL,
    num_ejemplar INTEGER NOT NULL,
    fecha_devolucion DATE NOT NULL,
    entregado boolean NOT NULL,

    CONSTRAINT numero_prestamo_libro_fk FOREIGN KEY(num_prestamo) REFERENCES prestamo(num_prestamo),
    CONSTRAINT isbn_prestamo_libro_fk FOREIGN KEY(isbn, num_ejemplar) REFERENCES ejemplar(isbn, num_ejemplar),

    PRIMARY KEY(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
);

--==============================|multa|==============================--
DROP TABLE IF EXISTS multa cascade;
CREATE TABLE multa
(
    id_usuario VARCHAR(10) NOT NULL,
    isbn VARCHAR(15) NOT NULL,
    num_ejemplar INTEGER NOT NULL,
    fecha_multa DATE NOT NULL,
    valor INTEGER NOT NULL,
    descripcion VARCHAR(50),
    estado boolean NOT NULL,

    CONSTRAINT usuario_multa_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT isbn_multa_fk FOREIGN KEY(isbn, num_ejemplar) REFERENCES ejemplar(isbn, num_ejemplar),

    PRIMARY KEY(id_usuario, isbn, num_ejemplar, fecha_multa)
);

--===============================================|VALORES|===============================================--
--==============================|usuario|==============================--
INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1002381532', 'Juan Arango', 'Cra 12 # 39 - 77', '3135987712', 'juan.arango@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1945681309', 'Daniela Cardona', 'Cll 98 # 54 - 765', '3034547610', 'dani.cardona@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1647035471', 'Camila Zamorano', 'Cll 100 # 15a - 29', '3214385521', 'camila.zamorano@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1235348901', 'Andres Ramirez', 'Cll 70a # 26 - 49', '3165654222', 'andres.ramirez@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1124679898', 'Kevin Rendon', 'Cra 85 # 44 - 94', '3143141177', 'kevin.rendon@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1153244336', 'Nicole Galindo', 'Cra 21 # 52 - 10', '3325432318', 'nicole.galindo@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1512136590', 'Salome Herrera', 'Cra 4 # 13 - 99', '3166544354', 'salome.herrera@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1743328654', 'Jaime Perdomo', 'Cll 21 # 66b - 87', '3243254798', 'jaime.perdomo@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1436764345', 'Leandro Muñoz', 'Cll 54 # 34 - 44', '3124546897', 'leandro.munoz@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1231257657', 'Andrea Loaiza', 'Cra 71 # 83 - 235', '3145646775', 'andrea.loaiza@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1472343242', 'Ronald Gonzalez', 'Cra 18 # 33d - 01', '3124327543', 'ronald.gonzalez@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1343255324', 'Maria Lopez', 'Cll 45 # 19e - 88', '3156487651', 'maria.lopez@gmail.gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1534575410', 'Sofia Martinez', 'Cll 12 # 31 - 12', '3214453245', 'sofia.martinez@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1325324132', 'Jhoan Velasco', 'Cra 77 # 63 - 91', '3324543765', 'jhoan.velasco@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1243243289', 'Nicolas Gallego', 'Cll 20c # 49 - 32', '3324450346', 'nicolas.gallego@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1850142834', 'Sara Meneses', 'Cra 2a # 25 - 50', '3254355428', 'sara.meneses@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1232309342', 'Juliana Torres', 'Cll 55 # 21b - 43', '3129430232', 'juliana.torres@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1534232921', 'Frank Cadena', 'Cll 19 # 87 - 35', '3493215390', 'frank.cadena@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1901234320', 'Adriana Jaramillo', 'Cra 72 # 42 - 12', '3920423415', 'adriana.jaramillo@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1893220213', 'Santiago Fernandez', 'Cll 96 # 51a - 81', '3259230216', 'santiago.fernandez@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1983741295', 'David Garcia', 'Cll 76 # 51a - 81', '3259230236', 'david.garcia@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1389140234', 'Gabriela Barona', 'Cll 97 # 51a - 81', '3259230226', 'gabriela.barona@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1821480213', 'Camilo Cifuentes', 'Cll 98 # 51a - 81', '3259230219', 'camilo.cifuentes@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1892174309', 'Mercedes Solarte', 'Cll 99 # 51a - 81', '3259230218', 'mercedes.solarte@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1839248122', 'Angela Posso', 'Cll 100 # 51a - 81', '3259230217', 'angela.posso@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1471039513', 'Mariana Valencia', 'Cll 91 # 51a - 81', '3259230215', 'mariana.valencia@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1741844213', 'Manuel Mantilla', 'Cll 92 # 51a - 81', '3259230214', 'manuel.matilla@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1274210344', 'Federico Belalcazar', 'Cll 93 # 51a - 81', '3259230213', 'fedrico.belalcazar@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1949104142', 'Macarena Rubiano', 'Cll 94 # 51a - 81', '3259230212', 'macarena.rubiano@gmail.com', 12345);

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email, contrasena)
VALUES('1481041290', 'Sofia Giraldo', 'Cll 95 # 51a - 81', '3259230211', 'sofia.giraldo@gmail.com', 12345);

--==============================|estudiante|==============================--
INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1534575410', 'Medicina', 'Universidad Santiago de Cali');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1893220213', 'Ingenieria Civil', 'Universidad del Valle');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1850142834', 'Ingenieria en Multimedia', 'Universidad Autónoma de Occidente');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1436764345', 'Matemáticas', 'Universidad ICESI');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1534232921', 'Fisica', 'Universidad del Valle');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1512136590', 'Ingenieria en Sistemas', 'Universidad Javeriana de Cali');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1232309342', 'Quimica', 'Universidad del Valle');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1325324132', 'Trabajo Social', 'Universidad del Valle');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1243243289', 'Derecho', 'Universidad Javeriana de Cali');

INSERT INTO estudiante(id_usuario, carrera, universidad)
VALUES('1343255324', 'Licenciatura en Matemáticas', 'Universidad Santiago de Cali');

--==============================|empleado|==============================--
INSERT INTO empleado(id_empleado, cargo)
VALUES('1983741295', 'Bibliotecario');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1389140234', 'Administradora');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1821480213', 'Aseador');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1892174309', 'Bibliotecaria');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1839248122', 'Bibliotecaria');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1471039513', 'Aseadora');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1741844213', 'Bibliotecario');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1274210344', 'Bibliotecario');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1949104142', 'Bibliotecaria');

INSERT INTO empleado(id_empleado, cargo)
VALUES('1481041290', 'Bibliotecaria');

--==============================|area-conocimiento|==============================--
INSERT INTO area_conocimiento(nom_area)
VALUES('Ingenieria');

INSERT INTO area_conocimiento(nom_area)
VALUES('Ingenieria de Sistemas');

INSERT INTO area_conocimiento(nom_area)
VALUES('Ingenieria Civil');

INSERT INTO area_conocimiento(nom_area)
VALUES('Ciencias');

INSERT INTO area_conocimiento(nom_area)
VALUES('Fisica');

INSERT INTO area_conocimiento(nom_area)
VALUES('Quimica');

INSERT INTO area_conocimiento(nom_area)
VALUES('Licenciatura');

INSERT INTO area_conocimiento(nom_area)
VALUES('Licenciatura en Lenguas Extranjeras');

INSERT INTO area_conocimiento(nom_area)
VALUES('Licenciatura en Matemáticas');

INSERT INTO area_conocimiento(nom_area)
VALUES('Matemáticas');

INSERT INTO area_conocimiento(nom_area)
VALUES('Ingenieria en Multimendia');

INSERT INTO area_conocimiento(nom_area)
VALUES('Humanidades');

INSERT INTO area_conocimiento(nom_area)
VALUES('Trabajo Social');

INSERT INTO area_conocimiento(nom_area)
VALUES('Derecho');

--==============================|area-conforma|==============================--
INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(1, 2);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(1, 3);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(1, 11);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(4, 5);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(4, 6);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(4, 10);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(7, 8);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(7, 9);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(12, 13);

INSERT INTO area_conforma(cod_area, cod_area2)
VALUES(12, 14);
--==============================|profesor|==============================--
INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1002381532', 'Ingenieria', 'Doctorado en Ingenieria Civil');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1945681309', 'Ciencias', 'Fisica');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1647035471', 'Licenciatura', 'Licenciada en Lenguas Extranjeras');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1235348901', 'Humanidades', 'Abogado');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1124679898', 'Humanidades', 'Trabajador Social');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1153244336', 'Ingenieria', 'Maestria en Ingenieria de Sistemas');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1743328654', 'Ciencias', 'Matemático');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1231257657', 'Ciencias', 'Quimica');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1472343242', 'Ingenieria', 'Doctorado en Ingenieria Multimedia');

INSERT INTO profesor(id_usuario, dependencia, titulo)
VALUES('1901234320', 'Licenciatura', 'Licenciada en Matemáticas');

--==============================|area-profesor|==============================--
INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1002381532', 1);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1945681309', 2);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1647035471', 3);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1235348901', 4);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1124679898', 5);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1153244336', 6);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1743328654', 7);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1231257657', 9);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1472343242', 9);

INSERT INTO area_profesor(id_usuario, cod_area)
VALUES('1901234320', 10);

--==============================|editorial|==============================--
INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(100, 'Editorial Atenea', 'editorialatenea.com.co', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(101, 'Editorial Univalle', 'programaeditorial.univalle.edu.co', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(102, 'Editorial Ariel', 'planetadelibros.com/editorial/editorial-ariel/2', 'España');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(103, 'Editorial UNLP', 'editorial.unlp.edu.ar', 'Argentina');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(104, 'Editorial Macro', 'editorialmacro.com', 'Perú');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(105, 'Editorial Teseo', 'editorialteseo.com', 'Argentina');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(106, 'Iberoamericana/Vervuert', 'iberoamericana-vervuert.es', 'España');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(107, 'Babel Libros', 'babellibros.com.co', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(108, 'Editorial Planeta', 'planetadelibros.com/editorial/editorial-planeta/8', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
VALUES(109, 'Tragaluz Editores', 'casatragaluz.com', 'Colombia');

--==============================|libro|==============================--
INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9123456789023', 'Historia de la lengua inglesa', 109, '2015', '96', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9876543210123', 'Quimica Avanzada', 106, '2023', '233', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9789288464497', 'Calculo I Edwardinho, Ivonne', 100, '1966', '352', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9789488464619','Fundamentos de Programación: Java', 100, '1970', '368', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9783287523890','Calculo II Edwardinho, Ivonne', 101, '2022', '232', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9842221394123', 'Calculo III Edwardinho, Ivonne', 101, '2007', '198', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9324024943123', 'Fundamentos de la Ingenieria Civil', 106, '1991', '500', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9430432213864', 'Biologia Marina' , 102, '1999', '212', 'Ingles', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9543032943952', 'Biologia Terrestre', 104, '2003', '391', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9328502953459', 'Matemáticas Básicas', 105, '2011', '277', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9558439144210', 'Fisica I Lenny', 101, '2017', '214', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9563453249324', 'Fisica II Lenny', 107, '2011', '342', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9234042034935', 'Tecnicas Dibujo Tecnico', 104, '2004', '304', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9532942095923', 'Computación Cuantica', 101, '1996', '241', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9852343204324', 'Programacion Funcional para Juniors', 108, '2012', '301', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9483294832044', 'Programacion Concurrente para Juniors', 100, '2003', '166', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9859392348232', 'Programacion En C para Juniors', 106, '2008', '100', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9854327432952', 'Anatomia', 105, '2020', '135', 'Ingles', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9532948329443', 'Fundamentos del Trabajo Social', 103, '2021', '290', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('9894329381212', 'Algebra Lineal',  101, '2002', '218', 'Español', 1);

INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma, cod_area)
VALUES('98542297382232', 'IT',  101, '1999', '3034', 'Español', 1);

--==============================|ejemplar|==============================--
INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9532948329443', 1, 5, 2, 'Humanidades', 3, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9532948329443', 7, 5, 2, 'Humanidades', 3, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9430432213864', 2, 3, 8, 'Historia', 2, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9854327432952', 1, 5, 1, 'Medicina', 3, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9854327432952', 2, 5, 1, 'Medicina', 3, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9894329381212', 1, 2, 3, 'Ciencias Exactas', 1, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9894329381212', 2, 2, 3, 'Ciencias Exactas', 1, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9894329381212', 3, 2, 3, 'Ciencias Exactas', 1, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9894329381212', 5, 2, 3, 'Ciencias Exactas', 1, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9324024943123',  4, 9, 11, 'Ingenieria', 6, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9328502953459', 1, 6, 6, 'Ingenieria', 5, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9789488464619', 4, 6, 6, 'Ingenieria', 10, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9789488464619', 8, 6, 6, 'Ingenieria', 10, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9123456789023', 1, 4, 7, 'Historia', 1, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9842221394123', 2, 3, 4, 'Ciencias Exactas', 5, false);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible)
VALUES('9842221394123', 9, 3, 4, 'Ciencias Exactas', 5, false);

--==============================|digital|==============================--
INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9543032943952', 'editorialatenea.com.co/libro22', 'PDF', '1400');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9852343204324', 'programaeditorial.univalle.edu.co/libro5', 'PDF', '1200');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9483294832044', 'editorialteseo.com/libro1', 'MOBI', '2452');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9876543210123', 'programaeditorial.univalle.edu.co/libro2', 'MOBI', '2341');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9789288464497', 'casatragaluz.com/libro12', 'MOBI', '4321');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9783287523890', 'editorialteseo.com/libro11', 'MOBI', '5365');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9563453249324', 'programaeditorial.univalle.edu.co/libro1', 'EPUB', '8621');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9859392348232', 'babellibros.com.co/libro10', 'EPUB', '6842');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9558439144210', 'programaeditorial.univalle.edu.co/libro7', 'PDF', '139');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('9532942095923', 'babellibros.com.co/libro44', 'MOBI', '1244');

INSERT INTO digital(isbn, url, formato, bytes)
VALUES('98542297382232', 'https://drive.google.com/u/0/uc?id=1yk97VodxoJoVz0DYuBedGwlZQBwWA6fS&export=download', 'PDF', '1244');

--==============================|descarga|==============================--"
INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9532942095923', 'babellibros.com.co/libro44', '1124679898', '2023/06/17', '12:44', 131);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9876543210123', 'programaeditorial.univalle.edu.co/libro2', '1901234320', '2023/06/18', '23:10', 190);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9859392348232', 'babellibros.com.co/libro10', '1231257657', '2023/06/18', '09:55', 123);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9783287523890', 'editorialteseo.com/libro11', '1534232921', '2023/06/18', '11:30', 213);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9876543210123', 'programaeditorial.univalle.edu.co/libro2', '1436764345', '2023/06/19', '12:11', 187);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9789288464497', 'casatragaluz.com/libro12', '1325324132', '2023/06/19', '15:28', 291);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9876543210123', 'programaeditorial.univalle.edu.co/libro2', '1743328654', '2023/06/19', '11:11', 178);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9483294832044', 'editorialteseo.com/libro1', '1647035471', '2023/06/19', '06:37', 235);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9543032943952', 'editorialatenea.com.co/libro22', '1472343242', '2023/06/19', '18:21', 432);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
VALUES('9558439144210', 'programaeditorial.univalle.edu.co/libro7', '1534575410', '2023/06/19', '23:23', 471);

--==============================|autor|==============================--
INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Felipe', '', 'Izquierdo', 'Moreno');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Juan', 'Gabriel', 'Garcia', 'Orejuela');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Ana', 'Maria', 'Bisbal', 'Lozano');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Selena', '', 'Gomez', 'Quintero');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Julian', 'Andres', 'Cardozo', 'Rengifo');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Laura', 'Isabella', 'Mosquera', 'Sandoval');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Juan', 'Fernando', 'Alonso', 'Figueroa');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Facundo', '', 'Medina', 'Collazos');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Alejandra', '', 'Salazar', 'Otalvaro');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Leonardo', '', 'Moreno', 'Rubio');

INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido)
VALUES('Stephen', '', 'King', '');

--==============================|autor-libro|==============================--
INSERT INTO autor_libro(cod_autor, isbn)
VALUES(1, '9854327432952');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(2, '9854327432952');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(2, '9876543210123');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(3, '9842221394123');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(4, '9789488464619');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(5, '9894329381212');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(2, '9543032943952');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(7, '9324024943123');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(9, '9532948329443');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(10, '9328502953459');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(8, '9123456789023');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(4, '9789288464497');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(7, '9783287523890');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(2, '9324024943123');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(6, '9430432213864');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(9, '9543032943952');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(3, '9563453249324');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(2, '9558439144210');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(6, '9234042034935');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(7, '9532942095923');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(7, '9852343204324');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(9, '9483294832044');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(2, '9859392348232');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(6, '9854327432952');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(1, '9532948329443');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(7, '9894329381212');

INSERT INTO autor_libro(cod_autor, isbn)
VALUES(11, '98542297382232');
--==============================|solicitud|==============================--
INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1647035471', '9123456789023', 'Historia de la lengua inglesa', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1436764345', '9328502953459', 'Matemáticas Básicas', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1124679898', '9532948329443', 'Fundamentos del Trabajo Social', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1893220213', '9324024943123', 'Fundamentos de la Ingenieria Civil', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1534232921', '9894329381212', 'Algebra Lineal', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1901234320', '9894329381212', 'Algebra Lineal', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1231257657', '9842221394123', 'Quimica Avanzada', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1534575410', '9854327432952', 'Anatomia', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1512136590', '9789488464619', 'Fundamentos de Programación: Java', NULL);

INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion)
VALUES('1850142834', '9789488464619', 'Fundamentos de Programación: Java', NULL);

--==============================|prestamo|==============================--
INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1901234320', '1949104142', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1850142834', '1274210344', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1231257657', '1741844213', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1512136590', '1839248122', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1534575410', '1481041290', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1534232921', '1949104142', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1893220213', '1741844213', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1512136590', '1892174309', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1231257657', '1983741295', '2023/06/17');

INSERT INTO prestamo(id_usuario, id_empleado, fecha)
VALUES('1534575410', '1839248122', '2023/06/17');

--==============================|prestamo-libro|==============================--
INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(1, '9894329381212', 5, '2023/06/20', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(1, '9894329381212', 1, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(1, '9894329381212', 2, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(2, '9789488464619', 4, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(3, '9842221394123', 2, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(4, '9789488464619', 8, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(5, '9854327432952', 1, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(6, '9894329381212', 3, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(7, '9324024943123', 4, '2023/07/17', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(8, '9842221394123', 9, '2023/07/19', false);

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado)
VALUES(9, '9854327432952', 2, '2023/07/19', false);

--==============================|multa|==============================--
INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1901234320', '9894329381212', 5, '2023/07/18', 6000,'5 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1850142834', '9789488464619', 4, '2023/07/18', 2400,'2 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1231257657', '9842221394123', 2, '2023/07/18', 3600,'3 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1512136590', '9789488464619', 8, '2023/07/18', 6000,'5 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1534575410', '9854327432952', 1, '2023/07/18', 7200,'6 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1534232921', '9894329381212', 3, '2023/07/18', 7200,'6 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1893220213', '9324024943123', 4, '2023/07/18', 6000,'5 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1512136590', '9789488464619', 8, '2023/07/20', 7200,'6 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1231257657', '9842221394123', 9, '2023/07/20', 8400,'7 días de retraso', false);

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado)
VALUES('1534575410', '9854327432952', 2, '2023/07/20', 10800,'9 días de retraso', false);