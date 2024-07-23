
use payroll_management_system;
Create Table Admins(
UserName varchar(20) Primary KEY,
Password varchar(20)

);

insert into Admins (UserName,Password) values("Faizan","027");
insert into Admins (UserName,Password) values("Khaqan","039");
insert into Admins (UserName,Password) values("Areeb","021");


CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(100) NOT NULL
    
);
CREATE TABLE Grade (
    grade_id INT PRIMARY KEY,
    grade_name VARCHAR(100) NOT NULL,
    grade_basic INT NOT NULL,
    grade_travel_allowance INT NOT NULL,
    grade_house_rent_allowance INT NOT NULL,
    grade_medical_allowance INT NOT NULL,
    grade_bonus INT NOT NULL,
    grade_professional_tax INT NOT NULL
);

CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_title VARCHAR(100) NOT NULL,
    emp_name VARCHAR(100) NOT NULL,
    emp_date_of_birth DATE NOT NULL,
    emp_date_of_joining DATE NOT NULL,
    emp_address VARCHAR(100) NOT NULL,
	emp_mobile_no VARCHAR(15) NOT NULL,
    emp_mail_id VARCHAR(100) NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Role(role_id)
);

CREATE TABLE Employee_Grade_Details (
    transaction_id INT PRIMARY KEY,
    emp_id INT,
    emp_dept_id INT,
    emp_grade_id INT,
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id),
    FOREIGN KEY (emp_dept_id) REFERENCES Department(dept_id),
    FOREIGN KEY (emp_grade_id) REFERENCES Grade(grade_id)
);


CREATE TABLE Employee_Salary_Details (
    transaction_id INT PRIMARY KEY,
    emp_id INT,
    emp_salary_month VARCHAR(10) NOT NULL,
    emp_dept_id INT,
    emp_grade_id INT,
    emp_basic INT,
    emp_travel_allowance INT,
    emp_house_rent_allowance INT,
    emp_medical_allowance INT,
    emp_bonus INT,
    emp_professional_tax INT,
    emp_gross_salary INT,
    emp_total_salary INT,
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id),
    FOREIGN KEY (emp_dept_id) REFERENCES Department(dept_id),
    FOREIGN KEY (emp_grade_id) REFERENCES Grade(grade_id)
);


CREATE TABLE Role (
    role_id INT PRIMARY KEY,
    role_title VARCHAR(100) UNIQUE NOT NULL,
    role_basic_salary DECIMAL(10,2) NOT NULL
);
-- Sample Data

INSERT INTO Department (dept_id, dept_name) VALUES
(1, 'Human Resources'),
(2, 'Finance'),
(3, 'Marketing'),
(4, 'Sales'),
(5, 'Information Technology');


INSERT INTO Role (role_id, role_title, role_basic_salary) VALUES
(1, 'HR Coordinator', 60000),
(2, 'Manager', 80000),
(3, 'Financial Analyst', 70000),
(4, 'Software Developer', 90000),
(5, 'Sales Executive', 65000);


INSERT INTO Grade (grade_id, grade_name, grade_basic, grade_travel_allowance, grade_dearness_allowance, grade_house_rent_allowance, grade_medical_allowance, grade_bonus, grade_provident_fund, grade_professional_tax) VALUES
(1, 'Junior HR Coordinator', 40000, 5000, 2000, 4000, 3000, 1000, 2000, 500),
(2, 'Senior HR Coordinator', 65000, 7000, 3000, 6000, 4000, 1500, 2500, 700),
(3, 'Junior Financial Analyst', 50000, 6000, 2500, 5000, 3500, 1200, 2200, 600),
(4, 'Senior Financial Analyst', 75000, 8000, 3500, 7000, 5000, 2000, 3000, 1000),
(5, 'Junior Software Developer', 60000, 7000, 3000, 5500, 4000, 1500, 2500, 700);


