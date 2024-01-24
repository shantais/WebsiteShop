INSERT INTO discount (type_of_discount, discount_value) VALUES
    ('PERCENT', 10.0);

INSERT INTO discount (type_of_discount, discount_value) VALUES
    ('VALUE', 50.0);

-- Dodaj przykładowe gry komputerowe z przypisanymi zniżkami
INSERT INTO product (name, category, price, discount_id) VALUES
    ('The Witcher 3', 'Gry Komputerowe', 59.99, 1);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('Cyberpunk 2077', 'Gry Komputerowe', 49.99, 2);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('Assassin''s Creed Valhalla', 'Gry Komputerowe', 69.99, 1);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('DOOM Eternal', 'Gry Komputerowe', 39.99, 2);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('FIFA 22', 'Gry Komputerowe', 59.99, 1);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('Minecraft', 'Gry Komputerowe', 29.99, 2);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('World of Warcraft', 'Gry Komputerowe', 49.99, 1);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('Overwatch', 'Gry Komputerowe', 39.99, 2);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('The Elder Scrolls V: Skyrim', 'Gry Komputerowe', 39.99, 1);

INSERT INTO product (name, category, price, discount_id) VALUES
    ('Stardew Valley', 'Gry Komputerowe', 14.99, 2);