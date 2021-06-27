CREATE TABLE TWEET_INFO (
    ID SERIAL           PRIMARY KEY,
    TWEET_ID            BIGINT,
    TEXT                VARCHAR(280) NOT NULL,
    USERNAME            VARCHAR(50),
    LANGUAGE            VARCHAR(50),
    LOCATION            VARCHAR(50),
    FAVOURITE_COUNT     INT,
    CREATION_DATE       TIMESTAMP NOT NULL
);