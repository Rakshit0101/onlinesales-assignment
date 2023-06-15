package onlinesales.task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class EquationResolverTest {
    @Test
    void testEvaluateExpression() throws IOException {
        String result = EquationResolver.evaluateExpression("2 + 2");
        Assertions.assertEquals("4", result);

        result = EquationResolver.evaluateExpression("sqrt(16)");
        Assertions.assertEquals("4", result);

        result = EquationResolver.evaluateExpression("3 * 5 - 2");
        Assertions.assertEquals("13", result);

        result = EquationResolver.evaluateExpression("2 ^ 2");
        Assertions.assertEquals("4", result);

        result = EquationResolver.evaluateExpression("3 - 3");
        Assertions.assertNotEquals("1", result);

    }
}
