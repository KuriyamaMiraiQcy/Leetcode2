package 数组;

import java.util.List;

public class leftMostColumnWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int rowLength = dimension.get(1);

        int result = Integer.MAX_VALUE;
        for (int i=0; i < rows;i++) {
            int start = 0;
            int end = rowLength - 1;
            while (start < end) {
                int mid = start + (end-start) /2;
                if (binaryMatrix.get(i, mid) == 0) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (binaryMatrix.get(i, start) == 1) {
                result = Math.min(start, result);
            }
        }
        return result < Integer.MAX_VALUE? result:-1;
    }

    public int LeftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int rowLength = dimension.get(1);

        int startX = 0;
        int endX = rowLength - 1;
        while (startX < rows && endX >= 0) {
            if (binaryMatrix.get(startX, endX) == 1) {
                endX--;
            } else {
                startX++;
            }
        }
        return endX == rowLength - 1?-1:endX + 1;
    }
}
