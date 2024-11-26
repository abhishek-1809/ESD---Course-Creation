ALTER TABLE employees
    ADD CONSTRAINT FK_employees_departments
        FOREIGN KEY (department) REFERENCES departments(department_id);

ALTER TABLE course_schedule
    ADD CONSTRAINT FK_courseschedule_courses
        FOREIGN KEY (course_id) REFERENCES courses(course_id);

ALTER TABLE specialisation_course
    ADD CONSTRAINT FK_specialisationcourse_specialisaion
        FOREIGN KEY (specialisation_id) REFERENCES specialisation(specialisation_id),
    ADD CONSTRAINT FK_specialisationcourse_courses
        FOREIGN KEY (course_id) REFERENCES courses(course_id);

ALTER TABLE course_prerequisite
    ADD CONSTRAINT FK_courseprerequisite_courses
        FOREIGN KEY (course_id) REFERENCES courses(course_id),
    ADD CONSTRAINT FK_courseprerequisite_course
        FOREIGN KEY (prerequisite) REFERENCES courses(course_id);