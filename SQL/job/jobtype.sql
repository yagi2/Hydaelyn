\c hydaelyn yagi2

DROP TABLE IF EXISTS job_type;

CREATE TABLE job_type
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(64)
);

ALTER TABLE job_type
    OWNER TO yagi2;

INSERT INTO job_type(id, name)
    VALUES
        (1, 'バトルクラス'),
        (2, 'バトルジョブ'),
        (3, 'クラフター'),
        (4, 'ギャザラー')