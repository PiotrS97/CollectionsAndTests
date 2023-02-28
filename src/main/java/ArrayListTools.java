/**
 * Class with several methods that facilitate work with Arrays, mostly searching tools, but also methods that
 * are used to calculate average value.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListTools<T>{

    /**
     * Method that search for Integer values in ArrayList using API stream.
     * @param list is an ArrayList that may consist of mixed type elements
     * @return stream of found integers
     */
    public static Stream<Integer> searchForIntegerWithAPIStream(ArrayList list){
        Stream<Integer> integers = list.stream()
                .distinct()
                .filter(l -> l instanceof Integer);
        return integers;
    }

    /**
     * Method that search for Integer values in ArrayList using HashMap.
     * @param list is an ArrayList that may consist of mixed type elements
     * @return list of found Integers
     */
    public static List<Integer> searchForIntegerWithHashmap(ArrayList list){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int hashValue = 0;
        for(Object l : list){
            if(l instanceof Integer){
                if(hashMap.containsKey(l)){
                    hashMap.put((Integer) l,hashValue);
                }
                else {
                    hashMap.put((Integer) l, hashValue);
                    hashValue++;
                }
            }
        }
        return new ArrayList<>(hashMap.keySet());
    }

    /**
     * Method that search for Integer values in ArrayList using method Collections.frequency().
     * @param list is an ArrayList that may consist of mixed type elements
     * @return list of found Integers
     */
    public static List<Integer> searchForIntegerWithCollectionsFrequency(ArrayList list){
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        for(Object o : list){
            if(Collections.frequency(listOfIntegers, o) == 0 && o instanceof Integer){
                listOfIntegers.add((Integer) o);
            }
        }
        return listOfIntegers;
    }

    /**
     * Method that search for Integer values in ArrayList using Set Collection.
     * @param list is an ArrayList that may consist of mixed type elements
     * @return list of found Integers
     */
    public static List<Integer> searchForIntegerWithSet(ArrayList list){
       Set<Integer> setOfIntegers = new HashSet<>();
       for(Object o : list){
           if(o instanceof Integer){
               setOfIntegers.add((Integer) o);
           }
       }
        return new ArrayList<>(setOfIntegers);
    }

    /**
     * Method that search for Integer values in ArrayList with simple for loop and if statement.
     * @param list is an ArrayList that may consist of mixed type elements
     * @return list of found Integers
     */
    public static List<Integer> searchForInteger(ArrayList list){
       List<Integer> listOfIntegers = new ArrayList<>();
        for (Object o : list) {
            if (o instanceof Integer && !listOfIntegers.contains(o)) {
                listOfIntegers.add((Integer) o);
            }
        }
        return listOfIntegers;
    }

    /**
     * Method that search for Strings in mixed type ArrayList that starts with specified letter. It uses API stream
     * for searching those words.
     * @param list is an ArrayList that may consist of mixed type elements
     * @param s is a letter that method uses to find words which starts with it
     * @return it returns found Strings or give message that there are no words that starts with specified letter
     */
    public static String getWordStartingWithLetter(ArrayList list, String s){
        Optional<String> word = list.stream()
                .filter(l -> l != null)
                .filter(l -> l.toString().toUpperCase().startsWith(s.toUpperCase()))
                .findFirst();
        if(word.isPresent()){
            return word.get();
        }
        else{
            return "There is no word that start with letter " + s;
        }
    }

    /**
     * Method calculates average value from Integers found in given ArrayList, using API stream.
     * @param list is an ArrayList that may consist of mixed type elements
     * @return calculated average value (Double type)
     */
    public static double averageValueWithAPIStream(ArrayList list){
        int averageValue = 0;
        long numberOfElements = list.stream()
                .filter(l -> l instanceof Integer)
                .count();
        averageValue = (int) list.stream()
                .filter(l -> l instanceof Integer)
                .collect(Collectors.summingInt(Integer::intValue));
        if(numberOfElements == 0){
            return 0.0;
        }
        else {
            return (double) averageValue / (double) numberOfElements;
        }
    }

    /**
     * Method calculates average value from Integers found in given ArrayList, using simple for loops and if statement.
     * @param list is an ArrayList that may consist of mixed type elements
     * @return calculated average value (Double type)
     */
    public static double averageValue(ArrayList list){
        int averageValue = 0;
        List<Integer> listOfIntegers = new ArrayList<>();
        for (Object o : list) {
            if (o instanceof Integer) {
                listOfIntegers.add((Integer) o);
            }
        }
        for(Integer l : listOfIntegers){
            averageValue += l;
        }
        if(averageValue == 0){
            return 0.0;
        }
        else {
            return (double) averageValue/ listOfIntegers.size();
        }
    }
}
