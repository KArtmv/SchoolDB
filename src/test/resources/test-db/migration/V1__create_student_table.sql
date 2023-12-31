-- Table: public.students

-- DROP TABLE IF EXISTS student;

CREATE TABLE IF NOT EXISTS students
(
    student_id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    group_id integer,
    CONSTRAINT students_pkey PRIMARY KEY (student_id)
)

TABLESPACE pg_default;