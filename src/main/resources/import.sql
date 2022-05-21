INSERT INTO USER(email, password) VALUES('test', 'test1234');

INSERT INTO CATEGORY(name) VALUES('의류');
INSERT INTO BRAND(name) VALUES('A 브랜드');

INSERT INTO ITEM(id, category_id, brand_id, name, price, discount_rate, discount_price, stock, created_date) VALUES(1, 1, 1, '반팔 티셔츠', 10000, 10, 9000, 100, CURRENT_TIMESTAMP), (2, 1, 1, '자켓', 18000, null, null, 500, CURRENT_TIMESTAMP);

