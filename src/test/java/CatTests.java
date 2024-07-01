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

public class CatTests {

    @Test
    void testGetSound() {
        Cat cat = new Cat(Mockito.mock(Feline.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        Cat cat = new Cat(mockFeline);

        when(mockFeline.eatMeat()).thenReturn(List.of("Fish", "Meat"));

        assertEquals(List.of("Fish", "Meat"), cat.getFood());
    }

    // Additional parameterized test example (if needed)
    @ParameterizedTest
    @ValueSource(strings = {"Meow", "Purr"})
    void testCatSounds(String sound) {
        Cat cat = new Cat(Mockito.mock(Feline.class));
        // Assuming the sound is set based on the input provided during construction
        assertEquals(sound, cat.getSound());
    }
}
