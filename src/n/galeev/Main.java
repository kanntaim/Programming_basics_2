package n.galeev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String minuend = scanner.nextLine();
    String subtrahend = scanner.nextLine();
    String[] differenceArray = ArraySolution(minuend,subtrahend);
    HashSet differenceCollection = CollectionSolution(minuend,subtrahend);
    System.out.println(Arrays.toString(differenceArray));
    System.out.println(differenceCollection);

    }

    private static String[] ArraySolution(String minuendString, String subtrahendString){
        String[] minuend = minuendString.trim().split(", ");
        String[] subtrahend = subtrahendString.trim().split(", ");
        String[] difference = new String[minuend.length];
        Arrays.sort(minuend);
        Arrays.sort(subtrahend);
        int i =0,j = 0, k = 0;
        while (i<minuend.length && j<subtrahend.length){
            if(minuend[i].compareTo(subtrahend[j])>0){
                j++;
            } else if(minuend[i].compareTo(subtrahend[j])<0) {
                difference[k] = minuend[i];
                i++;
                k++;
            } else if(minuend[i].compareTo(subtrahend[j])==0){
                i++;
            }
        }
        for(Integer t = i; t < minuend.length; t++){
            difference[k] = minuend[t];
            k++;
        }
        return Arrays.copyOfRange(difference,0,k);
    }

    private static HashSet CollectionSolution(String minuendString, String subtrahendString){
        HashSet<String> minuend = new HashSet<>(Arrays.asList(minuendString.trim().split(", ")));
        LinkedList<String> subtrahend = new LinkedList<>(Arrays.asList(subtrahendString.trim().split(", ")));
        minuend.removeAll(subtrahend);
        return minuend;
    }
}

