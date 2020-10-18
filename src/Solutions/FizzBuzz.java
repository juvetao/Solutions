package Solutions;

import java.util.ArrayList;

//Skriv ett program som skriver ut numren 1 till 100 till konsolen. Men:
//        • om ett nummer är jämnt delbart med tre skriv ut “Fizz” istället för
//        numret.
//        • om ett nummer är jämnt delbart med fem skriv ut “Buzz” istället för
//        numret.
//        • om ett nummer är jämnt delbart med tre och fem skriv ut “FizzBuzz”
//        istället för numret.
public class FizzBuzz {
    //create an array
    public static void main(String[] args) {
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

    }
}
