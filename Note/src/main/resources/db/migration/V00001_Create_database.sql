CREATE DATABASE "notesdb"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE IF NOT EXISTS public."Users"
(
    username character varying(30) COLLATE pg_catalog."default" NOT NULL,
    id_user integer NOT NULL,
    password character varying(30) COLLATE pg_catalog."default" NOT NULL,
    role character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Users_pkey" PRIMARY KEY (id_user)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Users"
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public."Notes"
(
    id_note integer NOT NULL,
    id_user integer NOT NULL,
    heading character varying(100) COLLATE pg_catalog."default" NOT NULL,
    date_creation date,
    date_change date,
    text text COLLATE pg_catalog."default",
    CONSTRAINT "Notes_pkey" PRIMARY KEY (id_note)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Notes"
    OWNER to postgres;