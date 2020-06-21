-- H2データベース上でテーブルを作成するSQL
CREATE TABLE IF NOT EXISTS employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(50),
    age INT
);