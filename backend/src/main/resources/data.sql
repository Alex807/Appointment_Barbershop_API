INSERT INTO client (name, email, phone) VALUES
                                        ('Alex Burada', 'alex.burada@gmail.com', '0721234567'),
                                        ('Maria Popescu', 'maria.popescu@yahoo.com', '0734567890'),
                                        ('Ion Georgescu', 'ion.georgescu@gmail.com', '0745678901'),
                                        ('Ana Marinescu', 'ana.marinescu@outlook.com', '0756789012'),
                                        ('Mihai Ionescu', 'mihai.ionescu@gmail.com', '0767890123'),
                                        ('Elena Stoica', 'elena.stoica@yahoo.com', '0778901234'),
                                        ('Cristian Radu', 'cristian.radu@gmail.com', '0789012345'),
                                        ('Diana Popa', 'diana.popa@hotmail.com', '0790123456');

INSERT INTO barbershop (name, city, street, street_no, phone) VALUES
                                       ('Classic Cuts', 'Bucharest', 'Calea Victoriei', 15, '0212345678'),
                                       ('Modern Style Barbershop', 'Cluj-Napoca', 'Strada Memorandumului',  28, '0264123456'),
                                       ('Gentlemen''s Corner', 'Timisoara', 'Bulevardul Revolutiei',  7, '0256789012'),
                                       ('The Barber Shop', 'Iasi', 'Strada Stefan cel Mare',  45, '0232456789'),
                                       ('Elite Cuts', 'Constanta', 'Bulevardul Mamaia',  103, '0241567890'),
                                       ('Royal Barbershop', 'Brasov', 'Strada Republicii',  22, '0268234567'),
                                       ('Urban Cuts', 'Craiova', 'Calea Unirii',  89, '0251345678'),
                                       ('Premium Barbers', 'Galati', 'Strada Domneasca',  12, '0236678901');

INSERT INTO barber (name, speciality, years_of_experience, phone, barbershop_id) VALUES
                                        ('Tony Stark', 'Classic cuts', 3, '555-2001', 1),
                                        ('Bruce Wayne', 'Modern styles', 2, '555-2002', 1),
                                        ('Peter Parker', 'Beard trimming', 1, '555-2003', 2),
                                        ('Mihai Morar', 'haircuts', 0, '555-2001', 3),
                                        ('Traian Blantz', 'buzcut', 3, '555-2002', 5),
                                        ('Peter MGL', 'Beard shape', 10, '555-2003', 6);

INSERT INTO appointment (scheduled_date, service, price, client_id, barber_id, barbershop_id) VALUES
                                        ('2025-10-16 11:00:00', 'Haircut + Beard', 35.00, 2, 1, 1),
                                        ('2025-10-16 14:00:00', 'Haircut', 25.00, 3, NULL, 2),
                                        ('2025-10-16 10:00:00', 'Haircut', 25.00, 1, NULL, 1),
                                        ('2025-10-17 09:00:00', 'Beard trim', 15.00, 1, 3, 2);