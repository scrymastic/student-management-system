
CREATE TABLE accounts (
    username varchar(45) NOT NULL,
    password varchar(45) NOT NULL,
    is_admin bit NOT NULL DEFAULT 0,
    PRIMARY KEY (username)
);

INSERT INTO accounts (username, password, is_admin) VALUES ('admin', 'admin', 1);



