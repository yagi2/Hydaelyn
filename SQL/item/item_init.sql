\c hydaelyn yagi2

DROP TABLE IF EXISTS item;

CREATE TABLE item
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(64),
    category_id INT,
    can_take BOOLEAN
);

ALTER TABLE item
    OWNER TO yagi2;
