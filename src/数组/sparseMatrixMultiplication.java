package 数组;

import java.util.HashMap;
import java.util.Map;

public class sparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        Map<Integer, Map<Integer, Integer>> matrix1 = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> matrix2 = new HashMap<>();
        for (int i = 0; i < mat1.length; i++) {
            matrix1.put(i, new HashMap<>());
            for (int j = 0; j < mat1[i].length; j++) {
                if (mat1[i][j] != 0) {
                    matrix1.get(i).put(j, mat1[i][j]);
                }
            }
        }

        for (int i = 0; i < mat2[0].length; i++) {
            matrix2.put(i, new HashMap<>());
            for (int j = 0; j < mat2.length; j++) {
                if (mat2[j][i] != 0) {
                    matrix2.get(i).put(j, mat2[j][i]);
                }
            }
        }

        int[][] result = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int column:matrix1.get(i).keySet()) {
                    if (matrix2.get(j).containsKey(column)) {
                        result[i][j] += matrix1.get(i).get(column) * matrix2.get(j).get(column);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> a =new HashMap<>();
        for (int c:a.keySet()) {
            System.out.print(c);
        }
    }
}
