package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestSQLInjection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            String url = "jdbc:mysql://192.168.10.127:3306/dac86?useSSL=false";
            Connection conn = DriverManager.getConnection(url, "dac86", "welcome");
            Statement st = conn.createStatement();
            int ch = 0;
            do {
                System.out.println("Enter user name: ");
                String user = sc.next();
                System.out.println("Enter Password: ");
                String password = sc.next();

                if (checkPassword(password)) {
                    System.out.println("You can't enter quotes or commas.");
                } else {
                	String query = "select * from user where username= '"+user+"'and password= '"+password+"'";
                	ResultSet rs = st.executeQuery(query);
					
					if(rs.next()) {
						System.out.println(query);
						System.out.println("\n\n\t----------------------------------------------------------");
						System.out.println("\t| UserNames \t|\t Passwords \t|\t Roles\t |");
						System.out.println("\t|---------------|-----------------------|----------------|");
						
						do{
							System.out.println("\t| "+rs.getString(1)+ "\t\t|\t"+rs.getString(2)+ "\t|\t"+ rs.getString(3)+"\t |");
						}while(rs.next());
						
						System.out.println("\t|---------------|-----------------------|----------------|");
					} else {
                        System.out.println("\n\t\tWrong username and password.");
                    }
                    do {
                        System.out.println("\nDo you want to continue? (1 for Yes, 0 for No):");
                        ch = sc.nextInt();
                        if (ch != 1 && ch != 0)
                            System.out.println("Invalid input. Please enter 1 for Yes or 0 for No.");
                    } while (ch != 1 && ch != 0);
                }
            } while (ch == 1); 
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static boolean checkPassword(String password) {
        return password.contains("'") || password.contains("\"") || password.contains(",");
    }
}