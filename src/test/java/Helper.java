import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class Helper {
	public static Stream<String> getInput(int question) throws FileNotFoundException {
		FileReader finput = new FileReader("/home/timsmeets/git/adventofcode/" + question + "/input.txt");
		BufferedReader reader = new BufferedReader(finput);
		return reader.lines();
	}
}
