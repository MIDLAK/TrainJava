import java.util.ArrayList;

public class MiddleTicket extends Ticket{

    MiddleTicket(){
        try {
            setPrice(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        options = new ArrayList<String>();
        options.add("\"мягкое\" место");
        options.add("1-разовое питание");
        options.add("туалет");
        options.add("провоз животных");
    }

    @Override
    public void printOptions() {
        System.out.println("В вагоне класса купе вам будут предложены следующие опции: ");
        for (String opt: options){
            System.out.println(opt);
        }
    }
}
