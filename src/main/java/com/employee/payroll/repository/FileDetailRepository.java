package com.employee.payroll.repository;

import com.employee.payroll.model.FileDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FileDetailRepository extends JpaRepository<FileDetails,Long> {
    @Query("SELECT f.status FROM FileDetails f  where f.file_name =:file_name")
    String findStatusByFileName(String fileName);
}
