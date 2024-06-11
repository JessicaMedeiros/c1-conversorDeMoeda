import java.util.Map;

public class FiltrarMoedas {

    public double buscarTaxaParaConversaoPelaMoeda(Map<String, Double> conversion_rates, String codigo_moeda){

        if (conversion_rates.containsKey(codigo_moeda)) {
            return conversion_rates.get(codigo_moeda);
        } else {
            throw new IllegalArgumentException("Código da moeda desconhecudo: " + codigo_moeda);
        }

    }

}
