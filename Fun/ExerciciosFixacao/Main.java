package ExerciciosFixacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String path = sc.nextLine();
        System.out.println("Enter salary: ");
        double salary = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0],fields[1],
                 Double.parseDouble(fields[2])));
                line = br.readLine();
            } 


            System.out.println("Email of people whose salary is more than "+ salary + ":");

            List<String> emails = list.stream()
            .filter(x -> x.getSalary() > salary)
            .map(x -> x.getEmail())
            .sorted().toList();

            emails.forEach(System.out::println);

            double salaryM = list.stream()
            .filter(x ->  x.getName().charAt(0)    == 'M')
            .mapToDouble(x -> x.getSalary())
            .sum(); 
            
            System.out.println("Sum of salary of people whose name starts with 'M' " 
            + String.format("%.2f", salaryM));
           
            
        
          

       


    }catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        sc.close();
    }
    
}

