CREATE TABLE IF NOT EXISTS PHOTOS (
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  FILENAME VARCHAR(255) NOT NULL,
  CONTENT_TYPE VARCHAR(255) NOT NULL,
  DATA BLOB NOT NULL
);