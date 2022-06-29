--CREATE TABLE IF NOT EXISTS ESTUDIANTE(id VARCHAR(15) NOT NULL, nombreCompleto VARCHAR(50) NOT NULL, fechaNacimiento DATE NOT NULL, promedio DECIMAL(3,1) NOT NULL, curso VARCHAR(2) NOT NULL, especificacionCurso VARCHAR(2));

INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso, especificacionCurso)
VALUES ('1234567890', 'Julanito de tal', '2000-01-01', 4.5, '6', 'A');