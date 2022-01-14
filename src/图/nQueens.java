package 图;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class nQueens {
    HashSet<Integer> columns = new HashSet<>();
    HashSet<Integer> diagonal = new HashSet<>();
    HashSet<Integer> reverseDiagonal = new HashSet<>();
    int size;
    int[][] places;
    public List<List<String>> solveNQueens(int n) {
        this.size = n;
        this.places = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        placeQueen(0, result);
        return result;
    }

    private boolean placeQueen(int row, List<List<String>> result) {
        if (row == this.size) {
            addPlacesToResult(result);
            return true;
        }
        boolean isPlaceable = false;
        for (int i = 0; i < this.size; i++) {
            if (columns.contains(i) || diagonal.contains(row - i) || reverseDiagonal.contains(i + row)) {
                continue;
            }
            places[row][i] = 1;
            columns.add(i);
            diagonal.add(row - i);
            reverseDiagonal.add(i + row);
            isPlaceable |= placeQueen(row + 1, result);
            places[row][i] = 0;
            columns.remove(i);
            diagonal.remove(row - i);
            reverseDiagonal.remove(i + row);
        }
        return isPlaceable;
    }

    private void addPlacesToResult(List<List<String>> result) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < places.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < places[i].length; j++) {
                if (places[i][j] == 1) {
                    sb = sb.append("Q");
                } else {
                    sb = sb.append(".");
                }
            }
            solution.add(sb.toString());
        }
        result.add(solution);
    }
}
