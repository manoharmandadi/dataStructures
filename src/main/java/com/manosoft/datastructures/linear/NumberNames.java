package com.manosoft.datastructures.linear;

import java.util.Objects;

public class NumberNames {


    public static void main(String[] args) {
        System.out.println(numberToName(7953426));
    }

    public static String numberToName(int number){
        StringBuffer sb = new StringBuffer();

        int twoDigits = number % 100;
        number = number / 100;

        if(number > 0){
            int hundreds = number % 10;
            number = number/10;
            if(number > 0){
                int thousands = number % 100;
                number = number/100;

                if(number > 0){
                    int lakhs = number % 100;
                    number = number/100;

                    if(number > 0){
                        int crores = number % 100;
                        number = number/100;

                        sb.append(parseTwoDigit(true, crores)+" Lakhs ");
                    }
                    sb.append(parseTwoDigit(true, lakhs)+" Lakhs ");
                }

                sb.append(parseTwoDigit(true, thousands)+" Thousand ");
            }
            sb.append(parseTwoDigit(false, hundreds) +" Hundred ");
        }

        sb.append(parseTwoDigit(true, twoDigits));
        return sb.toString();
    }

    public static String parseTwoDigit(boolean parse2Digits, int number){
        StringBuffer sb = new StringBuffer();
        int ones = number % 10;
        int tens = number / 10;
        if(parse2Digits){
            NamesEnum tensEnum = NamesEnum.getEnum(tens);
            sb.append(tensEnum.getTens()+ " ");
        }
        if(ones!=0){
            sb.append(NamesEnum.getEnum(ones));
        }
        return sb.toString();
    }
}

enum NamesEnum {
    ONE("", 1),
    TWO("Twenty", 2),
    THREE("Thirty", 3),
    FOUR("Forty", 4),
    FIVE("Fifty", 5),
    SIX("Sixty", 6),
    SEVEN("Seventy", 7),
    EIGHT("Eighty", 8),
    NINE("Ninty", 9),
    ZERO("", 0);

    private int num;

    private String tens;

    NamesEnum(String tens, int num) {
        this.tens = tens;
        this.num = num;
    }

    public int getNum(){
        return this.num;
    }

    public String getTens(){
        return this.tens;
    }

    public static NamesEnum getEnum(int num){
        for(NamesEnum namesEnum : values()){
            if(Objects.equals(namesEnum.getNum(), num)){
                return namesEnum;
            }
        }
        return NamesEnum.ZERO;
    }

}