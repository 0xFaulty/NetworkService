package cloud.network.client.console;

import org.junit.Ignore;
import org.junit.Test;

public class ConsoleParserTest {

    @Test
    @Ignore
    public void parseShowTest() {
        String[] args = {"-show", "lo", "--server", "localhost", "--port", "8080"};
        new ConsoleParser().parse(args);
        String[] args2 = {"-show", "eth0", "--server", "localhost", "--port", "8080"};
        new ConsoleParser().parse(args2);
    }

    @Test
    @Ignore
    public void parseListTest() {
        String[] args = {"-list", "--server", "localhost", "--port", "8080"};
        new ConsoleParser().parse(args);
    }

}