ALTER TABLE meal_diet
    DROP COLUMN weeknumber,
    ADD COLUMN daynumber BIGINT,
    ADD COLUMN meal_number BIGINT
    ;
