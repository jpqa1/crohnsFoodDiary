drop table if exists food CASCADE;

CREATE TABLE food (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    calories_per_portion DOUBLE NOT NULL,
    effect VARCHAR(255),
    name VARCHAR(255),
    type VARCHAR(255)
)