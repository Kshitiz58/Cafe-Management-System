/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kshit
 */
public class UserDao {

    //For Signup Form 
    public static void save(User user) {
        String query = "insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','" + user.getStatus() + "')";
        DbOperation.setDataOrDelete(query, "Registered Successfully!! Please Wait for Admin Approval!!!");
    }

    //For Login Form
    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperation.getData("select * from user where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;

    }

    //For Forget Password
    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperation.getData("select * from user where email = '" + email + "'   ");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;

    }

    //Update Password
    public static void update(String email, String newPassword) {
        String query = "update user set password='" + newPassword + "' where email = '" + email + "'";
        DbOperation.setDataOrDelete(query, "Your Password is Changed Successfuly!!");

    }

    //Verify Users
    public static ArrayList<User> getALLRecords(String email) {
        ArrayList<User> arrrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperation.getData("select * from user where email like '%" + email + "%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrrayList.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrrayList;
    }

    //Update from Verify User
    public static void changeStatus(String email, String status) {
        String query = "update user set status ='" + status + "' where email = '" + email + "' ";
        DbOperation.setDataOrDelete(query, "Your Status is Changed Successfully!!");

    }

    //Change Password
    public static void changePassword(String email, String oldPassword, String newPassword) {
        try {
            ResultSet rs = DbOperation.getData("select * from user where  email= '" + email + "' and password = '" + oldPassword + "'");
            if (rs.next()) {
                update(email, newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Old Password is Wrong!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //Change Security Question
    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {
        try {
            ResultSet rs = DbOperation.getData("select * from user where email ='"+email+"' and password ='"+password+"'");
            if(rs.next()){
                update(email, securityQuestion, answer);
            }else{
                JOptionPane.showMessageDialog(null, "Your Password is Wrong!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void update(String email, String securityQuestion, String answer){
        String query = "update user set securityQuestion='"+securityQuestion+"', answer = '"+answer+"' where email = '"+email+"'";
        DbOperation.setDataOrDelete(query, "Your Security Question is Changed Successfully!!");
        
    }

}
