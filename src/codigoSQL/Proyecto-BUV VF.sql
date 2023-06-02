--===============================================|TABLAS|===============================================--
--==============================|usuario|==============================--
DROP TABLE IF EXISTS usuario cascade;
CREATE TABLE usuario
(
    id_usuario VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    email VARCHAR(40) NOT NULL,
    contrasena VARCHAR(30) NOT NULL
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

--==============================|area_conocimiento|==============================--
DROP TABLE IF EXISTS area_conocimiento cascade;
CREATE TABLE area_conocimiento
(
    cod_area VARCHAR(4) NOT NULL PRIMARY KEY,
    nom_area VARCHAR(50) NOT NULL
);

--==============================|area_conforma|==============================--
DROP TABLE IF EXISTS area_conforma cascade;
CREATE TABLE area_conforma
(
    cod_area VARCHAR(4) NOT NULL,
    cod_area2 VARCHAR(4) NOT NULL,

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
    cod_area VARCHAR(4) NOT NULL,

    CONSTRAINT id_usuario_profesor_fk FOREIGN KEY(id_usuario) REFERENCES profesor(id_usuario),
    CONSTRAINT cod_area_profesor_fk FOREIGN KEY(cod_area) REFERENCES area_conocimiento(cod_area)
);

--==============================|editorial|==============================--
DROP TABLE IF EXISTS editorial cascade;
CREATE TABLE editorial
(
    codigo_ed VARCHAR(10) NOT NULL PRIMARY KEY,
    nom_ed VARCHAR(40) NOT NULL,
    pagina_web VARCHAR(100) NOT NULL,
    pais_origen VARCHAR(20) NOT NULL
);

--==============================|libro|==============================--
DROP TABLE IF EXISTS libro cascade;
CREATE TABLE libro
(
    isbn VARCHAR(15) NOT NULL PRIMARY KEY,
    codigo_ed VARCHAR(10) NOT NULL,
    anho_publi VARCHAR(9) NOT NULL,
    num_paginas VARCHAR(5) NOT NULL,
    idioma VARCHAR(15) NOT NULL,

    CONSTRAINT codigo_ed_libro_fk FOREIGN KEY(codigo_ed) REFERENCES editorial(codigo_ed)
);

--==============================|ejemplar|==============================--
DROP TABLE IF EXISTS ejemplar cascade;
CREATE TABLE ejemplar
(
    isbn VARCHAR(15) NOT NULL,
    num_ejemplar INTEGER NOT NULL,
    estante INTEGER NOT NULL,
    num_cajon INTEGER NOT NULL,
    nom_sala VARCHAR(20) NOT NULL,
    num_pasillo INTEGER NOT NULL,

    CONSTRAINT isbn_ejemplar_fk FOREIGN KEY(isbn) REFERENCES libro(isbn),
    PRIMARY KEY(isbn,num_ejemplar)
);

--==============================|digital|==============================--
DROP TABLE IF EXISTS digital cascade;
CREATE TABLE digital
(
    isbn VARCHAR(15) NOT NULL,
    url VARCHAR(50) NOT NULL,
    formato VARCHAR(9) NOT NULL,
    bytes VARCHAR(8) NOT NULL,

    CONSTRAINT isbn_digital_fk FOREIGN KEY(isbn) REFERENCES libro(isbn),
    PRIMARY KEY(isbn,url)
);

--==============================|descarga|==============================--
DROP TABLE IF EXISTS descarga cascade;
CREATE TABLE descarga
(
    isbn VARCHAR(15) NOT NULL,
    url VARCHAR(50) NOT NULL,
    id_usuario VARCHAR(10) NOT NULL,
    fecha_descarga VARCHAR(10) NOT NULL,
    hora_descarga VARCHAR(8) NOT NULL,
    ip INTEGER NOT NULL,

    CONSTRAINT isbn_descarga_fk FOREIGN KEY(isbn,url) REFERENCES digital(isbn, url),
    CONSTRAINT id_usuario_descarga_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	
    PRIMARY KEY(isbn, url, id_usuario, fecha_descarga, hora_descarga)
);

--==============================|autor|==============================--
DROP TABLE IF EXISTS autor cascade;
CREATE TABLE autor
(
    codigo_autor VARCHAR(10) NOT NULL PRIMARY KEY,
    primer_nom VARCHAR(20) NOT NULL,
    segundo_nom VARCHAR(20),
    primer_apellido VARCHAR(20) NOT NULL,
    segundo_apellido VARCHAR(20) NOT NULL
);

--==============================|autor_libro|==============================--
DROP TABLE IF EXISTS autor_libro cascade;
CREATE TABLE autor_libro
(
    cod_autor VARCHAR(10) NOT NULL,
    isbn VARCHAR(15) NOT NULL,

    CONSTRAINT cod_autor_autorLibro_fk FOREIGN KEY(cod_autor) REFERENCES autor(codigo_autor),
    CONSTRAINT isbn_autorLibro_fk FOREIGN KEY(isbn) REFERENCES libro(isbn),
    PRIMARY KEY(cod_autor,isbn)
);

--==============================|solicitud|==============================--
DROP TABLE IF EXISTS solicitud cascade;
CREATE TABLE solicitud
(
    num_solicitud INTEGER NOT NULL PRIMARY KEY,
    id_usuario VARCHAR(10) NOT NULL,
    isbn VARCHAR(15) NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50),

    CONSTRAINT id_usuario_solicitud_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT isbn_solicitud_fk FOREIGN KEY(isbn) REFERENCES libro(isbn)
);

