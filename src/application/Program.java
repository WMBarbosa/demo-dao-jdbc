package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1: seller findyId ====");
        Seller seller = sellerDao.findByID(3);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: seller findyByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n==== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n==== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n==== TEST 5: seller update ====");
        seller = sellerDao.findByID(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n==== TEST 6: seller delete ====");
        System.out.print("Enter id for delete test: ");
        var id = leitura.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted completed!");

        leitura.close();
    }
}
