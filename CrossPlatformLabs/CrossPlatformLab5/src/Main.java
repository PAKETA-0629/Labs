public class Main {

    public static void main(String[] args) {
        //double n = divide(2, 0);
        interrupted();
    }


    public static double divide(double n1, double n2) {
        double result;
        try {
            if (n2 == 0) throw new MyArithmeticException("Dividing by zero");
            result = n1 / n2;
        } catch (MyArithmeticException e) {
            result = -1;
            System.out.println(e);
            e.printStackTrace();
        }
        return result;
    }


    public static void interrupted() {
        try {
            if (!Thread.interrupted()) throw new MyInterruptedException("Thread is interrupted");
        } catch (MyInterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
