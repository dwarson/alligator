  drop table if exists fs_log;
  drop table if exists fs_user;

 create table fs_user (
       	id bigint generated by default as identity,
        username varchar(255) not null unique,
        name varchar(64),
        password varchar(255),
        remember boolean
);

create table fs_log (
	id bigint generated by default as identity,
	title varchar(128) not null,
	log_type varchar(255) not null,
	description varchar(255),
	start_time timestamp not null,
	end_time timestamp not null,
	user_id bigint not null,
    primary key (id)
);