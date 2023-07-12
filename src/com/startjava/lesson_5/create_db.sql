DROP TABLE IF EXISTS jaegers;

CREATE DATABASE jaegers;

CREATE TABLE jaegers
(
    id         SERIAL PRIMARY KEY,
    model_name TEXT,
    mark       CHAR(6),
    height     NUMERIC(4, 2),
    weight     NUMERIC(4, 3),
    status     TEXT,
    origin     TEXT,
    launch     INT,
    kaiju_kill INT
);

\ir
init_db.sql

\ir queries.sql
