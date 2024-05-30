CREATE TABLE IF NOT EXISTS tb_role (
                                       role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_user (
                                       user_id CHAR(36) NOT NULL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       email VARCHAR(255) NOT NULL UNIQUE,
                                       password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_user_role (
                                            user_id CHAR(36) NOT NULL,
                                            role_id BIGINT NOT NULL,
                                            PRIMARY KEY (user_id, role_id),
                                            FOREIGN KEY (user_id) REFERENCES tb_user(user_id) ON DELETE CASCADE,
                                            FOREIGN KEY (role_id) REFERENCES tb_role(role_id) ON DELETE CASCADE
);
