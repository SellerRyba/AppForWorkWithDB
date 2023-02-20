-- add employees
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES 
('John Smith', '1990-05-20', 'Trainee', 800),
('Mary Johnson', '1985-11-15', 'Junior', 1200),
('Mark Brown', '1978-03-10', 'Senior', 6000),
('Anna Lee', '1995-07-02', 'Middle', 3000),
('David Kim', '1980-01-01', 'Middle', 4000),
('Sarah Jones', '1993-09-05', 'Trainee', 900),
('Robert Davis', '1992-04-25', 'Senior', 7000),
('Emily Wilson', '1988-12-10', 'Junior', 1500),
('James Anderson', '1982-06-15', 'Middle', 3500),
('Jessica Taylor', '1991-02-28', 'Junior', 1100);

-- add clients
INSERT INTO client (NAME) VALUES 
('ABC Inc.'),
('XYZ Corporation'),
('Acme Co.'),
('Delta Ltd.'),
('Global Corp.');

-- add projects
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES 
(1, '2021-01-01', '2021-06-30'),
(2, '2021-02-15', '2022-02-14'),
(3, '2021-04-01', '2021-09-30'),
(4, '2021-05-15', '2022-05-14'),
(5, '2021-07-01', '2021-12-31'),
(1, '2021-08-15', '2022-08-14'),
(2, '2021-10-01', '2022-03-31'),
(3, '2021-11-15', '2022-11-14'),
(4, '2022-01-01', '2022-06-30'),
(5, '2022-03-15', '2023-03-14');

-- assigned employees to projects
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES 
(1, 1),
(1, 2),
(1, 3),
(2, 3),
(2, 4),
(3, 1),
(3, 5),
(3, 6),
(4, 2),
(4, 4),
(4, 7),
(4, 8),
(5, 3),
(5, 6),
(5, 9),
(6, 1),
(6, 2),
(6, 4),
(7, 5),
(7, 6),
(8, 7),
(8, 8),
(9, 3),
(9, 9),
(9, 10),
(10, 1),
(10, 2),
(10, 5),
(10, 7),
(10, 10);
