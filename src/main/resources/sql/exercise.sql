CREATE TABLE EXERCISE(
  ID INTEGER NOT NULL,
  CREATION_DATE DATE,
  MODIFY_DATE DATE,
  VERSION INTEGER,
  TYPE VARCHAR (24),
  CONTENTS VARCHAR (255),
  MANTISE_ARG1 FLOAT,
  MANTISE_ARG2 FLOAT,
  CELLING_ARG1 INTEGER,
  CELLING_ARG2 INTEGER,
  BASE INTEGER,
  RESULT_FK INTEGER NOT NULL ,
  PRIMARY KEY (ID),
  FOREIGN KEY (RESULT_FK) REFERENCES result (id)
);
CREATE SEQUENCE id_sequence START 1;

INSERT INTO EXERCISE(ID, CREATION_DATE, MODIFY_DATE, VERSION, TYPE, CONTENTS, MANTISE_ARG1,CELLING_ARG1, MANTISE_ARG2, CELLING_ARG2, BASE, RESULT_FK )
VALUES (nextval('id_sequence'), current_date, current_date, 1, 'SUBTRATION', 'odejmowanie2', 0.45, -3, 0.44, 5, 10, 4 );

INSERT INTO EXERCISE(ID, CREATION_DATE, MODIFY_DATE, VERSION, TYPE, CONTENTS, MANTISE_ARG1,CELLING_ARG1, MANTISE_ARG2, CELLING_ARG2, BASE, RESULT_FK)
VALUES (nextval('id_sequence'), current_date, current_date, 1, 'MULTIPLICATION', 'mnoz2', 0.95, -3, 0.44, 5, 10,4 );

INSERT INTO EXERCISE(ID, CREATION_DATE, MODIFY_DATE, VERSION, TYPE, CONTENTS, MANTISE_ARG1,CELLING_ARG1, MANTISE_ARG2, CELLING_ARG2, BASE, RESULT_FK)
VALUES (nextval('id_sequence'), current_date, current_date, 1, 'DIVISION', 'dzie2', 0.45, -3, 0.44, 5, 10, 3 );

INSERT INTO EXERCISE(ID, CREATION_DATE, MODIFY_DATE, VERSION, TYPE, CONTENTS, MANTISE_ARG1,CELLING_ARG1, MANTISE_ARG2, CELLING_ARG2, BASE, RESULT_FK)
VALUES (nextval('id_sequence'), current_date, current_date, 1, 'ADDITION', 'DOD2', 0.43, -3, 0.44, 5, 10, 4 );


COMMIT;

SELECT * FROM EXERCISE;
DROP SEQUENCE id_sequence;

--    ADDITION("Dodawanie", "+"),
--    SUBTRATION("Odejmowanie", "-"),
 --   MULTIPLICATION("Mnożenie", "*"),
 --   DIVISION("Dzielenie", "/");
DROP TABLE EXERCISE CASCADE ;
DELETE FROM EXERCISE WHERE RESULT_FK ISNULL;