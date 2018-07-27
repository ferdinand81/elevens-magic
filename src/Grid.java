public class Grid {

    private int[][] grid;
    private int[][] temp;
    private int rows;
    private int cols;


    public Grid(int rows, int cols) {
        this.grid = new int[rows][cols];
        this.temp = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    //populates with cards in order left to right
    public void populate() {
        int count = 1;
        for (int i = 0; i < rows; i++ ) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = count;
                count++;
            }
        }
    }

    private int getNextEmptyLinearIndex(int[][] matrix) {
        int emptyLinearIndex = 0;
        for (int i = 0; i < rows; i++ ) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) return emptyLinearIndex;
                else emptyLinearIndex++;
            }
        }
        return -1; //error
    }

    //deals a column in order from left to right
    public void deal(int column) {
        int linearIndex = getNextEmptyLinearIndex(temp);

        //uses the linearIndex to deal cards from one column
        for (int i = rows - 1; i >= 0; i--) {
            temp[linearIndex/cols][linearIndex%cols] = grid[i][column];
            linearIndex++;
        }

    }

    public int getValueAtLinearIndex(int linearIndex) {
        return grid[linearIndex/cols][linearIndex%cols];

    }

    public void updateGrid() {
        grid = temp;
    }

    public void resetTemp() {
        temp = new int[rows][cols];
    }

    @Override
    public String toString() {
        String gridString = "\n---------------\n";
        for (int i = 0; i < rows; i++ ) {
            for (int j = 0; j < cols; j++ ) {
                gridString += grid[i][j] + "\t";
            }
            gridString += "\n";
        }
        return gridString;

    }
}
