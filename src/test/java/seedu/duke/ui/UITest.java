package seedu.duke.ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UiTest {
    @Test
    void readListOfIntegers_multipleIntegerInput_expectListOfIntegers() {
        String input = "1 2 3";
        InputStream originalIn = System.in;
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        Ui ui = new Ui();
        ArrayList<Integer> actual = ui.readIntegers();

        ArrayList<Integer> listOfIntegers = new ArrayList<>(List.of(1, 2, 3));
        assertEquals(listOfIntegers, actual);

        System.setIn(originalIn);
    }
}