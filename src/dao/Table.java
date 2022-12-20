/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author kshit
 */
public class Table {

    public static void main(String[] args) {
        try {
//            String userTable = "create table user(id int AUTO_INCREMENT Primary Key,name varchar(200), email varchar(200) UNIQUE, mobileNumber varchar(10), address varchar(200), password varchar(200), securityQuestion varchar(200), answer varchar(200), status varchar(20))";
//            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status)values('Admin','admin@gmail.com','1234567890','Nepal','admin','What is the number between 44 ad 46?','45','true')";
//            String categoryTable = "create table category(id int AUTO_INCREMENT Primary Key, name varchar(200))";
//            String productTable = "create table product(id int AUTO_INCREMENT Primary Key, name varchar(200), category varchar(200), price varchar(200) )";
            String billTable = "create table bill(id int Primary Key, name varchar(200), mobileNumber varchar(200), email varchar(200), date varchar(200), total varchar(200), createdBy varchar(200))";

//            DbOperation.setDataOrDelete(userTable, "User Table is Created Successfully!!");
//            DbOperation.setDataOrDelete(adminDetails, "Admin Details is Added Succefully!!");
//            DbOperation.setDataOrDelete(categoryTable, "Category Table is Created Succefully!!");
//            DbOperation.setDataOrDelete(productTable, "Product Table is Created Succefully!!");
            DbOperation.setDataOrDelete(billTable, "Bill Table is Created Succefully!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
