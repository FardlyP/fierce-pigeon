-- DROP DATABASE IF EXISTS fiercepigeon;
CREATE DATABASE fiercepigeon;

-- public.game_info definition

-- Drop table

DROP TABLE IF EXISTS public.game_info;

CREATE TABLE public.game_info (
                                  id serial NOT NULL,
                                  gym varchar(40) NOT NULL,
                                  site_no int4 NOT NULL,
                                  num int4 NULL DEFAULT 0,
                                  declaration varchar(255) NULL,
                                  done int4 NULL DEFAULT 0,
                                  update_time timestamp NULL,
                                  create_time timestamp NULL,
                                  creator varchar(40) NULL,
                                  "date" date NULL,
                                  "time" varchar(40) NULL,
                                  CONSTRAINT game_info_pk PRIMARY KEY (id)
);

-- public.play_info definition

-- Drop table

DROP TABLE IF EXISTS public.play_info;

CREATE TABLE public.play_info (
                                  id serial NOT NULL,
                                  game_id int4 NOT NULL,
                                  open_id varchar(40) NOT NULL,
                                  zan_cnt int4 NULL DEFAULT 0,
                                  you_cnt int4 NULL DEFAULT 0,
                                  update_time timestamp NULL,
                                  create_time timestamp NULL,
                                  deleted int4 NULL,
                                  CONSTRAINT play_info_pk PRIMARY KEY (id)
);

-- public.user_info definition

-- Drop table

DROP TABLE IF EXISTS public.user_info;

CREATE TABLE public.user_info (
                                  id serial NOT NULL,
                                  nickname varchar(40) NOT NULL,
                                  create_time timestamp NULL,
                                  open_id varchar(30) NULL,
                                  CONSTRAINT user_info_pk PRIMARY KEY (id)
);