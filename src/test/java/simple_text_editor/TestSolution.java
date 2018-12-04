package simple_text_editor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

public class TestSolution {
	
	@Test
	public void testa_solucao() throws FileNotFoundException {
		Solution.start( new Scanner( new FileReader("src/test/resources/simple-text-editor-testcases/input/input08.txt") ) );
	}

}
