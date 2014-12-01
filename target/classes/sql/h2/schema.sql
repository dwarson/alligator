drop table if exists fs_log;
drop table if exists fs_user;
drop table if exists fs_topic;

create table fs_user (
       	id bigint generated by default as identity,
        username varchar(255) not null unique,
        name varchar(64),
        password varchar(255),
        salt varchar(64) not null,
		roles varchar(255) not null,
		register_date timestamp not null,
        remember boolean,
        primary key (id)
);

create table fs_log (
	id bigint generated by default as identity,
	title varchar(128) not null,
	log_type bigint not null,
	description varchar(255),
	start_time timestamp not null,
	end_time timestamp not null,
	user_id bigint not null,
    primary key (id)
);

create table fs_topic (
	id bigint generated by default as identity,
	title varchar(128) not null,
	description varchar(255),
    primary key (id)
);