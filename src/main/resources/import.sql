INSERT INTO USER(email, password) VALUES('test', 'test1234');

INSERT INTO CATEGORY(name) VALUES('의류');
INSERT INTO BRAND(name) VALUES('A 브랜드');

INSERT INTO ITEM(id, category_id, brand_id, name, price, discount_rate, discount_price, stock, created_date) VALUES(1, 1, 1, '반팔 티셔츠', 10000, 10, 9000, 100, CURRENT_TIMESTAMP), (2, 1, 1, '자켓', 18000, null, null, 500, CURRENT_TIMESTAMP), (3, 1, 1, '상품3654', 5000, null, null, 500, CURRENT_TIMESTAMP), (4, 1, 1, '상품23776', 45000, 5, 42750, 250, CURRENT_TIMESTAMP), (5, 1, 1, '반바지', 20000, 20, 16000, 100, CURRENT_TIMESTAMP), (6, 1, 1, '자켓2', 38000, null, null, 500, CURRENT_TIMESTAMP), (7, 1, 1, '상품1223', 12000, null, null, 500, CURRENT_TIMESTAMP), (8, 1, 1, '맨투맨', 30000, 20, 24000, 300, CURRENT_TIMESTAMP), (9, 1, 1, '후드반팔', 23000, null, null, 300, CURRENT_TIMESTAMP), (10, 1, 1, '티셔츠', 15000, null, null, 500, CURRENT_TIMESTAMP);

