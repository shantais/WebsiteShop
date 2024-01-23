CREATE TABLE discount (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          typeOfDiscount ENUM('percent', 'value') NOT NULL,
                          discount DECIMAL NOT NULL
);