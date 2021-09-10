create TABLE location (
                          id BIGINT NOT NULL,
                          name VARCHAR(255),
                          id_branch BIGINT NOT NULL,
                          active BOOLEAN,
                          created TIMESTAMP,
                          created_by VARCHAR(255),
                          last_update TIMESTAMP,
                          last_update_by VARCHAR(255)
);

create sequence seq_location start with 1 increment by 1 NO MINVALUE NO MAXVALUE CACHE 1;