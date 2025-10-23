// S23017358 Rojas Santos Rogelio

public class BilleteraParque {
    private int tickets = 0;
    private static boolean festivo = false;

    public BilleteraParque(int tickets) {
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    public static boolean isFestivo() {
        return festivo;
    }

    public void setTickets(int tickets) {
        if (tickets >= 0) {
            this.tickets = tickets;
        }
    }

    public static void setFestivo() {
        if (festivo == false) {
            festivo = true;
        } else {
            festivo = false;
        }
    }

    public void agregarTickets(int tickets) {
        if (tickets > 0) {
            this.tickets += tickets;
        }
    }

    public boolean removerTickets(int tickets) {
        if (tickets > 0 && this.tickets >= tickets) {
            this.tickets -= tickets;
            return true;
        }
        return false;
    }
}
