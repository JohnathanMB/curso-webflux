CREATE TABLE IF NOT EXISTS ESTUDIANTE(id VARCHAR(15) NOT NULL, nombreCompleto VARCHAR(50) NOT NULL, fechaNacimiento DATE NOT NULL, promedio DECIMAL(3,1) NOT NULL, curso VARCHAR(2) NOT NULL, especificacionCurso VARCHAR(2));

INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso, especificacionCurso)
VALUES ('1234567890', 'Julanito de tal', '2000-01-01', 4.5, '6', null);
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567891', 'Julanito de tal - 1', '2000-02-01', 3.5, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567892', 'Julanito de tal - 2', '2000-03-01', 2.5, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567893', 'Julanito de tal - 3', '2000-04-01', 4.4, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567894', 'Julanito de tal - 4', '2000-05-01', 2.3, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567895', 'Julanito de tal - 5', '2000-06-01', 2.5, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567896', 'Julanito de tal - 6', '2000-06-01', 4.9, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567897', 'Julanito de tal - 7', '2000-07-01', 3.9, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567898', 'Julanito de tal - 8', '2000-08-01', 4.9, '6');
INSERT INTO ESTUDIANTE(id, nombreCompleto, fechaNacimiento, promedio, curso)
VALUES ('1234567899', 'Julanito de tal - 9', '2000-09-01', 3.6, '6');