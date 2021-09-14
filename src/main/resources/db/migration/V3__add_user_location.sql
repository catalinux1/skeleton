create TABLE user_location (
                               id BIGINT NOT NULL CONSTRAINT user_location_pkey PRIMARY KEY,
                               user_id BIGINT NOT NULL,
                               location_id BIGINT NOT NULL
);

create sequence seq_user_location start with 1 increment by 1 NO MINVALUE NO MAXVALUE CACHE 1;