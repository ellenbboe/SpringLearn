package com.site.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "file")
public class FileEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String filename;
    private long size;
    private String fileuri;
    private Integer ownerId;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getFileuri() {
        return fileuri;
    }

    public void setFileuri(String fileuri) {
        this.fileuri = fileuri;
    }
}
