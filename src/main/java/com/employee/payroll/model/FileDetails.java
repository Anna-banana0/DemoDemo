package com.employee.payroll.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file_details")
@NoArgsConstructor
@Setter
@Getter
public class FileDetails {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "status")
    private String status;

    public FileDetails(String fileName, String status) {
        this.fileName = fileName;
        this.status = status;
    }
}
