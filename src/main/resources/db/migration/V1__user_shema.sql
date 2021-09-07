create TABLE backend_user (
                          id BIGINT NOT NULL CONSTRAINT backend_user_pkey PRIMARY KEY,
                          email VARCHAR(255),
                          password VARCHAR(1000),
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          active BOOLEAN NOT NULL,
                          created TIMESTAMP,
                          created_by VARCHAR(255),
                          last_update TIMESTAMP,
                          last_update_by VARCHAR(255)
);

create sequence seq_backend_user start with 1 increment by 1 NO MINVALUE NO MAXVALUE CACHE 1;

create TABLE user_role (
                           id BIGINT NOT NULL CONSTRAINT user_role_pkey PRIMARY KEY,
                           user_id BIGINT NOT NULL,
                           role VARCHAR(100)
);

create sequence seq_user_role start with 1 increment by 1 NO MINVALUE NO MAXVALUE CACHE 1;

create TABLE branch (
                           id BIGINT NOT NULL,
                           name VARCHAR(255),
                           active BOOLEAN,
                           created TIMESTAMP,
                           created_by VARCHAR(255),
                           last_update TIMESTAMP,
                           last_update_by VARCHAR(255)
);

create sequence seq_branch start with 1 increment by 1 NO MINVALUE NO MAXVALUE CACHE 1;

INSERT INTO backend_user (id, email, password, first_name, last_name, active, created, created_by, last_update, last_update_by)
 VALUES (-1, 'superadmin@skeleton.ro', '$2a$12$xvWBoCPRPUUO74jSCfXjce5jgil.sEK9CJ82ki11K1BiUr5GBhUy6', 'Superadmin', 'Superadmin', true, '2021-09-04 15:12:01.621129', 'superadmin@skeleton.ro', '2021-09-04 15:12:01.621129', 'superadmin@skeleton.ro');

INSERT INTO user_role (id, user_id, role) VALUES (-1, -1, 'ROLE_SUPERADMIN');