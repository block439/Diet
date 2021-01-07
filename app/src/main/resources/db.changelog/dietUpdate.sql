ALTER TABLE preference
    DROP COLUMN calorific_value,
    DROP COLUMN vege,
    DROP COLUMN owner_id,
    ADD COLUMN name VARCHAR (50) NOT NULL;

ALTER TABLE user_preference
    ADD COLUMN value VARCHAR(50) NOT NULL;

CREATE TABLE diet_parameter(
    diet_id BIGINT NOT NULL,
    parameter_id BIGINT NOT NULL,
    value VARCHAR(50) NOT NULL,
    FOREIGN KEY (diet_id) REFERENCES diet(id),
    FOREIGN KEY (parameter_id) REFERENCES parameter(id)
);
