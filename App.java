// S23017358 Rojas Santos Rogelio

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BilleteraParque bill1 = new BilleteraParque(100);

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("==Administrador de billeteras para parques temáticos==");
            System.out.println("1. Agregar tickets");
            System.out.println("2. Establecer tickets");
            System.out.println("3. Comprar premio");
            System.out.println("4. Establecer festivo");
            System.out.println("5. Salir");
            System.out.println("Tu billetera tiene " + bill1.getTickets() + " boletos");
            System.out.print("Ingrese la opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\n¿Cuántos boletos se agregan? ");
                    int agregar = sc.nextInt();
                    bill1.agregarTickets(agregar);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("\nEstablecer saldo de tickets en: ");
                    int establecer = sc.nextInt();
                    bill1.setTickets(establecer);
                    System.out.println();
                    break;
                case 3:
                    if (BilleteraParque.isFestivo()) {
                        System.out.println("\n¡Precios de vacaciones!");
                        System.out.println("1. Camiseta (75 tickets)");
                        System.out.println("2. Sombrero (175 tickets)");
                        System.out.println("3. Tenis (300 tickets)");
                    } else {
                        System.out.println("\n1. Camiseta (150 tickets)");
                        System.out.println("2. Sombrero (350 tickets)");
                        System.out.println("3. Tenis (600 tickets)");
                    }
                    System.out.print("¿Qué premio desea comprar? ");
                    int premio = sc.nextInt();
                    int costo = 0;
                    switch (premio) {
                        case 1:
                            costo = BilleteraParque.isFestivo() ? 75 : 150;
                            break;
                        case 2:
                            costo = BilleteraParque.isFestivo() ? 175 : 350;
                            break;
                        case 3:
                            costo = BilleteraParque.isFestivo() ? 300 : 600;
                            break;
                        default:
                            System.out.println("Opción de premio inválida.");
                            System.out.println();
                            continue;
                    }
                    if (bill1.removerTickets(costo)) {
                        if (BilleteraParque.isFestivo()) {
                            System.out.println("Compré un " + (premio == 1 ? "camiseta" : premio == 2 ? "sombrero" : "tenis") + " por " + costo + " entradas");
                        } else {
                            System.out.println("Compré un " + (premio == 1 ? "camiseta" : premio == 2 ? "sombrero" : "tenis") + " por " + costo + " entradas");
                        }
                    } else {
                        System.out.println("No hay suficientes boletos para comprar un " + (premio == 1 ? "camiseta" : premio == 2 ? "sombrero" : "tenis"));
                    }
                    System.out.println();
                    break;
                case 4:
                    BilleteraParque.setFestivo();
                    if (BilleteraParque.isFestivo()) {
                        System.out.println("\nAhora es un día festivo.");
                    } else {
                        System.out.println("\nYa no es un día festivo.");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
                    System.out.println();
            }
        }
        sc.close();
    }
}
