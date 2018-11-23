package com.studnet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Column(name = "name")
    private String sname;

    @Id
    @Column(name = "id")
    private Integer sid;

    @Column(name = "age")
    private Integer sage;

    public StudentEntity(){

    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public void setSage(int sage) {
        this.sage = sage;
    }
}
