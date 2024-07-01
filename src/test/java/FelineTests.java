import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.fail;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Spy;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.AccessDeniedException;

public class FelineTests {

    @Test
    void testEatMeat() throws Exception {
        Feline feline = new Feline();

        List<String> expectedMeatList = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedMeatList, feline.eatMeat());
    }

    @Test
    void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens()); // Default kittens count is 1
        assertEquals(5, feline.getKittens(5)); // Testing with a custom kittens count
    }

    @ParameterizedTest
    @ValueSource(strings = {"Травоядное", "Хищник"})
    void testGetFood(String animalKind) throws Exception {
        Feline feline = new Feline();
        List<String> foodList = feline.getFood(animalKind);

        if ("Травоядное".equals(animalKind)) {
            assertEquals(List.of("Трава", "Различные растения"), foodList);
        } else if ("Хищник".equals(animalKind)) {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
        }
    }
}