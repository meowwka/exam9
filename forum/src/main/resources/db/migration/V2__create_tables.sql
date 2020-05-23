use `forum`;

CREATE TABLE `themes`
(
    id int auto_increment not null ,
    date        datetime(6)  not null,
    name        varchar(128) not null,
    description varchar(128) not null,
    user_id     int      not    null,
    PRIMARY KEY (`id`),
    CONSTRAINT `user_id_FK`
        foreign key (`user_id`) references `users` (`id`)
);

CREATE TABLE `comments`
(
    id int auto_increment not null ,
    text         varchar(128) not null,
    comment_date datetime(6)  not null,
    theme_id     int    not      null,
    user_id      int    not      null,
    PRIMARY KEY (`id`),
    CONSTRAINT `theme_fk`
        foreign key (`theme_id`) references `themes` (`id`),
    CONSTRAINT `user_fk`
        foreign key (`user_id`) references `users` (`id`)
);


-- INSERT  INTO `themes` (`name`, `description`, `user_id`)
-- VALUES ('The name of theme ', 'Vestibulum a molestie magna. Curabitur dapibus, dolor volutpat maximus elementum, metus mi tempor nulla,', 1),
--          ('The name of theme Hello', 'vel rhoncus. Nunc quam ante, ullamcorper sed cursus nec, molestie at erat. Cras tristique at ipsum', 1);

