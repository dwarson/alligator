drop table if exists fs_user;
drop table if exists fs_log;
drop table if exists fs_topic;
drop table if exists fs_thought;
drop table if exists fs_action;
drop table if exists fs_bible_book;
drop table if exists fs_bible_chapter;
drop table if exists fs_user_chapter_record;
drop table if exists fs_bible_verse;
drop table if exists fs_pray;
drop table if exists fs_link;

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

create table fs_thought (
	id bigint generated by default as identity,
	title varchar(128) not null,
	thought_type bigint not null,
	description varchar(255),
	user_id bigint not null,
	actionable boolean,
	outcome varchar(255),
    primary key (id)
);

create table fs_action (
	id bigint generated by default as identity,
	title varchar(128) not null,
	action_type varchar(128) not null,
	context varchar(128) not null,
	urgency varchar(128) not null,
	energy varchar(128) not null,
	priority varchar(128) not null,
	description varchar(255),
	thought_id bigint not null,
	user_id bigint not null,
    primary key (id)
);

create table fs_bible_book (
	id bigint generated by default as identity,
	title varchar(128) not null,
	author varchar(128) not null,
	book_time varchar(128) not null,
	book_type bigint not null,
	description varchar(255),
    primary key (id)
);

create table fs_bible_chapter (
	id bigint generated by default as identity,
	book_id bigint not null,
	title bigint not null,
	status bigint,
	description varchar(255),
    primary key (id)
);

create table fs_bible_verse (
	id bigint generated by default as identity,
	chapter_id bigint not null,
	title bigint not null,
	content_en varchar(255),
	content_cn varchar(255),
	status bigint not null,
	description varchar(255),
    primary key (id)
);

create table fs_user_chapter_record (
	user_id bigint not null,
	chapter_id bigint not null,
	status bigint not null,
	notes varchar(511),
    primary key (user_id,chapter_id)
);

create table fs_pray (
	id bigint generated by default as identity,
	content varchar(511) not null,
	pray_type bigint not null,
	notes varchar(511),
	start_time timestamp not null,
	update_time timestamp not null,
	status bigint not null,
	user_id bigint not null,
    primary key (id)
);

create table fs_link (
	id bigint generated by default as identity,
	title varchar(128) not null,
	url varchar(255),
	link_type bigint not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
);