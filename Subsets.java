import java.util.Scanner;

public class Subsets {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String set = scanner.nextLine();
		subSet(set);
	}

	public static void subSet(String set) {
		String[] numberOfSet = set.split(",");
		for (int i = 0; i <= numberOfSet.length; i++) {
			boolean[] print_flag = new boolean[numberOfSet.length];
			PrintSubSet(numberOfSet, print_flag, 0, i);
		}
	}

	public static void PrintSubSet(String[] numOfSet, boolean[] print_flag, int start, int num_elements) {

		if (num_elements == 0) {
			int j = 0;
			System.out.print("{");
			for (int i = 0; i < print_flag.length; i++) {
				if (print_flag[i]) {

					if (j != 0) {
						System.out.print(",");
					}
					System.out.print(numOfSet[i]);

					j++;
				}
			}
			System.out.println("}");
		} else {
			if (start + num_elements > numOfSet.length)
				;
			else {

				for (int i = start; i < numOfSet.length; i++) {
					if (!print_flag[i]) {
						print_flag[i] = true;
						PrintSubSet(numOfSet, print_flag, i + 1, num_elements - 1);
						print_flag[i] = false;
					}
				}
			}
		}
	}
}
