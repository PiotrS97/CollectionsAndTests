/**
 * Testing class which is testing methods implemented in ArrayListTools class.
 */

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ArrayList tools should: ")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayListToolsTest {

    @Test
    @Order(1)
    @DisplayName("search for Integer in the ArrayList with API stream")
    public void shouldSearchForIntegerWithAPISStream() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list3.add("Jan");
        list3.add(null);
        list3.add('D');
        List<Integer> expectedList1 = Arrays.asList(5, 7, 9);
        List<Integer> expectedList2 = new ArrayList<>();
        //when
        List<Integer> listOfIntegers1 = ArrayListTools.searchForIntegerWithAPIStream(list1).collect(Collectors.toList());
        List<Integer> listOfIntegers2 = ArrayListTools.searchForIntegerWithAPIStream(list2).collect(Collectors.toList());
        List<Integer> listOfIntegers3 = ArrayListTools.searchForIntegerWithAPIStream(list3).collect(Collectors.toList());
        //then
        assertAll("found distinct Integers",
                () -> assertEquals(expectedList1, listOfIntegers1),
                () -> assertEquals(expectedList2, listOfIntegers2),
                () -> assertEquals(expectedList2, listOfIntegers3)
        );
    }

    @Test
    @Order(2)
    @DisplayName("search for Integer in the ArrayList using HashMap")
    public void shouldSearchForIntegerWithHashMap() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list3.add("Jan");
        list3.add(null);
        list3.add('D');
        List<Integer> expectedList1 = Arrays.asList(5, 7, 9);
        List<Integer> expectedList2 = new ArrayList<>();
        //when
        List<Integer> listOfIntegers1 = ArrayListTools.searchForIntegerWithHashmap(list1);
        List<Integer> listOfIntegers2 = ArrayListTools.searchForIntegerWithHashmap(list2);
        List<Integer> listOfIntegers3 = ArrayListTools.searchForIntegerWithHashmap(list3);
        //then
        assertAll("found distinct Integers",
                () -> assertEquals(expectedList1, listOfIntegers1),
                () -> assertEquals(expectedList2, listOfIntegers2),
                () -> assertEquals(expectedList2, listOfIntegers3)
        );
    }

    @Test
    @Order(3)
    @DisplayName("search for Integer in the ArrayList using Collections.frequency()")
    public void shouldSearchForIntegerWithCollectionsFrequency() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list3.add("Jan");
        list3.add(null);
        list3.add('D');
        List<Integer> expectedList1 = Arrays.asList(5, 7, 9);
        List<Integer> expectedList2 = new ArrayList<>();
        //when
        List<Integer> listOfIntegers1 = ArrayListTools.searchForIntegerWithCollectionsFrequency(list1);
        List<Integer> listOfIntegers2 = ArrayListTools.searchForIntegerWithCollectionsFrequency(list2);
        List<Integer> listOfIntegers3 = ArrayListTools.searchForIntegerWithCollectionsFrequency(list3);
        //then
        assertAll("found distinct Integers",
                () -> assertEquals(expectedList1, listOfIntegers1),
                () -> assertEquals(expectedList2, listOfIntegers2),
                () -> assertEquals(expectedList2, listOfIntegers3)
        );
    }

    @Test
    @Order(4)
    @DisplayName("search for Integer in the ArrayList using Set")
    public void shouldSearchForIntegerWithSet() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list3.add("Jan");
        list3.add(null);
        list3.add('D');
        List<Integer> expectedList1 = Arrays.asList(5, 7, 9);
        List<Integer> expectedList2 = new ArrayList<>();
        //when
        List<Integer> listOfIntegers1 = ArrayListTools.searchForIntegerWithSet(list1);
        List<Integer> listOfIntegers2 = ArrayListTools.searchForIntegerWithSet(list2);
        List<Integer> listOfIntegers3 = ArrayListTools.searchForIntegerWithSet(list3);
        //then
        assertAll("found distinct Integers",
                () -> assertEquals(expectedList1, listOfIntegers1),
                () -> assertEquals(expectedList2, listOfIntegers2),
                () -> assertEquals(expectedList2, listOfIntegers3)
        );
    }

    @Test
    @Order(5)
    @DisplayName("search for Integer in the ArrayList")
    public void shouldSearchForInteger() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list3.add("Jan");
        list3.add(null);
        list3.add('D');
        List<Integer> expectedList1 = Arrays.asList(5, 7, 9);
        List<Integer> expectedList2 = new ArrayList<>();
        //when
        List<Integer> listOfIntegers1 = ArrayListTools.searchForInteger(list1);
        List<Integer> listOfIntegers2 = ArrayListTools.searchForInteger(list2);
        List<Integer> listOfIntegers3 = ArrayListTools.searchForInteger(list3);
        //then
        assertAll("found distinct Integers",
                () -> assertEquals(expectedList1, listOfIntegers1),
                () -> assertEquals(expectedList2, listOfIntegers2),
                () -> assertEquals(expectedList2, listOfIntegers3)
        );
    }

    @Test
    @Order(6)
    @DisplayName("search for words that start with specified letter")
    public void shouldGetWordsThatStartsWithLetter() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        String letter1 = "j";
        String letter2 = "w";
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add("Jacek");
        list1.add("Adam");
        list1.add("java");
        list3.add(1);
        list3.add(9);
        list3.add(null);
        //when
        String word1 = ArrayListTools.getWordStartingWithLetter(list1, letter1);
        String word2 = ArrayListTools.getWordStartingWithLetter(list2, letter1);
        String word3 = ArrayListTools.getWordStartingWithLetter(list1, letter2);
        String word4 = ArrayListTools.getWordStartingWithLetter(list3, letter1);
        //then
        assertAll("found Strings that start with letter " + letter1,
                () -> assertEquals("Jan", word1),
                () -> assertEquals("There is no word that start with letter " + letter1, word2),
                () -> assertEquals("There is no word that start with letter " + letter2, word3),
                () -> assertEquals("There is no word that start with letter " + letter1, word4)
        );
    }

    @Test
    @Order(7)
    @DisplayName("allow calculating average value of Integers in the ArrayList using API stream")
    public void shouldCalculateAverageValueOfIntegersWithAPIStream() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add(5);
        list1.add(7);
        list1.add(-1);
        list2.add(-8);
        list3.add(5.5);
        list3.add("Jan");
        list3.add(-8.4);
        //when
        String averageValue1 = String.format("%.2f", ArrayListTools.averageValueWithAPIStream(list1));
        String averageValue2 = String.format("%.2f", ArrayListTools.averageValueWithAPIStream(list2));
        String averageValue3 = String.format("%.2f", ArrayListTools.averageValueWithAPIStream(list3));
        //then
        assertAll("calculated average value ",
                () -> assertEquals("4,00", averageValue1),
                () -> assertEquals("-8,00", averageValue2),
                () -> assertEquals("0,00", averageValue3)
        );
    }

    @Test
    @Order(8)
    @DisplayName("allow calculating average value of Integers in the ArrayList")
    public void shouldCalculateAverageValueOfIntegers() {
        //given
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list1.add(5);
        list1.add("Jan");
        list1.add(6.5);
        list1.add(5);
        list1.add(7);
        list1.add(-1);
        list2.add(-4);
        list3.add(5.5);
        list3.add("Jan");
        list3.add(-8.4);
        //when
        String averageValue1 = String.format("%.2f", ArrayListTools.averageValue(list1));
        String averageValue2 = String.format("%.2f", ArrayListTools.averageValue(list2));
        String averageValue3 = String.format("%.2f", ArrayListTools.averageValue(list3));
        //then
        assertAll("calculated average value ",
                () -> assertEquals("4,00", averageValue1),
                () -> assertEquals("-4,00", averageValue2),
                () -> assertEquals("0,00", averageValue3)
        );
    }

}