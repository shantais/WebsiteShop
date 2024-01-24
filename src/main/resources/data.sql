-- inserty dla zniżek
INSERT INTO discount (type_of_discount, discount_value) VALUES
    ('PERCENT', 10.0);

INSERT INTO discount (type_of_discount, discount_value) VALUES
    ('VALUE', 50.0);

-- Inserty dla produktów
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


-- inserty dla warehouse
INSERT INTO warehouse (product_id, quantity) VALUES (1, 50);
INSERT INTO warehouse (product_id, quantity) VALUES (2, 20);
INSERT INTO warehouse (product_id, quantity) VALUES (3, 75);
INSERT INTO warehouse (product_id, quantity) VALUES (4, 10);
INSERT INTO warehouse (product_id, quantity) VALUES (5, 95);
INSERT INTO warehouse (product_id, quantity) VALUES (6, 30);
INSERT INTO warehouse (product_id, quantity) VALUES (7, 80);
INSERT INTO warehouse (product_id, quantity) VALUES (8, 15);
INSERT INTO warehouse (product_id, quantity) VALUES (9, 40);
INSERT INTO warehouse (product_id, quantity) VALUES (10, 60);