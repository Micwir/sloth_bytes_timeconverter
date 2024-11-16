package org.micwir;

import org.micwir.exception.WrongTimeFormatException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        TimeConverter converter = new TimeConverter();
        while(!exit){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")){
                exit = true;
            } else {
                try{
                    System.out.println(converter.convert(input));
                } catch (WrongTimeFormatException e){
                    System.out.println(e.getMessage());
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
