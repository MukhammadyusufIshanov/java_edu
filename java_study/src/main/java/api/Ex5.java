package api;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Реализовать консольное приложение, которое:
//1. Принимает от пользователя и “запоминает” строки.
//2. Если введено print, выводит строки так, чтобы последняя введенная
//была первой в списке, а первая - последней.
//3. Если введено revert, удаляет предыдущую введенную строку из памяти.

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> str = new LinkedList<String>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
            if (input.equals("print")) {
                for (int i = str.size() - 1; i >= 0; i--) {
                    System.out.println(str.get(i));
                }
            } else if (input.equals("revert")) {
                str.removeLast();
            } else{
                str.add(input);
            }
        }
    }
    }

