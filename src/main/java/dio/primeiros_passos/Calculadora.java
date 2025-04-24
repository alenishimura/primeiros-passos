package dio.primeiros_passos;

public class Calculadora {
    public static int somar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(5, 3);
        System.out.println("Resultado: " + resultado);
    }
}