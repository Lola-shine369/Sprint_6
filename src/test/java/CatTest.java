import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.Cat;
import com.example.Feline;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;

    @Test
    public void catSoundMeowTest() {
        Cat cat = new Cat(feline);
        String expectedResult = "Мяу";
        assertEquals(cat.getSound(), expectedResult);
    }

    @Test
    public void catEatMeatFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = cat.getFood();
        assertEquals(expectedResult, actualResult);
    }
}