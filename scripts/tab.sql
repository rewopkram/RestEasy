
ALTER TABLE PERSON DROP PRIMARY KEY CASCADE;
DROP TABLE PERSON CASCADE CONSTRAINTS;

CREATE TABLE PERSON
 (PERSON_ID NUMBER(19) NOT NULL
 ,NAME VARCHAR2(64)
 ,CITY VARCHAR2(64)
 ,COUNTRY VARCHAR2(64)
 ,HOBBIES VARCHAR2(100)
 ,DOB DATE
 );
 
ALTER TABLE COMMENT DROP PRIMARY KEY CASCADE;
DROP TABLE COMMENT CASCADE CONSTRAINTS;

CREATE TABLE MCOMMENT
 (MCOMMENT_ID NUMBER(19) NOT NULL
 ,AUTHOR VARCHAR2(64)
 ,TEXT VARCHAR2(100)
 );
 
ALTER TABLE PERSON
 ADD (CONSTRAINT PERSON_PK PRIMARY KEY 
  (PERSON_ID));
  
ALTER TABLE MCOMMENT
 ADD (CONSTRAINT MCOMMENT_PK PRIMARY KEY 
  (MCOMMENT_ID));
 
CREATE SEQUENCE MARK_SEQ
 INCREMENT BY 1
 START WITH 1000
 NOMAXVALUE
 NOMINVALUE
 NOCYCLE
 CACHE 20;
 
 