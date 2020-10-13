import java.util.Scanner;

public class NotMain {
    private int amountGoods;
    private int amountWarehouse;
    private int[][] matrix;
    private int checkCloseTask = 0;
    private int numColumn;
    private int minCost = 2147483647;
    private int result;
    Scanner in;

    public NotMain() {
        this.in = new Scanner(System.in);
    }

    public void setMatrix(int amountWarehouse, int amountGoods) {
        this.matrix = new int[amountWarehouse][amountGoods];
        this.amountWarehouse = amountWarehouse;
        this.amountGoods = amountGoods;
        this.matrix[0][0] = 99;
    }

    public void getMatrix() {
        for(int indexLine = 0; indexLine < this.amountWarehouse; ++indexLine) {
            for(int indexColumn = 0; indexColumn < this.amountGoods; ++indexColumn) {
                System.out.print(this.matrix[indexLine][indexColumn] + "\t");
            }

            System.out.println();
        }

    }

    public void getCheckCloseTask() {
        if (this.checkCloseTask != 0) {
            System.out.println("Количества товаров и места в складах не совпадает.");
        }

    }

    public void setSizeWarehouse() {
        for(int indexLine = 1; indexLine < this.amountWarehouse; ++indexLine) {
            this.matrix[indexLine][0] = this.in.nextInt();
            this.checkCloseTask += this.matrix[indexLine][0];
        }

    }

    public void setSizeGoods() {
        for(int indexColumn = 1; indexColumn < this.amountWarehouse; ++indexColumn) {
            this.matrix[0][indexColumn] = this.in.nextInt();
            this.checkCloseTask += this.matrix[0][indexColumn];
        }

    }

    public void setCost() {
        for(int indexLine = 1; indexLine < this.amountWarehouse; ++indexLine) {
            for(int indexColumn = 1; indexColumn < this.amountGoods; ++indexColumn) {
                this.matrix[indexLine][indexColumn] = this.in.nextInt();
            }
        }

    }

    public void searchMinPrice(int indexLine) {
        for(int indexColumn = 1; indexColumn < this.amountGoods; ++indexColumn) {
            if (this.minCost > this.matrix[indexLine][indexColumn]) {
                this.minCost = this.matrix[indexLine][indexColumn];
                this.numColumn = indexColumn;
            }
        }

    }

    public void functionPositiveValueWarehouse(int indexLine) {
        int[] var10000 = this.matrix[indexLine];
        var10000[0] -= this.matrix[0][this.numColumn];
        this.result += this.matrix[0][this.numColumn] * this.minCost;
        this.matrix[0][this.numColumn] = 0;
    }

    public int getResult() {
        for(int indexLine = 1; indexLine < this.amountWarehouse; ++indexLine) {
            this.searchMinPrice(indexLine);

            for(this.matrix[indexLine][this.numColumn] = 2147483647; this.matrix[indexLine][0] > this.matrix[0][this.numColumn]; this.matrix[indexLine][this.numColumn] = 2147483647) {
                this.functionPositiveValueWarehouse(indexLine);
                this.minCost = 2147483647;
                this.searchMinPrice(indexLine);
            }

            if (this.matrix[indexLine][0] < this.matrix[0][this.numColumn]) {
                int[] var10000 = this.matrix[0];
                int var10001 = this.numColumn;
                var10000[var10001] -= this.matrix[indexLine][0];
                this.result += this.matrix[indexLine][0] * this.minCost;
                this.matrix[indexLine][0] = 0;
            }

            if (this.matrix[indexLine][0] == this.matrix[0][this.numColumn]) {
                this.functionPositiveValueWarehouse(indexLine);
            }

            this.minCost = 2147483647;
        }

        return this.result;
    }
}
