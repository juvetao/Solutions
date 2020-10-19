package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        System.out.println("FizzBuzz");
        fizzBuzz();
        System.out.println("---------------------");

        System.out.println("Dubbletter");
        Integer[] originalArray = new Integer[] {1, 3, 2, 2, 3, 2, 1, 4};
        List<Integer> original = Arrays.asList(originalArray);
        System.out.println("Original list: " + original);
        List<Integer> removed = doubleLetter(original);
        System.out.println("After cleaning: " + removed);
        System.out.println("---------------------");

        System.out.println("Rövarspråket");
        StringBuilder inputSvenska = new StringBuilder("Hej på dig!");
        System.out.println("Svenska: " + inputSvenska);
        StringBuilder translatedToRovarspraket = rovarspraket(inputSvenska);
        System.out.println("Rövarspråket:" + translatedToRovarspraket);
        System.out.println("---------------------");

        System.out.println("Rövarspråket 2");
        StringBuilder inputRovarspraket = new StringBuilder("Hohejoj popå dodigog!");
        System.out.println("Rövarspråket: " + inputRovarspraket);
        StringBuilder translatedToSvenska = rovarspraketTwo(inputRovarspraket);
        System.out.println("Svenska: " + translatedToSvenska);
        System.out.println("---------------------");

        System.out.println("Riskorn");
        int antal = 1000000;
        System.out.println("result: " + whatSquare(antal));
    }


    //Uppgift FizzBuzz
    public static ArrayList<String> fizzBuzz(){
        ArrayList<Integer> nums = new ArrayList<Integer>(); //Skapa en arraylist att spara numer från 1 till 100 som Integer typ
        for (int i = 1; i<= 100; i++){
            nums.add(i);
        }
        System.out.println("Original ArrayList: "+ nums);
        ArrayList<String> numStrings = new ArrayList<String>(); //Skapa en annan arraylist att transfer alla data i arraylist nums från Integer till String typ
        for(int j = 0; j< nums.size(); j++){
            numStrings.add(""); // I början lämnas samma storlek som arraylist nums till numStrings
        }
        for (int k =0; k< nums.size(); k++){
            if(nums.get(k)%3 != 0 && nums.get(k)%5 !=0 ){ // om ett nummer är inte jämnt delbart med tre eller fem skriv ut nummmer som String typ.
                numStrings.set(k, nums.get(k).toString());
            } else if(nums.get(k)%3 ==0 && nums.get(k)%5 !=0){ //om ett nummer är jämnt delbart med tre skriv ut “Fizz” istället för numret
                numStrings.set(k, "Fizz");
            } else if(nums.get(k)%3 !=0 && nums.get(k)%5 ==0){ //om ett nummer är jämnt delbart med fem skriv ut “Buzz” istället för numret.
                numStrings.set(k, "Buzz");
            } else if(nums.get(k)%3 ==0 && nums.get(k)%5 ==0){ //om ett nummer är jämnt delbart med tre och fem skriv ut “FizzBuzz istället för numret.
                numStrings.set(k, "FizzBuzz");
            }
        }
        System.out.println("ArrayList after FizzBuzz: "+ numStrings);
        return numStrings;
    }

    //Uppgift Dubbletter
    public static List<Integer> doubleLetter(List<Integer> original){
        List<Integer> removed = new ArrayList<>();
        int number = 0; //Initialize a tempo number
        for(int i=0; i< original.size(); i++){
            if(original.get(i) != number && !removed.contains(original.get(i))){ // Om ett element i original arraylist inte lika med temop number och inte läggas till removed arraylist
                removed.add(original.get(i)); // och då lägga elementet i removed arraylist
                number = original.get(i); // och sen förandra number till elementet att jämföra med nästa element
            }
        }
        return removed;
    }

    //Upggfit Rövarspråket
    public static StringBuilder rovarspraket(StringBuilder input){
        StringBuilder translated = new StringBuilder(" ");
        for(int i = 0; i<input.length(); i++){
            //Om input.charAt(i) tillhör alphabet, kontrollera om det är en vokal eller konsonant (för både lowercase och uppercase)
            if((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i)>='A' && input.charAt(i)<='Z') ){
                if(input.charAt(i) == 'a' || input.charAt(i) == 'A'
                        || input.charAt(i) == 'e' || input.charAt(i) == 'E'
                        || input.charAt(i) == 'i' || input.charAt(i) == 'I'
                        || input.charAt(i) == 'o' || input.charAt(i)== 'O'
                        || input.charAt(i) == 'u' || input.charAt(i) == 'U'
                        || input.charAt(i) == 'ö' || input.charAt(i) == 'Ö'
                        || input.charAt(i) == 'ä' || input.charAt(i) == 'Ä'
                        || input.charAt(i) == 'å' || input.charAt(i) == 'Å'){
                    translated = translated.append(input.charAt(i)); // lägga(kopiera) bara bokstaven om den är en vokal
                } else { // lägga(kopiera) bokstaven samt o och en samma bokstav till (måste bli lowercase)
                    translated = translated.append(input.charAt(i));
                    translated = translated.append('o');
                    translated = translated.append(Character. toLowerCase(input.charAt(i)));
                }
            }else { // om input.charAt(i) inte tillhör alphabet, exempelvis " " eller en interpunktion, lägga(kopiera) bara input.charAt(i) till
                translated = translated.append(input.charAt(i));
            }
        }
        return translated;
    }

    //Uppgift Rövarspråket 2
    public static StringBuilder rovarspraketTwo(StringBuilder input){
        StringBuilder translated = new StringBuilder(" ");
        for(int i = 0; i<input.length(); i++){
            //Om en bokstav är 'o' och bokstaven innan den och efter den är lika (ignore case), då är den en signal för Rövarspråket, och bokstaven samt en efter den måste borttas
            if(input.charAt(i) == 'o' && Character.toLowerCase(input.charAt(i-1)) == Character.toLowerCase(input.charAt(i+1))){
                input.delete(i, i+1);
            }else{ // Annars lägga(kopiera) bokstaven till en ny stringbuilder, translated
                translated = translated.append(input.charAt(i));
            }
        }
        return translated;
    }

    //Uppgift Riskorn
    public static int whatSquare(int antal){
        int square = 0;
        for(int i = 0; i<64; i++){ // ett schackbräde har 64 rutor
            if(Math.pow(2, i) > antal){ // hitta först ruta nummer(en tempo num i början) med som kan "2 to the power" och högre än antalet
                square = i; //då kopiera den till ruta nummer
                return square;
            }
        }
        return square;
    }
}
