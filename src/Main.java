import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        NotMain NotMain = new NotMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Поочередно укажите сначала количество поставщиков, а затем количество складов");
        NotMain.setMatrix(scanner.nextInt() + 1, scanner.nextInt() + 1);
        System.out.println("Поочередно указывайте размеры складов:");
        NotMain.setSizeWarehouse();
        System.out.println("Поочередно указывайте размеры поставщиков:");
        NotMain.setSizeGoods();
        NotMain.getCheckCloseTask();
        System.out.println("Поочередно указывайте цены на доставку:");
        NotMain.setCost();
        NotMain.getMatrix();
        System.out.println("Стоимость перевозок будет составлять: " + NotMain.getResult());
    }
}
