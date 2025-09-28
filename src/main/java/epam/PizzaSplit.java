package epam;


import java.io.IOException;

public class PizzaSplit {

    public static void main(String[] args) {
        long people = initData();
        long slices = initData();
        System.out.println(countPizza(people, slices));
    }

    public static long countPizza(long people, long slices) {
        long pizzas;
        if (people <= 0 || slices <= 0) {
            throw new IllegalArgumentException("Параметр не может быть отрицательным или равен 0");
        }
        long divisor = findDivisor(people, slices);
        long totalSlices = (people * slices) / divisor;
        pizzas = totalSlices / slices;
        return pizzas;
    }

    private static long initData() {
        String data;
        try {
            data = readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Long.parseLong(data.trim());
    }

    private static String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) != -1 && c != '\n' && c != '\r') {
            sb.append((char) c);
        }
        return sb.toString();
    }

    private static long findDivisor(long a, long b) {
        if (b == 0) {
            return a;
        }
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Параметр не может быть отрицательным или равен 0");
        }
        return findDivisor(b, a % b);
    }
}