--==============================|empleado|==============================--
DROP TABLE IF EXISTS empleado cascade;
CREATE TABLE empleado
(
    id_empleado VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    cargo VARCHAR(15) NOT NULL
);

--==============================|prestamo|==============================--
DROP TABLE IF EXISTS prestamo cascade;
CREATE TABLE prestamo
(
    num_prestamo INTEGER NOT NULL PRIMARY KEY,
    id_usuario VARCHAR(10) NOT NULL,
    id_empleado VARCHAR(15) NOT NULL,
    fecha DATE(10) NOT NULL,

    CONSTRAINT id_usuario_prestamo_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT id_empleado_prestamo_fk FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);

--==============================|prestamo_libro|==============================--
DROP TABLE IF EXISTS prestamo_libro cascade;
CREATE TABLE prestamo_libro
(
    num_prestamo VARCHAR(10) NOT NULL,
    isbn VARCHAR(15) NOT NULL,
    num_ejemplar INTEGER NOT NULL,
    fecha_devolucion VARCHAR(10) NOT NULL,

    CONSTRAINT numero_prestamo_libro_fk FOREIGN KEY(num_prestamo) REFERENCES prestamo(num_prestamo),
    CONSTRAINT isbn_prestamo_libro_fk FOREIGN KEY(isbn, num_ejemplar) REFERENCES ejemplar(isbn, num_ejemplar),

    PRIMARY KEY(num_prestamo, isbn, num_ejemplar)
);

--==============================|multa|==============================--
DROP TABLE IF EXISTS multa cascade;
CREATE TABLE multa
(
    id_usuario VARCHAR(10) NOT NULL,

    isbn VARCHAR(15) NOT NULL,
    num_ejemplar INTEGER NOT NULL,
    fecha_multa VARCHAR(10) NOT NULL,
    valor INTEGER NOT NULL,
    descripcion VARCHAR(50),

    CONSTRAINT usuario_multa_fk FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT isbn_multa_fk FOREIGN KEY(isbn, num_ejemplar) REFERENCES ejemplar(isbn, num_ejemplar),

    PRIMARY KEY(id_usuario, isbn, num_ejemplar, fecha_multa)
);

