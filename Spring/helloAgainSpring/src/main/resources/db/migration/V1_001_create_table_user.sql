create table TB_USER(
    id integer NOT NULL AUTO_INCREMENT,
    username varchar(200) not null,
    password varchar(200) not null ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;