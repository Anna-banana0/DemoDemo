package com.employee.payroll.handler;

import com.employee.payroll.exception.ResourceNotFoundException;
import com.employee.payroll.model.SalaryStructure;
import com.employee.payroll.repository.SalaryStructureRepository;
import com.employee.payroll.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalStructureHandlerImpl implements SalaryStructureHandler {

    @Autowired
    SalaryStructureRepository gradeRepository;
    @Autowired
    RepositoryService service;

    public void setGrade(SalaryStructure grade){
        service.setGrade(grade);
    }

    public List<SalaryStructure> getGrades(){
        return service.getGrades();
    }

    public void editGrade(SalaryStructure grade){

        SalaryStructure gradeList = gradeRepository.getById(grade.getStructureId());
        if(gradeList == null){
            throw new ResourceNotFoundException("SalaryStructure not found in the database");
        }
        service.editGrade(grade);
    }
    public void deleteGrade(SalaryStructure grade){
        service.deleteGrade(grade);
    }
}