--===============================================|VALORES|===============================================--
--==============================|usuario|==============================--
INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1002381532', 'Juan Arango', 'Cra 12 # 39 - 77', '3135987712', 'juan.arango@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1945681309', 'Daniela Cardona', 'Cll 98 # 54 - 765', '3034547610', 'dani.cardona@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1647035471', 'Camila Zamorano', 'Cll 100 # 15a - 29', '3214385521', 'camila.zamorano@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1235348901', 'Andres Ramirez', 'Cll 70a # 26 - 49', '3165654222', 'andres.ramirez@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1124679898', 'Kevin Rendon', 'Cra 85 # 44 - 94', '3143141177', 'kevin.rendon@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1153244336', 'Nicole Galindo', 'Cra 21 # 52 - 10', '3325432318', 'nicole.galindo@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1512136590', 'Salome Herrera', 'Cra 4 # 13 - 99', '3166544354', 'salome.herrera@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1743328654', 'Jaime Perdomo', 'Cll 21 # 66b - 87', '3243254798', 'jaime.perdomo@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1436764345', 'Leandro Muñoz', 'Cll 54 # 34 - 44', '3124546897', 'leandro.munoz@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1231257657', 'Andrea Loaiza', 'Cra 71 # 83 - 235', '3145646775', 'andrea.loaiza@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1472343242', 'Ronald Gonzalez', 'Cra 18 # 33d - 01', '3124327543', 'ronald.gonzalez@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1343255324', 'Maria Lopez', 'Cll 45 # 19e - 88', '3156487651', 'maria.lopez@gmail.gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1534575410', 'Sofia Martinez', 'Cll 12 # 31 - 12', '3214453245', 'sofia.martinez@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1325324132', 'Jhoan Velasco', 'Cra 77 # 63 - 91', '3324543765', 'jhoan.velasco@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1243243289', 'Nicolas Gallego', 'Cll 20c # 49 - 32', '3324450346', 'nicolas.gallego@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1850142834', 'Sara Meneses', 'Cra 2a # 25 - 50', '3254355428', 'sara.meneses@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1232309342', 'Juliana Torres', 'Cll 55 # 21b - 43', '3129430232', 'juliana.torres@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1534232921', 'Frank Cadena', 'Cll 19 # 87 - 35', '3493215390', 'frank.cadena@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1901234320', 'Adriana Jaramillo', 'Cra 72 # 42 - 12', '3920423415', 'adriana.jaramillo@gmail.com');

INSERT INTO usuario(id_usuario, nombre, direccion, telefono, email)
	VALUES('1893220213', 'Santiago Fernandez', 'Cll 96 # 51a - 81', '3259230216', 'santiago.fernandez@gmail.com');

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

--==============================|area-conocimiento|==============================--
INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('3000', 'Ingenieria');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('3743', 'Ingenieria de Sistemas');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('3752', 'Ingenieria Civil');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('2000', 'Ciencias');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('2523', 'Fisica');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('2560', 'Quimica');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('1000', 'Licenciatura');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('1344', 'Licenciatura en Lenguas Extranjeras');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('1350', 'Licenciatura en Matemáticas');

INSERT INTO area_conocimiento(cod_area, nom_area) 
    VALUES('2531', 'Matemáticas');

INSERT INTO area_conocimiento(cod_area, nom_area)
    VALUES('3740', 'Ingenieria en Multimendia');

INSERT INTO area_conocimiento(cod_area, nom_area)
    VALUES('4000', 'Humanidades');

INSERT INTO area_conocimiento(cod_area, nom_area)
    VALUES('4521', 'Trabajo Social');

INSERT INTO area_conocimiento(cod_area, nom_area)
    VALUES('4523', 'Derecho');

--==============================|area-conforma|==============================--
INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('1000', '1344');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('1000', '1350');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('3000', '3743');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('3000', '3740');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('3000', '3752');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('2000', '2523');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('2000', '2531');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('2000', '2560');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('4000', '4521');

INSERT INTO area_conforma(cod_area, cod_area2)
    VALUES('4000', '4523');
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
    VALUES('1002381532', '3752');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1945681309', '2523');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1647035471', '1344');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1235348901', '4523');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1124679898', '4521');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1153244336', '3743');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1743328654', '2531');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1231257657', '2560');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1472343242', '3740');

INSERT INTO area_profesor(id_usuario, cod_area)
    VALUES('1901234320', '1350');
	
