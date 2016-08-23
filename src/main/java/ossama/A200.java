package ossama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by ahmed on 7/28/16.
 * TLE TLE TLE
 */
public class A200 {

    public static void main(String[] args) {
        A200 program = new A200();
        program.begin();
    }

    private int n, m, numRequests;
    private Point[] requests;
    private Vector<Point>[][] neighbours;
    private int[][] level;
    private int[][] pointer;
    private boolean[][] taken;


    public void begin() {
        readInput();
        initializeGrid();
        Vector<Point> answers = resolveRequests();
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < numRequests; i++)
            ans.append((answers.get(i).getRow() + 1) + " " + (answers.get(i).getCol() + 1) + "\n");
        System.out.print(ans);
    }


    Vector<Point> resolveRequests() {
        Vector<Point> seats = new Vector<Point>();
        for (int i = 0; i < numRequests; i++)
            seats.add(resolveRequest(requests[i]));
        return seats;
    }

    Point resolveRequest(Point p) {
        int row = p.getRow(), col = p.getCol();
        boolean fulfilled = false;
        Point resultSeat = new Point(-1, -1);
        while (resultSeat.getRow() == -1) {
            while (pointer[row][col] < neighbours[row][col].size()) {
                Point candidateNeighbour = neighbours[row][col].get(pointer[row][col]++);

                if (!taken[candidateNeighbour.getRow()][candidateNeighbour.getCol()]) {
                    taken[candidateNeighbour.getRow()][candidateNeighbour.getCol()] = true;
                    resultSeat = new Point(candidateNeighbour.getRow(), candidateNeighbour.getCol());
                    break;
                }
            }
            if (resultSeat.getRow() == -1) {
                level[row][col]++;
                pointer[row][col] = 0;
                neighbours[row][col] = getLevelNeighboursForACell(new Point(row, col));
            }
        }
        return resultSeat;
    }



    void initializeGrid() {
        neighbours = new Vector[n][m];
        level = new int[n][m];
        pointer = new int[n][m];
        taken = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                neighbours[i][j] = getLevelNeighboursForACell(new Point(i, j));

    }

    Vector<Point> getLevelNeighboursForACell(Point p) {
        int row = p.getRow(), col = p.getCol();
        int lvl = level[row][col];
        Vector<Point> neighbours = new Vector<Point>();
        for (int xDiff = -lvl; xDiff <= lvl; xDiff++) {
            for (int dir = -1; dir <= 1; dir += 2) {
                int yDiff = (lvl - Math.abs(xDiff)) * dir;
                Point neighbour = new Point(row + xDiff, col + yDiff);
                if (neighbour.isValid(n, m) && !taken[neighbour.getRow()][neighbour.getCol()])
                    neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    void readInput() {
        InputReader in = new InputReader(System.in);

        n = in.nextInt();
        m = in.nextInt();
        numRequests = in.nextInt();

        requests = new Point[numRequests];
        for (int i = 0; i < numRequests; i++)
            requests[i] = new Point(in.nextInt() - 1, in.nextInt() - 1);
    }
}


class Point {

    private int row, col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isValid(int n, int m) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}


class InputReader {
    private BufferedReader reader;
    private StringTokenizer tok;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tok = new StringTokenizer("");
    }

    public String next() {
        while (!tok.hasMoreTokens())
            try {
                tok = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return tok.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}