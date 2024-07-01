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

public class LionTests {

    @Test
    void testLionConstructor() throws Exception {
        Lion lionMale = new Lion("Самец");
        assertTrue(lionMale.doesHaveMane());

        Lion lionFemale = new Lion("Самка");
        assertFalse(lionFemale.doesHaveMane());

        assertThrows(Exception.class, () -> new Lion("Other"));
    }

    @Test
    void testGetKittens() {
        Lion lion = new Lion("Самец");
        assertEquals(1, lion.getKittens()); // Default kittens count is 1
    }

    @Test
    void testGetFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getFood(anyString())).thenReturn(List.of("Meat"));

        Lion lion = new Lion("Самец");
        lion.feline = mockFeline;

        assertEquals(List.of("Meat"), lion.getFood());
    }
}