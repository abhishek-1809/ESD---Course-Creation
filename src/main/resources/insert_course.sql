INSERT INTO departments (name, capacity)
    VALUES
        ('Admin', 10),
        ('Human Resources', 50),
        ('Engineering', 200),
        ('Marketing', 100),
        ('Sales', 150);



INSERT INTO employees (first_name, last_name, email, title, photograph_path, department, password)
    VALUES
        ('John', 'Doe', 'john@gmail.com', 'Manager', '/images/john_doe.jpg', (SELECT department_id FROM departments WHERE name = 'Human Resources'), 'j@123'),
        ('Jane', 'Smith', 'jane@gmail.com', 'Engineer', '/images/jane_smith.jpg', (SELECT department_id FROM departments WHERE name = 'Engineering'), 'j@123'),
        ('Robert', 'Brown', 'robert@gmail.com', 'Marketing Specialist', '/images/robert_brown.jpg', (SELECT department_id FROM departments WHERE name = 'Marketing'), 'r@123'),
        ('Emily', 'Davis', 'emily@gmail.com', 'Sales Representative', '/images/emily_davis.jpg', (SELECT department_id FROM departments WHERE name = 'Sales'), 'e@123'),
        ('Alice', 'Admin', 'alice@gmail.com', 'Administrator', '/images/alice_admin.jpg', (SELECT department_id FROM departments WHERE name = 'Admin'), 'a@123');


INSERT INTO courses (course_code, name, description, year, term, faculty, credits, capacity)
    VALUES
        ('CS101', 'Introduction to Computer Science', 'Learn the basics of computer science.', 2024, 1, 'Computer Sceince', 3, 100),
        ('MKTG101', 'Introduction to Marketing', 'Learn the fundamentals of marketing.', 2024, 1, 'Marketing', 3, 50),
        ('ENGR201', 'Data Structures and Algorithms', 'Deep dive into data structures and algorithms.', 2024, 2, 'Computer Science', 4, 150),
        ('MKTG201', 'Consumer Behavior', 'Study of consumer behavior and psychology in marketing.', 2024, 2, 'Marketing', 3, 80);


INSERT INTO course_schedule (course_id, time, day, room, building)
    VALUES
        (1, '2024-01-10 09:00:00', 'Monday', 'Room 101', 'Engineering Building'),
        (2, '2024-01-11 10:00:00', 'Tuesday', 'Room 201', 'Marketing Building'),
        (3, '2024-02-15 11:00:00', 'Wednesday', 'Room 303', 'Engineering Building'),
        (4, '2024-02-16 12:00:00', 'Thursday', 'Room 404', 'Marketing Building');


INSERT INTO specialisation (code, name, description, year, credits_required)
    VALUES
        ('CS-SW', 'Software Engineering', 'Specialisation in software engineering.', 2024, 20),
        ('CS-DS', 'Data Science', 'Specialisation in data science and machine learning.', 2024, 20),
        ('CS-CB', 'Cyber Security', 'Specialisation in cyber security.', 2024, 20);


INSERT INTO specialisation_course (specialisation_id, course_id)
    VALUES
        (1, 1),  -- Software Engineering takes "Introduction to Computer Science"
        (1, 3),  -- Software Engineering takes "Data Structures and Algorithms"
        (2, 1),  -- Data Science takes "Introduction to Computer Science"
        (2, 3);  -- Data Science takes "Data Structures and Algorithms"
--
INSERT INTO course_prerequisite (course_id, prerequisite, description)
    VALUES
        (3, 1, 'Introduction to Computer Science is a prerequisite for Data Structures and Algorithms.'),
        (4, 2, 'Introduction to Marketing is a prerequisite for Consumer Behavior.');
