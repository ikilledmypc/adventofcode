import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class one {
	LinkedList<Integer> buffer = new LinkedList<>();
	ArrayList<Integer> numbers = new ArrayList<>();
	int counter = 0;

	//skip the first value lazyness
	int lastSum = Integer.MAX_VALUE;

	@Test
	public void run() throws FileNotFoundException {
		readFile();

		//add initial numbers
		for(int i = 0; i < 3; i++ ) {
			buffer.add(numbers.get(i));
		}

		for (int i = 3; i < numbers.size(); i++) {
			int sum = getSum();
			if(sum > lastSum){
				counter++;
			}
			lastSum = sum;
			buffer.push(numbers.get(i));
		}
		System.out.println(counter);

	}

	private int getSum(){
		int sum =0;
		Iterator<Integer> iterator = buffer.iterator();
		for(int i = 0; i < 3; i++ ){
			sum+= iterator.next();
		}
		return sum;
	}

	private void readFile() throws FileNotFoundException {
		FileReader finput = new FileReader("/home/timsmeets/git/adventofcode/1/input.txt");
		BufferedReader reader = new BufferedReader(finput);
		reader.lines().forEach(line -> {
					if (line.length() > 0) {
						numbers.add(Integer.parseInt(line));
					}
				}
		);
	}
}
