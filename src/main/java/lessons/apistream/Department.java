package lessons.apistream;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String department;
    private List<Employee> employees;

    public Department() { }

    public Department(String department, List<Employee> employees) {
        this.department = department;
        this.employees = employees;
    }


    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((department == null) ? 0 : department.hashCode());
        result = prime * result + ((employees == null) ? 0 : employees.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Department other = (Department) obj;
        if (department == null) {
            if (other.department != null)
                return false;
        } else if (!department.equals(other.department))
            return false;
        if (employees == null) {
            if (other.employees != null)
                return false;
        } else if (!employees.equals(other.employees))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Department [ department = " + department + ", employees = " + employees + " ]";
    }

    
}
