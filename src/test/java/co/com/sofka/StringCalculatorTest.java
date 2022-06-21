package co.com.sofka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class StringCalculatorTest {

    public StringCalculator stringCalculatorInstance = new StringCalculator();

    @Test
    @DisplayName("El string es vacío y se retorna cero")
    void emptyStringTest() throws Exception {
        String evaluatedString = "";
        var numericValue = stringCalculatorInstance.add(evaluatedString);

        Assertions.assertEquals(0, numericValue);
    }

    @Test
    @DisplayName("Si hay un número, se retorna el valor")
    void singleNumberReturnItsValueTest() throws Exception {

        String evaluatedString = "2";
        var numericValue = stringCalculatorInstance.add(evaluatedString);

        String evaluatedString2 = "1";
        var numericValue2 = stringCalculatorInstance.add(evaluatedString2);

        Assertions.assertEquals(2, numericValue);
        Assertions.assertEquals(1, numericValue2);
    }

    @Test
    @DisplayName("Dos números separados por coma se suman")
    void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {

        String evaluatedString = "0,2";
        var numericValue = stringCalculatorInstance.add(evaluatedString);

        String evaluatedString2 = "1,1";
        var numericValue2 = stringCalculatorInstance.add(evaluatedString2);

        String evaluatedString3 = "1,2";
        var numericValue3 = stringCalculatorInstance.add(evaluatedString3);

        Assertions.assertEquals(2, numericValue);
        Assertions.assertEquals(2, numericValue2);
        Assertions.assertEquals(3, numericValue3);
    }

    @Test
    @DisplayName("Dos números separados por enter se suman")
    void sameThatBeforeButNewLineDelimitedTest() throws Exception {

        String evaluatedString = "0\n2";
        var numericValue = stringCalculatorInstance.add(evaluatedString);

        String evaluatedString2 = "1\n1";
        var numericValue2 = stringCalculatorInstance.add(evaluatedString2);

        String evaluatedString3 = "1\n2";
        var numericValue3 = stringCalculatorInstance.add(evaluatedString3);

        Assertions.assertEquals(2, numericValue);
        Assertions.assertEquals(2, numericValue2);
        Assertions.assertEquals(3, numericValue3);
    }

    @Test
    @DisplayName("Tres números separados como sea son sumados")
    void sameThatBeforeButAllDelimitersWorksTest() throws Exception {
        String evaluatedString = "1\n2,3";
        var numericValue = stringCalculatorInstance.add(evaluatedString);

        String evaluatedString2 = "1,2\n4";
        var numericValue2 = stringCalculatorInstance.add(evaluatedString2);

        Assertions.assertEquals(6, numericValue);
        Assertions.assertEquals(7, numericValue2);
    }

    @Test()
    @DisplayName("Números negativos devuelven una excepción")
    void negativeNumbersThrowsAnExceptionTest() throws Exception {

        String evaluatedString = "-1,-1";
        NumberFormatException error = Assertions.assertThrows(NumberFormatException.class,
                () -> stringCalculatorInstance.add(evaluatedString));

        Assertions.assertEquals(NumberFormatException.class, error.getClass());
    }

    @Test
    @DisplayName("Los números mayores a 1000 son ignorados")
    public void greaterThan1000AreIgnoredTest() throws Exception {
        String evaluatedString = "2,1000";
        var numericValue = stringCalculatorInstance.add(evaluatedString);

        String evaluatedString2 = "2,1001";
        var numericValue2 = stringCalculatorInstance.add(evaluatedString2);

        Assertions.assertEquals(1002, numericValue);
        Assertions.assertEquals(2, numericValue2);
    }

    @Test
    public void singleCharDelimiterTest() throws Exception {
        String evaluatedString = "#2#1000";
        var numericValue = stringCalculatorInstance.add(evaluatedString);

        Assertions.assertEquals(1002, numericValue);
    }
}
