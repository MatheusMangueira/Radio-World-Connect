Create table radio(
id bigint not null auto_increment,
name varchar(100) not null,
url_radio TEXT not null,
image TEXT,
longitude Double not null,
latitude Double not null,

primary key (id)
)