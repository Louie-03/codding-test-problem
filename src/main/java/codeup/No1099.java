package codeup;

import java.util.Scanner;

public class No1099 {
    public static void main(String[] args) {
        int[][] coordinate = getCoordinate();
        setMoveCoordinate(coordinate);
        printCoordinate(coordinate);
    }

    private static void setMoveCoordinate(int[][] coordinate) {
        int x = 1;
        int y = 1;
        while (true) {
            if (coordinate[x][y] == 2) {
                coordinate[x][y] = 9;
                break;
            }
            coordinate[x][y] = 9;

            if (x == 9 && y == 9) break;
            if (x == 9) y++;
            if (y == 9) x++;

            if (coordinate[x][y + 1] == 0 || coordinate[x][y + 1] == 2) {
                y++;
            } else if (coordinate[x + 1][y] == 0 || coordinate[x + 1][y] == 2) {
                x++;
            } else {
                break;
            }
        }
    }

    private static void printCoordinate(int[][] coordinate) {
        for (int[] ints : coordinate) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getCoordinate() {
        Scanner scanner = new Scanner(System.in);
        int[][] coordinate = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                coordinate[i][j] = scanner.nextInt();
            }
        }
        return coordinate;
    }
}
