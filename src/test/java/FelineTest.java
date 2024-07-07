import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FelineTest {

    @Test
    public void felineFamilyTest() {
        Feline feline = new Feline();
        String expectedResult = "Кошачьи";
        assertEquals(feline.getFamily(), expectedResult);
    }

    @Test
    public void felineFoodIsMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(feline.eatMeat(), expectedResult);
    }

    @Test
    public void getKittensDefaultValueTest(){
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

}
