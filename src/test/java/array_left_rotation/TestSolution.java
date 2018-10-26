package array_left_rotation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

public class TestSolution {
	
	@Test
	public void testa_solucao() throws FileNotFoundException {
		Solution.start( new Scanner( new FileReader("src/test/resources/array-left-rotation-testcases/input/input00.txt") ) );
	}

}
