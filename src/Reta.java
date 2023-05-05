import java.util.Scanner;

public class Reta {
    // Classe para representar um ponto na coordenada
    private static class Ponto {
        public double x;
        public double y;

        public Ponto(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Função para transladar o ponto para uma nova posição
        public void transladar(double dx, double dy) {
            x += dx;
            y += dy;
        }

        // Função para rotacionar o ponto em torno de um ângulo dado em radianos
        public void rotacionar(double angulo) {
            double novoX = x * Math.cos(angulo) - y * Math.sin(angulo);
            double novoY = x * Math.sin(angulo) + y * Math.cos(angulo);
            x = novoX;
            y = novoY;
        }

        // Função para refletir o ponto em relação à origem (x,y)
        public void refletir(double x, double y) {
            this.x = 2 * x - this.x;
            this.y = 2 * y - this.y;
        }

        // Função para escalar o ponto em relação a uma escala dada
        public void escalar(double escala) {
            x *= escala;
            y *= escala;
        }
    }

    // Função para traçar uma reta usando o algoritmo DDA
    public static void desenharReta(Ponto p1, Ponto p2) {
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        double passos = Math.max(Math.abs(dx), Math.abs(dy));
        double xIncremento = dx / passos;
        double yIncremento = dy / passos;

        double x = p1.x;
        double y = p1.y;
        for (int i = 0; i < passos; i++) {
            System.out.println("(" + x + ", " + y + ")");
            x += xIncremento;
            y += yIncremento;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a coordenada x do primeiro ponto: ");
        double x1 = scanner.nextDouble();
        System.out.print("Digite a coordenada y do primeiro ponto: ");
        double y1 = scanner.nextDouble();
        Ponto p1 = new Ponto(x1, y1);

        System.out.print("Digite a coordenada x do segundo ponto: ");
        double x2 = scanner.nextDouble();
        System.out.print("Digite a coordenada y do segundo ponto: ");
        double y2 = scanner.nextDouble();
        Ponto p2 = new Ponto(x2, y2);

        desenharReta(p1, p2);

        // Rotacionar a reta em torno de um ângulo dado
        System.out.print("Digite o ângulo em graus para rotacionar a reta: ");
        double angulo = scanner.nextDouble() * Math.PI / 180;
        p1.rotacionar(angulo);
        p2.rotacionar(angulo);
        System.out.println("Reta rotacionada: ");
        desenharReta(p1, p2);

        // Transladar a reta
        System.out.print("Digite o valor de dx para transladar a reta: ");
        double dx = scanner.nextDouble();
        System.out.print("Digite o valor de dy para transladar a reta: ");
        double dy = scanner.nextDouble();
        p1.transladar(dx, dy);
        p2.transladar(dx, dy);
        System.out.println("Reta transladada: ");
        desenharReta(p1, p2);

        // Refletir a reta em relação a um ponto
        System.out.print("Digite a coordenada x do ponto de reflexão: ");
        double x = scanner.nextDouble();
        System.out.print("Digite a coordenada y do ponto de reflexão: ");
        double y = scanner.nextDouble();
        p1.refletir(x, y);
        p2.refletir(x, y);
        System.out.println("Reta refletida: ");
        desenharReta(p1, p2);

        // Escalar a reta
        System.out.print("Digite a escala para a reta: ");
        double escala = scanner.nextDouble();
        p1.escalar(escala);
        p2.escalar(escala);
        System.out.println("Reta escalada: ");
        desenharReta(p1, p2);
    }
}
