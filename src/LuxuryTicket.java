import java.util.ArrayList;

public class LuxuryTicket extends Ticket {

    public LuxuryTicket(){
        try {
            setPrice(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        options = new ArrayList<String >();
        options.add("\"мягкое\" место");
        options.add("провоз животных");
        options.add("бар в вагоне");
        options.add("телевизор");
        options.add("wi-fi");
        options.add("посещение зала повышенной комфортности на станции отправления");
        options.add("3-разовое питание");
        options.add("душ, туалет + гигиенический набор");
        options.add("трансфер на такси до пункта назначения");
    }

    @Override
    public void printOptions() {
        System.out.println("В вагоне класса люкс вам будут предложены следующие опции: ");
        for (String opt: options){
            System.out.println(opt);
        }
    }
}
