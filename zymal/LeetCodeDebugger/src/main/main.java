package main;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		System.out.println("hello world");
		getRow(4);
	}
	
	
	public List<Integer> getRow(int rowIndex) {
		
		var result = new ArrayList<List<Integer>>();

		for (int i = 0; i < rowIndex; i++) {

			var list = new ArrayList<Integer>();

			if (i > 0) {

				list.add(1);

				var beforeList = result.get(i - 1);

				var isZeroOrNot = beforeList.size() % 2;

				var splitIndex = beforeList.size() / 2;

				if (isZeroOrNot == 0) {

					var firstSplitIndex = splitIndex - 1;

					var secondSplitIndex = splitIndex + 1;

					var firstHalf = new ArrayList<>(beforeList.subList(0, firstSplitIndex));

					var secondHalf = new ArrayList<>(beforeList.subList(secondSplitIndex, beforeList.size()));

					for (int l = 0; l < firstHalf.size() - 1; l++) {

						list.add(firstHalf.get(l) + firstHalf.get(l + 1));

					}

					list.add(beforeList.get(firstSplitIndex) + beforeList.get(splitIndex));

					list.add(beforeList.get(splitIndex) + beforeList.get(secondSplitIndex));

					for (int m = 0; m < secondHalf.size() - 1; m++) {

						list.add(secondHalf.get(m) + secondHalf.get(m + 1));

					}

				} else {

					var firstHalf = new ArrayList<>(beforeList.subList(0, splitIndex));

					var secondHalf = new ArrayList<>(beforeList.subList(splitIndex, beforeList.size()));

					for (int j = 0; j < firstHalf.size() - 1; j++) {

						list.add(firstHalf.get(j) + firstHalf.get(j + 1));

					}

					list.add(beforeList.get(splitIndex) + beforeList.get(splitIndex + 1));

					for (int k = 0; k < secondHalf.size() - 1; k++) {

						list.add(secondHalf.get(k) + secondHalf.get(k + 1));

					}

				}

			}

			list.add(1);

			result.add(list);
		}
		return result.get(rowIndex);
	}
	

}
