use `forum`;

CREATE TABLE themes
(
    id int auto_increment primary key,
    date        datetime(6)  null,
    name        varchar(128) null,
    description varchar(128) null,
    user_id     int          null,
    CONSTRAINT user_id_FK
        foreign key (user_id) references users (id)
);

CREATE TABLE comments
(
    id int auto_increment primary key,
    text         varchar(128) null,
    comment_date datetime(6)  null,
    theme_id     int          null,
    user_id      int          null,
    CONSTRAINT theme_fk
        foreign key (theme_id) references themes (id),
    CONSTRAINT user_fk
        foreign key (user_id) references users (id)
);


