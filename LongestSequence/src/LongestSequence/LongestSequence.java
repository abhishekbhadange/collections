package LongestSequence;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestSequence {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("Enter rows & columns of the matrix (seperated by space): ");
			String rowCol = br.readLine();
			if (rowCol.split(" ").length > 2 || rowCol.split(" ").length < 2
					|| rowCol.split(" ").length <= 0) {
				System.out.println("Error: please check your input!");
				System.exit(-1);
			}
			int row = Integer.valueOf(rowCol.split(" ")[0].trim());
			int col = Integer.valueOf(rowCol.split(" ")[1].trim());
			int[][] grid = new int[row][col];
			System.out.println("Enter values of the matrix (from left to right, top to bottom & seperated by spaces): ");
			String value = br.readLine();
			String[] values = value.split(" ");
			if (values.length < row * col || values.length > row * col
					|| values.length <= 0) {
				System.out.println("Error: please check your input!");
				System.exit(-1);
			}
			int ctr = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					grid[i][j] = Integer.valueOf(values[ctr].trim());
					ctr++;
				}
			}
			System.out.println("Longest sequence length: "
					+ longestSequence(grid));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int longestSequence(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		// 2d array to keep track of visited cells (1 - visited, 0 - not
		// visited)
		int[][] visited = new int[rows][cols];
		// 2d array to keep track of the length of the longest sequence from
		// each cell
		int[][] pathLength = new int[rows][cols];
		// int variable holding maximum path length
		int maxPath = Integer.MIN_VALUE;
		int row = 0, col = 0, icount = 1;
		for (int m = 0; m < rows; m++) {
			for (int n = 0; n < cols; n++) {
				row = m;
				col = n;
				visited[row][col] = 1;
				while (true) {
					String str = adjacentNode(visited, row, col, grid);
					if (str.equals("0")) {
						break;
					}
					row = Integer.valueOf(str.split(",")[0]);
					col = Integer.valueOf(str.split(",")[1]);
					icount++;
					visited[row][col] = 1;
				}
				pathLength[m][n] = icount;
				icount = 1;
				visited = new int[rows][cols];
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (pathLength[i][j] > maxPath)
					maxPath = pathLength[i][j];
			}
		}
		return maxPath;
	}

	// method to find the next higher eligible cell in the longest sequence
	private static String adjacentNode(int[][] temp, int row, int col,
			int[][] grid) {
		int value = grid[row][col];
		int rowlen = grid.length - 1;
		int collen = grid[0].length - 1;
		String strKey;
		// HashMap storing "row,column" as key and cell value as value
		Map<String, Integer> map = new HashMap<String, Integer>();
		// checking upper cell value
		if ((row - 1) >= 0 && temp[row - 1][col] == 0
				&& grid[row - 1][col] >= value) {
			strKey = Integer.toString(row - 1) + "," + Integer.toString(col);
			map.put(strKey, grid[row - 1][col]);
		}
		// checking upper right cell value
		if ((row - 1) >= 0 && (col + 1) <= collen
				&& temp[row - 1][col + 1] == 0
				&& grid[row - 1][col + 1] >= value) {
			strKey = Integer.toString(row - 1) + ","
					+ Integer.toString(col + 1);
			map.put(strKey, grid[row - 1][col + 1]);
		}
		// checking right cell value
		if ((col + 1) <= collen && temp[row][col + 1] == 0
				&& grid[row][col + 1] >= value) {
			strKey = Integer.toString(row) + "," + Integer.toString(col + 1);
			map.put(strKey, grid[row][col + 1]);
		}
		// checking lower right cell value
		if ((row + 1) <= rowlen && (col + 1) <= collen
				&& temp[row + 1][col + 1] == 0
				&& grid[row + 1][col + 1] >= value) {
			strKey = Integer.toString(row + 1) + ","
					+ Integer.toString(col + 1);
			map.put(strKey, grid[row + 1][col + 1]);
		}
		// checking lower cell value
		if ((row + 1) <= rowlen && temp[row + 1][col] == 0
				&& grid[row + 1][col] >= value) {
			strKey = Integer.toString(row + 1) + "," + Integer.toString(col);
			map.put(strKey, grid[row + 1][col]);
		}
		// checking lower left cell value
		if ((row + 1) <= rowlen && (col - 1) >= 0
				&& temp[row + 1][col - 1] == 0
				&& grid[row + 1][col - 1] >= value) {
			strKey = Integer.toString(row + 1) + ","
					+ Integer.toString(col - 1);
			map.put(strKey, grid[row + 1][col - 1]);
		}
		// checking left cell value
		if ((col - 1) >= 0 && temp[row][col - 1] == 0
				&& grid[row][col - 1] >= value) {
			strKey = Integer.toString(row) + "," + Integer.toString(col - 1);
			map.put(strKey, grid[row][col - 1]);
		}
		// checking upper left cell value
		if ((row - 1) >= 0 && (col - 1) >= 0 && temp[row - 1][col - 1] == 0
				&& grid[row - 1][col - 1] >= value) {
			strKey = Integer.toString(row - 1) + ","
					+ Integer.toString(col - 1);
			map.put(strKey, grid[row - 1][col - 1]);
		}
		if (map.size() > 0) {
			// retrieving the key of next higher value from the sorted by value
			// TreeMap
			String str = MapSort.sortByValue(map);
			return str;
		} else {
			return "0";
		}
	}
}
