package com.example.ecommerce;

import java.sql.ResultSet;

public class Login {

    public Customer customerLogin(String userName, String password){
        String query = "SELECT * FROM customer WHERE email = '"+userName+"' AND password = '"+password+"'";
        DbConnection connection = new DbConnection();
        try{
            ResultSet rs = connection.getQueryTable(query);
            if(rs.next()){
                return new Customer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        Login login = new Login();
        Customer customer = login.customerLogin("ravikumar23091998@gmail.com","abc23");
        System.out.println("Welcome :  "+customer.getName());
    }
}
