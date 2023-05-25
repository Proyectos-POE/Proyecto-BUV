Base de datos de una Biblioteca

Una universidad necesita una base de datos para administrar los libros de la
biblioteca. Cada libro tiene un ISBN, título, año de publicación, idioma, área de
conocimiento y número de páginas. Un área de conocimiento (Ciencias Naturales,
Ciencias Sociales, Ingeniería, salud) tiene un código, nombre y descripción. Un
área de conocimiento puede contener otras áreas que se las puede considerar
como áreas hijas. Por ejemplo, el área de ciencias naturales tiene como áreas hijas
a Biología, Física, Química, etc. Un libro puede estar en la biblioteca físicamente o
digitalmente. Si el libro se encuentra de forma física, puede tener varios
ejemplares. Cada ejemplar tiene asignado un número y una ubicación dentro de
biblioteca. La ubicación se compone de nombre de la sala, número del pasillo,
estante y número de cajón donde se encuentra ubicado el libro. Si el libro es digital,
se debe guardar la url donde está cargado, el formato del archivo y el tamaño en
bytes. Un libro es escrito por uno o varios autores. Un autor tiene código, primer
apellido, segundo apellido, primer nombre y segundo nombre. Los libros son
publicados por una editorial. La editorial tiene un código, nombre, página web y
país de origen.
La biblioteca tiene diferentes usuarios del cual se conoce la identificación, nombre,
dirección, teléfono, email. Los usuarios pueden ser profesores o estudiantes. Si es
estudiante, además se necesita guardar la carrera que estudia y la universidad de
donde proviene porque un estudiante de otra universidad también puede
prestados libros. Si es profesor se necesita guardar la dependencia para la cual
trabaja en la universidad, el título que posee y las diferentes áreas de interés en las
cuales trabaja. Un usuario puede pedir diferentes ejemplares en un solo préstamo,
el préstamo tiene un número consecutivo y fecha de realización. En cada préstamo
se debe registrar la fecha de devolución de cada uno de los ejemplares pedidos y
el empleado de la biblioteca que lo atendió. Un empleado tiene una identificación,
nombre y cargo. En caso de que un usuario no entregue a tiempo los ejemplares
de los libros se generará una multa que equivale $1200 diarios. Una multa se
genera cuando el usuario devuelve los libros y las fechas de devolución no
corresponden a las descritas en el préstamo. En una multa se guarda el usuario
que la generó, la fecha, el valor de la multa y una descripción. Cuando el libro es
digital, el usuario lo puede descargar si se encuentra dentro del campus de la
Universidad. Cada vez que se descarga un libro digital se debe almacenar
información como el usuario que los descarga, la fecha, hora y el número ip de la
máquina donde se hace la descarga.
Cuando los usuarios buscan un libro y no se encuentra en la biblioteca, pueden
hacer una solicitud para que este libro se adquiera en futuras compras. Una
solicitud tiene un número consecutivo, fecha, descripción, el usuario que la hace,
el ISBN y el título del nuevo libro que se requiere. Mensualmente, el encargado de
compras de la biblioteca revisa las solicitudes y decide si es necesario comprar los
libros que los usuarios pidieron.
Usted debe implementar un sistema que le permita acceder a los diferentes
usuarios manipular el sistema de biblioteca dependiendo de su perfil. Por lo
tanto, para ingresar se debe hacer mediante login y contraseña.

Entregables
1) Diagrama E-R y modelo Relacional *
2) [20%] Archivo SQL que permita crear las tablas de la base de datos e insertar
los primeros datos (Inserte por lo menos 10 registros en cada tabla. (Mayo 16 de
2023)
3) [20%] Diseño e implementación del patrón DAO (Database Access Object)
(Junio 5 de 2023)
4) [60%] Interfaz gráfica de usuario que permita acceder y manipular el sistema de
bibliotecas. (Junio 21 de 2023)
