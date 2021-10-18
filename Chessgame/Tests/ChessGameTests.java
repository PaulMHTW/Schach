import ChessGame.ChessGameExceptions.*;
import ChessGame.Game.*;
import org.junit.*;

public class ChessGameTests {


    @Test
    public void goodTest() throws InvalidColorException {
        Chess testGame = new ChessImpl();
        String name = "Anton";
        String[] options = {"black", "white", "random"};

        for (String choice : options) {
            testGame.selectNameAndColor(name, choice);
        }
    }

    @Test(expected = InvalidColorException.class)
    public void badTest() throws InvalidColorException {
        Chess testGame = new ChessImpl();
        String name = "Anton";

        testGame.selectNameAndColor(name, "Some bullshit: hfiwf7438");
    }

    public void testField() {


    }

}
