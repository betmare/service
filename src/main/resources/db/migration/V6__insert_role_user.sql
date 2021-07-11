INSERT INTO role (id, code, name, description) VALUES
(1, 'CLI', 'Cliente', 'Usuario Cliente'),
(2, 'VEN', 'Vendedor', 'Usuario Vendedor');

INSERT INTO service.user (email, firstname, middle_name, lastname, mobile, phone_home, phone_office, birthdate, role_id) VALUES
('client@test.com', 'Pedro', 'Alejandro', 'Perez', '60898723', '24167898', '25352345', '1991-09-07', 1),
('seller@test.com', 'Mercedes', 'Paola', 'Mendoza', '60893663', '24134648', '25353455', '1987-04-13', 2);