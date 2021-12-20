import java.util.ArrayList;

public class EconomTicket extends Ticket{

    EconomTicket(){
        try {
            setPrice(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        options = new ArrayList<String>();
        options.add("туалет");
        options.add("холодная вода");
        options.add("бируши");
    }

    @Override
    public void printOptions() {
        System.out.println("В вагоне класса эконом вам будут предложены следующие опции: ");
        for (String opt: options){
            System.out.println(opt);
        }
    }
}
