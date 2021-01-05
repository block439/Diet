DELETE FROM auction_parameter;
DELETE FROM photo;
DELETE FROM auction;
DELETE FROM users;
DELETE FROM category;
DELETE FROM parameter;
DELETE FROM department;


ALTER  TABLE users
ADD COLUMN diet_id BIGINT NOT NULL;

CREATE TABLE preference
(
    id              BIGINT  NOT NULL,
    calorific_value BIGINT  NOT NULL,
    vege            BOOlEAN NOT NULL,
    owner_id        BIGINT  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_preference(
    user_id BIGINT NOT NULL,
    preference_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (preference_id) REFERENCES preference(id)
);

CREATE TABLE diet
(
    id BIGINT NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE meal (
    id BIGINT NOT NULL,
    meal_name VARCHAR(50) NOT NULL,
    recipe VARCHAR (200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE meal_diet(
    diet_id BIGINT NOT NULL,
    meal_id BIGINT NOT NULL,
    weekNumber  BIGINT NOT NULL,
    FOREIGN KEY (diet_id) REFERENCES diet (id),
    FOREIGN KEY (meal_id) REFERENCES meal(id)
);

CREATE TABLE product(
    id BIGINT NOT NULL,
    productName VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE meal_product(
    meal_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    amount NUMERIC(5,3) NOT NULL DEFAULT 1.000,
    FOREIGN KEY (meal_id) REFERENCES meal (id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);



CREATE TABLE mealPhoto
(
    id         BIGINT       NOT NULL,
    url        VARCHAR(100) NOT NULL,
    meal_id BIGINT       NOT NULL,
    FOREIGN KEY (meal_id) REFERENCES meal (id),
    PRIMARY KEY (id)
);



CREATE TABLE productPhoto
(
    id         BIGINT       NOT NULL,
    url        VARCHAR(100) NOT NULL,
    product_id BIGINT       NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id),
    PRIMARY KEY (id)
);