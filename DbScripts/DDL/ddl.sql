###################################################################
# Added by Amit
#####################################################################
create table department
(
    department_id smallint(4) not null
        primary key,
    department_name varchar(10) not null
);

create table employee
(
    employee_id varchar(10) not null
        primary key,
    employee_name varchar(50) not null,
    employee_address varchar(100) not null,
    employee_dob datetime not null,
    employee_email varchar(45) not null,
    employee_account_number bigint(15) not null,
    employee_designation varchar(15) not null,
    structure_id varchar(10) not null,
    department_id smallint(4) not null,
    constraint department_id
        foreign key (department_id) references department (department_id)
);

create index department_id_idx
	on employee (department_id);

create table payroll
(
    transaction_id varchar(15) not null
        primary key,
    employee_id varchar(10) not null,
    payroll_month tinyint(2) not null,
    payable_days tinyint(2) not null,
    total_days tinyint(2) not null,
    constraint employee_id
        foreign key (employee_id) references employee (employee_id)
);

create index employee_id_idx
	on payroll (employee_id);

create table salary_structure
(
    structure_id varchar(10) not null
        primary key,
    head varchar(10) not null,
    amount double not null,
    is_percentage bit not null,
    is_deduction double not null
);

