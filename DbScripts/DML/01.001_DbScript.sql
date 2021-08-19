-- #################################################################
-- ### Server version:                 5.7
-- ### Date (DD-MM-YYYY):      12-08-2021
-- ### Developer Name:   Ani
-- ### Comments:
-- 1.Added the id field in salary_structure table and made it primary key
-- #################################################################
ALTER TABLE `salary_structure`
ADD COLUMN `id` SMALLINT(2) NOT NULL AFTER `is_deduction`,
CHANGE COLUMN `is_deduction` `is_deduction` BIT(1) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`);