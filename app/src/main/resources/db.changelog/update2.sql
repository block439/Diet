ALTER  TABLE users
DROP COLUMN role;
ALTER  TABLE users
ADD COLUMN role VARCHAR(15) NOT NULL DEFAULT 'STANDARD';