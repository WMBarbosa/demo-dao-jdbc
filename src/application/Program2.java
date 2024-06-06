package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== TEST 1: seller findAll ====");
        List<Department> departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("\n==== TEST 2: seller findAll ====");
        Department department = departmentDao.findByID(1);
        System.out.println(department);

        System.out.println("\n==== TEST 4: seller insert ====");
        Department dep = new Department(null, "T.I");
        departmentDao.insert(dep);
        System.out.println("Inserted Completed!");

        System.out.println("\n==== TEST 5: seller update ====");
        department = departmentDao.findByID(3);
        department.setName("Gaming");
        departmentDao.update(department);
        System.out.println("Updated Completed!");

        System.out.println("\n==== TEST 6: seller delete ====");
        System.out.print("Enter id for delete test: ");
        var id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deleted Completed!");

    }
}
