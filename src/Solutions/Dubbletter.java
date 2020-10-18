package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Skriv en funktion som tar bort alla dubbletter från en lista. Behåll den första
//        förekomsten av ett värde i listan. Välj Integer som listtypen.
//        Exempel:
//        Om listan från början innehåller värdena 1, 3, 2, 2, 3, 2, 1, 4 så ska den
//        efteråt innehålla 1, 3, 2, 4 (i denna ordning).
public class Dubbletter {
    public static void main(String[] args) {
        Integer[] originalArray = new Integer[] {1, 3, 2, 2, 3, 2, 1, 4};
        List<Integer> original = Arrays.asList(originalArray);
        List<Integer> removed = doubleLetterRemover(original);
        System.out.println(removed);
    }

    public static List<Integer> doubleLetterRemover(List<Integer> original){
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
}