INSERT INTO Employee (emp_id, emp_title, emp_name, emp_date_of_birth, emp_date_of_joining, emp_address, emp_mobile_no, emp_mail_id, role_id) VALUES
(6, 'Manager', 'Faizan Mustafa', '2003-06-25', '2020-08-15', ' Canttonment St, Okara', '0300-9876543', 'faizan.mustafa@example.com', 2),
(7, 'HR Coordinator', 'Khaqan Nasir', '2004-09-12', '2021-07-01', 'Murhi Mandi St, Okara', '0312-1234567', 'khaqan.nasir@example.com', 1),
(8, 'Financial Analyst', 'Areeb Akram', '2005-11-08', '2022-05-20', 'Potato St, Lahore', '0321-7654321', 'areeb.akram@example.com', 3),
(9, 'Software Developer', 'Sana Khan', '2001-04-30', '2024-03-10', '567 MNO St, Islamabad', '0344-8765432', 'sana.khan@example.com', 4);


INSERT INTO Employee_Grade_Details (transaction_id, emp_id, emp_dept_id, emp_grade_id) VALUES
(6, 6, 5, 2),
(7, 7, 1, 1),
(8, 8, 2, 3),
(9, 9, 4, 4);


INSERT INTO Employee_Salary_Details (transaction_id, emp_id, emp_salary_month, emp_dept_id, emp_grade_id, emp_basic, emp_travel_allowance, emp_house_rent_allowance, emp_medical_allowance, emp_bonus, emp_professional_tax, emp_gross_salary, emp_total_salary) VALUES
(6, 6, 'May 2024', 5, 2, 80000, 8000, 6000, 5000, 2000, 1500, 100000, 95000),
(7, 7, 'May 2024', 1, 1, 60000, 5000, 4000, 3000, 1000, 500, 75000, 70000),
(8, 8, 'May 2024', 2, 3, 70000, 6000, 5000, 3500, 1200, 600, 85000, 80000),
(9, 9, 'May 2024', 4, 4, 90000, 8000, 7000, 5000, 2000, 1000, 120000, 115000);


DELIMITER $$

CREATE TRIGGER trg_after_insert_employee_grade
AFTER INSERT ON Employee_Grade_Details
FOR EACH ROW
BEGIN
    DECLARE v_grade_basic INT;
    DECLARE v_travel_allowance INT;
    DECLARE v_house_rent_allowance INT;
    DECLARE v_medical_allowance INT;
    DECLARE v_bonus INT;
    DECLARE v_professional_tax INT;
    DECLARE v_gross_salary INT;
    DECLARE v_total_salary INT;

    -- Fetch grade details for the inserted employee grade id
    SELECT grade_basic, grade_travel_allowance, grade_house_rent_allowance, grade_medical_allowance, grade_bonus, grade_professional_tax
    INTO v_grade_basic, v_travel_allowance, v_house_rent_allowance, v_medical_allowance, v_bonus, v_professional_tax
    FROM Grade
    WHERE grade_id = NEW.emp_grade_id;

    -- Calculate the gross and total salary
    SET v_gross_salary = v_grade_basic + v_travel_allowance + v_house_rent_allowance + v_medical_allowance + v_bonus;
    SET v_total_salary = v_gross_salary - v_professional_tax;

    -- Insert the calculated values into Employee_Salary_Details
    INSERT INTO Employee_Salary_Details (emp_id, emp_salary_month, emp_dept_id, emp_grade_id, emp_basic, emp_travel_allowance, emp_house_rent_allowance, emp_medical_allowance, emp_bonus, emp_professional_tax, emp_gross_salary, emp_total_salary)
    VALUES (NEW.emp_id, 'MonthPlaceholder', NEW.emp_dept_id, NEW.emp_grade_id, v_grade_basic, v_travel_allowance, v_house_rent_allowance, v_medical_allowance, v_bonus, v_professional_tax, v_gross_salary, v_total_salary);
END$$

DELIMITER ;

