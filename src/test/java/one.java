import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/**
 * Considering every single measurement isn't as useful as you expected: there's just too much noise in the data.
 *
 * Instead, consider sums of a three-measurement sliding window. Again considering the above example:
 *
 * 199  A
 * 200  A B
 * 208  A B C
 * 210    B C D
 * 200  E   C D
 * 207  E F   D
 * 240  E F G
 * 269    F G H
 * 260      G H
 * 263        H
 *
 * Start by comparing the first and second three-measurement windows. The measurements in the first window are marked A (199, 200, 208); their sum is 199 + 200 + 208 = 607. The second window is marked B (200, 208, 210); its sum is 618. The sum of measurements in the second window is larger than the sum of the first, so this first comparison increased.
 *
 * Your goal now is to count the number of times the sum of measurements in this sliding window increases from the previous sum. So, compare A with B, then compare B with C, then C with D, and so on. Stop when there aren't enough measurements left to create a new three-measurement sum.
 *
 * In the above example, the sum of each three-measurement window is as follows:
 *
 * A: 607 (N/A - no previous sum)
 * B: 618 (increased)
 * C: 618 (no change)
 * D: 617 (decreased)
 * E: 647 (increased)
 * F: 716 (increased)
 * G: 769 (increased)
 * H: 792 (increased)
 *
 * In this example, there are 5 sums that are larger than the previous sum.
 *
 * Consider sums of a three-measurement sliding window. How many sums are larger than the previous sum?
 */

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
