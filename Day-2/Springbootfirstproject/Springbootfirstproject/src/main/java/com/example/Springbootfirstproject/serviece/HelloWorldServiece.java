package com.example.Springbootfirstproject.serviece;

import com.example.Springbootfirstproject.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

//Employee emp = new Employee();



@Service
public class HelloWorldServiece
{
    ArrayList<Employee> e = new ArrayList<>(
            Arrays.asList(new Employee(1,"prasanth","Trainer"),
                    new Employee(2,"Sumo","therla")
            )
    );

    public void setvalue(Employee emp)
    {
        e.add(emp);
    }

    public ArrayList<Employee> getallEmp()
    {
        return e;
    }

    public String get()
    {
        return "Hello World from serviece get method";
    }

    public String post()
    {
        return "Hello World from Serviece  post method ";
    }

    public String put()
    {
        return "Hello World from Serviece  put method ";
    }

    public String del()
    {
        return "Hello World from Serviece  delete method ";
    }

}

