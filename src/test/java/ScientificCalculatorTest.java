import static org.junit.Assert.*;
import org.junit.Test;

public class ScientificCalculatorTest {
    @Test
    public void testSquareRoot() {
        assertEquals(4.0, ScientificCalculator.squareRoot(16), 0.001);
    }
    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.factorial(5));
    }
    @Test
    public void testNaturalLog() {
        assertEquals(0, ScientificCalculator.naturalLog(1), 0.001);
    }
    @Test
    public void testPower() {
        assertEquals(8.0, ScientificCalculator.power(2, 3), 0.001);
    }
}
