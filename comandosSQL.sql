use escuelita;

SELECT * FROM cursos;
delete from cursos where idCurso=3;
INSERT INTO cursos VALUES (0, 'Introduccion a la vida mutante', '1');
INSERT INTO cursos VALUES (0, 'Introducción a la aviación', '1');
INSERT INTO cursos VALUES (0, 'Psicologia mutante', '1');
UPDATE cursos SET nombre_curso='Introducción a la aviación mutante' WHERE idCurso=4;

SELECT * FROM temas;
INSERT INTO temas VALUES (0, 'Protocolo y Seguridad', '1');
delete from temas where id_curso=3;

SELECT * FROM profesores;
INSERT INTO profesores VALUES (0, 'Carlos', 'Javier', '1234-5678', 'X-Mansion', '0800-123-4567', 'carlosjavierx@escuelita.edu', 'refugiomutante');
UPDATE profesores SET password='carlitos' WHERE idProfesor='1';
UPDATE profesores SET mail='@escuelita.edu' WHERE idProfesor='1';

SELECT * FROM alumnos;
delete from alumnos  where idAlumno=16;

select idCurso, nombre_curso, nombre_tema, idTema 
from cursos inner join temas 
on cursos.idCurso=temas.id_curso;