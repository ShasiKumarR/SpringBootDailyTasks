package com.example.Springbootfirstproject.models;

public class Employee
{
    private int empid;
    private String name;
    private String job;

    public Employee()
    {

    }

    public Employee(int empid, String name, String job)
    {
        this.empid = empid;
        this.name = name;
        this.job = job;
    }

    public int getEmpid()
    {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
