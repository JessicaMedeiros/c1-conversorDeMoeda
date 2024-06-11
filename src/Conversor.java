import java.util.Map;

public class Conversor {

    public String calcularValorConversao(Double moeda, Double valor){
        ConversorDecimal conversorDecimal = new ConversorDecimal();
        return conversorDecimal.formatTwoDecimals(moeda * valor);
    }


}
