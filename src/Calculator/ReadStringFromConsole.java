package Calculator;

import java.util.Scanner;

public class ReadStringFromConsole {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String stroka = s.nextLine();
        if(stroka.contains(".") || stroka.contains(",")){
            throw new IllegalArgumentException("Только целые числа!");
        }
        boolean arabic_numbers = true;
        int operanda1=0;
        int operanda2=0;
        int result=0;
        String parts[] = stroka.split(" ");
        if (parts.length<3){
            throw new ArrayIndexOutOfBoundsException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        try {
            operanda1 = Integer.parseInt(parts[0]);
            operanda2 = Integer.parseInt(parts[2]);
        }
        catch (NumberFormatException e){
            arabic_numbers = false;
            operanda1=Converter.convertToInt(parts[0]);
            operanda2=Converter.convertToInt(parts[2]);
        }
        if ((operanda1<1 || operanda1>10)||(operanda2<1 || operanda2>10)){
                throw new IllegalArgumentException("Введены некорректные данные");
        }
        String operator = parts[1];
        if (operator.equals("-")) {
            result = operanda1 - operanda2;
        }
        if (operator.equals("+")) {
            result = operanda1 + operanda2;
        }
        if (operator.equals("*")) {
            result = operanda1 * operanda2;
        }
        if (operator.equals("/")) {
            result = operanda1 / operanda2;
        }
        if (arabic_numbers==false){
            if (result<0) {
                throw new IllegalArgumentException("Римское число не может быть отрицательным");
            }
            System.out.println(Converter.convertResultToRomes(result));
        }
        else{
            System.out.println(result);
        }
    }
}





