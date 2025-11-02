package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {


    @Test
    void 로또_가격에_숫자가_아닌_문자를_입력한_경우() {
        String input1 = "-122";
        String input2 = "0191";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertFalse(input1.matches(regex));
        Assertions.assertFalse(input2.matches(regex));
    }

    @Test
    void 로또_가격을_정상적으로_입력한_경우() {
        String input1 = "1222";
        String input2 = "11";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertTrue(input1.matches(regex));
        Assertions.assertTrue(input2.matches(regex));
    }

    @Test
    void 로또_가격이_1000원으로_나눴을_때_나머지가_있는_경우() {
        String input1 = "3250";
        String input2 = "333";
        String input3 = "1320";
        Assertions.assertNotEquals(0, (Integer.parseInt(input1) % 1000));
        Assertions.assertNotEquals(0, (Integer.parseInt(input2) % 1000));
        Assertions.assertNotEquals(0, (Integer.parseInt(input3) % 1000));
    }

    @Test
    void 로또_가격이_1000원으로_나눴을_때_나머지가_0_정상적인_경우() {
        String input1 = "4000";
        String input2 = "30000";
        String input3 = "1000";
        Assertions.assertEquals(0, (Integer.parseInt(input1) % 1000));
        Assertions.assertEquals(0, (Integer.parseInt(input2) % 1000));
        Assertions.assertEquals(0, (Integer.parseInt(input3) % 1000));
    }

    @Test
    void 당첨_번호에_형식이_잘못된_경우() {
        String regex = "^\\d+(,\\d+){5}$";
        String input1 = "1,2,3,4,5";
        String input2 = "1,2,3,4,5,6,7";
        String input3 = "1,2$3,4,5";
        String input4 = "1, 2, 3, 4, 5";
        Assertions.assertFalse(input1.matches(regex));
        Assertions.assertFalse(input2.matches(regex));
        Assertions.assertFalse(input3.matches(regex));
        Assertions.assertFalse(input4.matches(regex));
    }

    @Test
    void 당첨_번호에_형식이_올바르게_입력한_경우() {
        String regex = "^\\d+(,\\d+){5}$";
        String input1 = "1,2,3,4,5,6";
        String input2 = "33,44,25,32,3232,100000";
        Assertions.assertTrue(input1.matches(regex));
        Assertions.assertTrue(input2.matches(regex));
    }

    @Test
    void 당번_번호의_숫자가_1부터_45_범위가_아닌_경우() {
        List<Integer> numberList = List.of(1, 0, 3, 47, 111, 22);
        boolean result = numberList.stream().anyMatch(num ->
                (num < 1) || (num > 45));
        Assertions.assertTrue(result);
    }

    @Test
    void 당번_번호의_모든_숫자가_1부터_45_범위_내에_있는_경우() {
        List<Integer> numberList = List.of(1, 44, 3, 33, 22, 15);
        boolean result = numberList.stream().anyMatch(num ->
                (num < 1) || (num > 45));
        Assertions.assertFalse(result);
    }

    @Test
    void 당첨_번호_숫자가_중복된_경우() {
        List<Integer> numberList = List.of(1, 44, 3, 33, 1, 15);
        Set<Integer> numberSet = new HashSet<>(numberList);
        Assertions.assertNotEquals(numberSet.size(), numberList.size());
    }

    @Test
    void 당첨_번호_숫자가_중복이_없는_경우() {
        List<Integer> numberList = List.of(1, 44, 3, 33, 55, 15);
        Set<Integer> numberSet = new HashSet<>(numberList);
        Assertions.assertEquals(numberSet.size(), numberList.size());
    }

    @Test
    void 보너스_번호_형식이_잘못된_경우(){
        String regex = "^(0|[1-9]\\d)$";
        String userInput1 = "-32";
        String userInput2 = "3.2";
        String userInput3 = "032";
        String userInput4 = "3 2";
        Assertions.assertFalse(userInput1.matches(regex));
        Assertions.assertFalse(userInput2.matches(regex));
        Assertions.assertFalse(userInput3.matches(regex));
        Assertions.assertFalse(userInput4.matches(regex));
    }

    @Test
    void 보너스_번호_형식이_맞게_입력된_경우(){
        String regex = "\\d+";
        String userInput1 = "33";
        String userInput2 = "123";
        String userInput3 = "55";
        String userInput4 = "3333";
        Assertions.assertTrue(userInput1.matches(regex));
        Assertions.assertTrue(userInput2.matches(regex));
        Assertions.assertTrue(userInput3.matches(regex));
        Assertions.assertTrue(userInput4.matches(regex));
    }

    @Test
    void 보너스_번호의_숫자가_1부터_45_범위가_아닌_경우(){
        String input = "54";
        Assertions.assertTrue(Integer.parseInt(input) <1 ||
                Integer.parseInt(input) >45);
    }

    @Test
    void 보너스_번호의_숫자가_1부터_45_범위_내에_있는_경우 (){
        String input1 = "44";
        String input2 = "1";
        Assertions.assertFalse(Integer.parseInt(input1) <1 ||
                Integer.parseInt(input1) >45);
        Assertions.assertFalse(Integer.parseInt(input2) <1 ||
                Integer.parseInt(input1) >45);
    }


}
