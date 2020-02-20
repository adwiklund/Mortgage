/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Mortgage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    
     public static void main(String[] args) {

        List<Prospects> prospectList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("prospects.txt"));

            String fileRead = br.readLine();
            fileRead = br.readLine();
            
            while(fileRead != null) {
                String[] token = fileRead.split(",");
                int tokenCount = fileRead.split(",").length;

                String customer;
                float loan;
                float interest;
                int years;

                if(tokenCount < 4) {

                    break;
                } 
                try {
                    customer = token[0];
                    loan = Float.parseFloat(token[1]);
                    interest = Float.parseFloat(token[2]);
                    years = Integer.parseInt(token[3]);
                } catch (NumberFormatException e) {
                    customer = token[0]+ " " + token[1];
                    customer = customer.substring(1, customer.length()-1);
                    loan = Float.parseFloat(token[2]);
                    interest = Float.parseFloat(token[3]);
                    years = Integer.parseInt(token[4]);

                }
                Prospects prospect = new Prospects(customer, loan, interest, years);
                
                prospectList.add(prospect);
                fileRead = br.readLine();
             
            } 
            br.close();
        }
        
        catch(FileNotFoundException f) {
            System.out.println("File not found");
        }
        catch(IOException i) {
            i.printStackTrace();
        }
        
        for(Prospects each : prospectList) {
            System.out.println(each);
        }

    }
    
}