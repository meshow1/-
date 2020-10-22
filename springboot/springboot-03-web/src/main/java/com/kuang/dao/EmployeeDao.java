package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDao {
    //模拟数据
    private static Map<Integer, Employee> employees = null;
    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();//创建部门表

        employees.put(101, new Employee(1001, "A1", "111111@qq.com",1, new Department(101,"教学部1")));
        employees.put(101, new Employee(1002, "A2", "222222@qq.com",0, new Department(102,"教学部2")));
        employees.put(101, new Employee(1003, "A3", "333333@qq.com",1, new Department(103,"教学部3")));
        employees.put(101, new Employee(1004, "A4", "444444@qq.com",0, new Department(104,"教学部4")));
    }

    //主键自增
    private static Integer initId=1006;

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
