CREATE TYPE clothingType AS ENUM('headwear', 'midSection', 'lowerSection', 'accessory', 'footwear');

CREATE TABLE IF NOT EXISTS accounts
(
    userId serial,
    gender VARCHAR(15),
    zipcode integer,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY(userId) 
);

CREATE TABLE IF NOT EXISTS clothing
(
    cid serial,
    price numeric(15,6),
    siteLink text,
    isAdult bool,
    genderPref VARCHAR(15),
    title text NOT NULL,
    img text,
    itemType text NOT NULL,
    PRIMARY KEY(cid)
);

CREATE TABLE IF NOT EXISTS outfit
(
    outfitID serial,
    headwear integer REFERENCES clothing ON DELETE CASCADE,
    lowerSection integer REFERENCES clothing ON DELETE CASCADE, 
    midSection integer REFERENCES clothing ON DELETE CASCADE, 
    footwear integer REFERENCES clothing ON DELETE CASCADE, 
    accessory integer REFERENCES clothing ON DELETE CASCADE,
    PRIMARY KEY(outfitID)
);


CREATE TABLE IF NOT EXISTS savesClothing
(
    cid integer REFERENCES clothing(cid),
    userId integer REFERENCES accounts,
    createdAt TIMESTAMP NOT NULL,
    PRIMARY KEY(cid, userId)
);

CREATE TABLE IF NOT EXISTS savesOutfit
(
    outfitId integer REFERENCES outfit ON DELETE CASCADE,
    userId integer REFERENCES accounts,
    createdAt TIMESTAMP NOT NULL,
    PRIMARY KEY(outfitId, userId)
);
