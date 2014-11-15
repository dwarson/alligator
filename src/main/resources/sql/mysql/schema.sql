drop table if exists fs_user;

create table fs_user (
	id bigint auto_increment,
	username varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
 	remember boolean,
	primary key (id)
) engine=InnoDB;