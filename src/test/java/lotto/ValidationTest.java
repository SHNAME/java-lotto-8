package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {


    @Test
    void 로또_가격에_숫자가_아닌_문자를_입력한_경우(){
        String input1 = "-122";
        String input2 = "0191";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertFalse(input1.matches(regex));
        Assertions.assertFalse(input2.matches(regex));
    }

    @Test
    void 로또_가격을_정상적으로_입력한_경우(){
        String input1 = "1222";
        String input2 = "11";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertTrue(input1.matches(regex));
        Assertions.assertTrue(input2.matches(regex));
    }

    @Test
    void 로또_가격이_1000원으로_나눴을_때_나머지가_있는_경우(){
        String input1 = "3250";
        String input2 = "333";
        String input3 = "1320";
        Assertions.assertNotEquals(0, (Integer.parseInt(input1) % 1000));
        Assertions.assertNotEquals(0, (Integer.parseInt(input2) % 1000));
        Assertions.assertNotEquals(0, (Integer.parseInt(input3) % 1000));
    }

    @Test
    void 로또_가격이_1000원으로_나눴을_때_나머지가_0_정상적인_경우(){
        String input1 = "4000";
        String input2 = "30000";
        String input3 = "1000";
        Assertions.assertEquals(0, (Integer.parseInt(input1) % 1000));
        Assertions.assertEquals(0, (Integer.parseInt(input2) % 1000));
        Assertions.assertEquals(0, (Integer.parseInt(input3) % 1000));
    }

    @Test
    void 당첨_번호에_형식이_잘못된_경우(){
        String regex ="^\\d+(,\\d+){5}$";
        String input1 = "1,2,3,4,5";
        String input2 ="1,2,3,4,5,6,7";
        String input3 = "1,2$3,4,5";
        String input4 = "1, 2, 3, 4, 5";
        Assertions.assertFalse(input1.matches(regex));
        Assertions.assertFalse(input2.matches(regex));
        Assertions.assertFalse(input3.matches(regex));
        Assertions.assertFalse(input4.matches(regex));
    }

    @Test
    void 당첨_번호에_형식이_올바르게_입력한_경우(){
        String regex ="^\\d+(,\\d+){5}$";
        String input1 = "1,2,3,4,5,6";
        String input2 = "33,44,25,32,3232,100000";
        Assertions.assertTrue(input1.matches(regex));
        Assertions.assertTrue(input2.matches(regex));
    }


}
