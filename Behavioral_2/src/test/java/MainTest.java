import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Path workingDir;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void init(){
        this.workingDir = Path.of("","src/test/resources");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void main() throws IOException {
        this.workingDir = Path.of("","src/test/resources");
        System.setOut(new PrintStream(outContent));
        Path file = this.workingDir.resolve("expected.txt");
        String expected = Files.readString(file);
        Main.main(null);
        assertEquals(expected,outContent.toString());
    }
}