CREATE TABLE departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    capacity INT
);

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    title VARCHAR(255),
    photograph_path VARCHAR(255),
    department INT,
    password VARCHAR(255)
);

CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_code VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255),
    description TEXT,
    year INT,
    term INT,
    faculty VARCHAR(255),
    credits INT,
    capacity INT
);

CREATE TABLE course_schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT,
    time DATE,
    day VARCHAR(255),
    room VARCHAR(255),
    building VARCHAR(255)
);

CREATE TABLE specialisation_course(
    id INT AUTO_INCREMENT PRIMARY KEY,
    specialisation_id INT,
    course_id INT
);

CREATE TABLE course_prerequisite(
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT,
    prerequisite INT,
    description TEXT
);

CREATE TABLE specialisation (
    specialisation_id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255),
    description TEXT,
    year INT,
    credits_required INT
);