--==============================|editorial|==============================--
INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('100', 'Editorial Atenea', 'editorialatenea.com.co', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('101', 'Editorial Univalle', 'programaeditorial.univalle.edu.co', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('102', 'Editorial Ariel', 'planetadelibros.com/editorial/editorial-ariel/2', 'España');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('103', 'Editorial UNLP', 'editorial.unlp.edu.ar', 'Argentina');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('104', 'Editorial Macro', 'editorialmacro.com', 'Perú');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('105', 'Editorial Teseo', 'editorialteseo.com', 'Argentina');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('106', 'Iberoamericana/Vervuert', 'iberoamericana-vervuert.es', 'España');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('107', 'Babel Libros', 'babellibros.com.co', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('108', 'Editorial Planeta', 'planetadelibros.com/editorial/editorial-planeta/8', 'Colombia');

INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen)
    VALUES('109', 'Tragaluz Editores', 'casatragaluz.com', 'Colombia');
    
--==============================|libro|==============================--
INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9123456789023', '109', '2015', '96', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9876543210123', '106', '2023', '233', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9789288464497', '100', '1966', '352', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9789488464619', '100', '1970', '368', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9783287523890', '101', '2022', '232', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9842221394123', '101', '2007', '198', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9324024943123', '106', '1991', '500', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9430432213864', '102', '1999', '212', 'Ingles');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9543032943952', '104', '2003', '391', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9328502953459', '105', '2011', '277', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9558439144210', '101', '2017', '214', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9563453249324', '107', '2011', '342', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9234042034935', '104', '2004', '304', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9532942095923', '101', '1996', '241', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9852343204324', '108', '2012', '301', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9483294832044', '100', '2003', '166', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9859392348232', '106', '2008', '100', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9854327432952', '105', '2020', '135', 'Ingles');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9532948329443', '103', '2021', '290', 'Español');

INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma)
    VALUES('9894329381212', '101', '2002', '218', 'Español');

--==============================|ejemplar|==============================--
INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9532948329443', 1, 5, 2, 'Humanidades', 3);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9532948329443', 7, 5, 2, 'Humanidades', 3);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9430432213864', 2, 3, 8, 'Historia', 2);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9854327432952', 1, 5, 1, 'Medicina', 3);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9854327432952', 2, 5, 1, 'Medicina', 3);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9894329381212', 5, 2, 3, 'Ciencias Exactas', 1);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9894329381212', 3, 2, 3, 'Ciencias Exactas', 1);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9324024943123', 4, 9, 11, 'Ingenieria', 6);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9328502953459', 1, 6, 6, 'Ingenieria', 5);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9789488464619', 4, 6, 6, 'Ingenieria', 10);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9789488464619', 8, 6, 6, 'Ingenieria', 10);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9123456789023', 1, 4, 7, 'Historia', 1);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9842221394123', 2, 3, 4, 'Ciencias Exactas', 5);

INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo)
    VALUES('9842221394123', 9, 3, 4, 'Ciencias Exactas', 5);

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
    
--==============================|descarga|==============================--"
INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9532942095923', 'babellibros.com.co/libro44', '1124679898', '15/01/2023', '12:44', 131);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9876543210123', 'programaeditorial.univalle.edu.co/libro2', '1901234320', '24/03/2023', '23:10', 190);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9859392348232', 'babellibros.com.co/libro10', '1231257657', '16/12/2022', '09:55', 123);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9783287523890', 'editorialteseo.com/libro11', '1534232921', '31/01/2021', '11:30', 213);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9876543210123', 'programaeditorial.univalle.edu.co/libro2', '1436764345', '04/05/2023', '12:11', 187);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9789288464497', 'casatragaluz.com/libro12', '1325324132', '23/04/2023', '15:28', 291);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9876543210123', 'programaeditorial.univalle.edu.co/libro2', '1743328654', '14/05/2023', '11:11', 178);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9483294832044', 'editorialteseo.com/libro1', '1647035471', '21/04/2023', '06:37', 235);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9543032943952', 'editorialatenea.com.co/libro22', '1472343242', '11/03/2020', '18:21', 432);

INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip)
    VALUES('9558439144210', 'programaeditorial.univalle.edu.co/libro7', '1534575410', '14/01/2019', '23:23', 471);
	
--==============================|autor|==============================--
INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1001', 'Felipe', NULL, 'Izquierdo', 'Moreno');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1002', 'Juan', 'Gabriel', 'Garcia', 'Orejuela');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1003', 'Ana', 'Maria', 'Bisbal', 'Lozano');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1004', 'Selena', NULL, 'Gomez', 'Quintero');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1005', 'Julian', 'Andres', 'Cardozo', 'Rengifo');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1006', 'Laura', 'Isabella', 'Mosquera', 'Sandoval');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1007', 'Juan', 'Fernando', 'Alonso', 'Figueroa');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1008', 'Facundo', NULL, 'Medina', 'Collazos');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1009', 'Alejandra', NULL, 'Salazar', 'Otalvaro');

INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido)
    VALUES('1010', 'Leonardo', NULL, 'Moreno', 'Rubio');

--==============================|autor-libro|==============================--
INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1001', '9854327432952');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1002', '9876543210123');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1003', '9842221394123');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1004', '9789488464619');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1005', '9894329381212');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1002', '9543032943952');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1007', '9324024943123');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1009', '9532948329443');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1010', '9328502953459');

INSERT INTO autor_libro(cod_autor, isbn)
    VALUES('1008', '9123456789023');

--==============================|solicitud|==============================--
INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1100', '1647035471', '9123456789023', 'Historia de la lengua inglesa', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1101', '1436764345', '9328502953459', 'Matemáticas Básicas', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1102', '1124679898', '9532948329443', 'Fundamentos del Trabajo Social', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1103', '1893220213', '9324024943123', 'Fundamentos de la Ingenieria Civil', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1104', '1534232921', '9894329381212', 'Algebra Lineal', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1105', '1901234320', '9894329381212', 'Algebra Lineal', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1106', '1231257657', '9842221394123', 'Quimica Avanzada', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1107', '1534575410', '9854327432952', 'Anatomia', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1108', '1512136590', '9789488464619', 'Fundamentos de Programación: Java', NULL);

INSERT INTO solicitud(num_solicitud, id_usuario, isbn, titulo, descripcion)
    VALUES('1109', '1850142834', '9789488464619', 'Fundamentos de Programación: Java', NULL);

--==============================|empleado|==============================--
INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1983741295', 'David Garcia', 'Bibliotecario');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1389140234', 'Gabriela Barona', 'Administradora');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1821480213', 'Camilo Cifuentes', 'Aseador');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1892174309', 'Mercedes Solarte', 'Bibliotecaria');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1839248122', 'Angela Posso', 'Bibliotecaria');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1471039513', 'Mariana Valencia', 'Aseadora');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1741844213', 'Manuel Mantilla', 'Bibliotecario');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1274210344', 'Federico Belalcazar', 'Bibliotecario');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1949104142', 'Macarena Rubiano', 'Bibliotecaria');

INSERT INTO empleado(id_empleado, nombre, cargo)
    VALUES('1481041290', 'Sofia Giraldo', 'Bibliotecaria');
	
--==============================|prestamo|==============================--
INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('101', '1901234320', '1949104142', '30/01/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('102', '1850142834', '1274210344', '01/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('103', '1231257657', '1741844213', '01/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('104', '1512136590', '1839248122', '05/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('105', '1534575410', '1481041290', '06/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('106', '1534232921', '1949104142', '07/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('107', '1893220213', '1741844213', '08/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('108', '1512136590', '1892174309', '25/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('109', '1231257657', '1983741295', '26/02/2023');

INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha)
    VALUES('110', '1534575410', '1839248122', '28/02/2023');

--==============================|prestamo-libro|==============================--
INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('101', '9894329381212', 5, '20/02/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('102', '9789488464619', 4, '18/02/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('103', '9842221394123', 2, '19/02/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('104', '9789488464619', 8, '25/02/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('105', '9854327432952', 1, '27/02/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('106', '9894329381212', 3, '27/02/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('107', '9324024943123', 4, '28/02/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('108', '9789488464619', 8, '18/03/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('109', '9842221394123', 9, '20/03/2023');

INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion)
    VALUES('110', '9854327432952', 2, '24/03/2023');

--==============================|multa|==============================--
INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1901234320', '9894329381212', 5, '15/02/2023', 6000,'5 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1850142834', '9789488464619', 4, '16/02/2023', 2400,'2 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1231257657', '9842221394123', 2, '16/02/2023', 3600,'3 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1512136590', '9789488464619', 8, '20/02/2023', 6000,'5 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1534575410', '9854327432952', 1, '21/02/2023', 7200,'6 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1534232921', '9894329381212', 3, '22/02/2023', 7200,'6 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1893220213', '9324024943123', 4, '23/02/2023', 6000,'5 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1512136590', '9789488464619', 8, '12/03/2023', 7200,'6 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1231257657', '9842221394123', 9, '13/03/2023', 8400,'7 días de retraso');

INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion)
    VALUES('1534575410', '9854327432952', 2, '15/03/2023', 10800,'9 días de retraso');