 #################################################################
-- ### Server version:                 5.7
-- ### Date (DD-MM-YYYY):      12-08-2021
-- ### Developer Name:   Ani
-- ### Comments:
-- 1.Updated the invalid employee class
-- #################################################################
CREATE TABLE `invalid_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(225) DEFAULT NULL,
  `employee_name` varchar(225) DEFAULT NULL,
  `employee_address` varchar(225) DEFAULT NULL,
  `employee_dob` varchar(225) DEFAULT NULL,
  `employee_email` varchar(225) DEFAULT NULL,
  `employee_account_number` varchar(225) DEFAULT NULL,
  `employee_designation` varchar(225) DEFAULT NULL,
  `structure_id` varchar(225) DEFAULT NULL,
  `department_name` varchar(225) DEFAULT NULL,
  `errors` text,
  PRIMARY KEY (`id`));