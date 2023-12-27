
CREATE TABLE accounts (
    username varchar(45) NOT NULL,
    hashed_password varchar(64) NOT NULL,
    is_admin bit NOT NULL DEFAULT 0,
    PRIMARY KEY (username)
);

INSERT INTO accounts (username, hased_password, is_admin) VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1);
INSERT INTO accounts (username, hashed_password, is_admin) VALUES ('guest', '84983c60f7daadc1cb8698621f802c0d9f9a3c3c295c810748fb048115c186ec', 0);



