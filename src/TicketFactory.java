public class TicketFactory {
    public Ticket createTicket(TypeCar type) {
        Ticket ticket = null;
        switch (type) {
            case LUX:
                ticket = new LuxuryTicket();
                break;
            case MIDDLE:
                ticket = new MiddleTicket();
                break;
            case ECONOM:
                ticket = new EconomTicket();
                break;
            default:
                throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return ticket;
    }
}
