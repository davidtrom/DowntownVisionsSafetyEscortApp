package com.zipcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UploadedFile {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;

    public UploadedFile() {
    }

    public UploadedFile(Long id, String fileName) {
        this.id=id;
        this.fileName=fileName;
    }

    public UploadedFile(String fileName) {
        this.fileName=fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}


