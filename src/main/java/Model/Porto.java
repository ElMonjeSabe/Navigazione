package Model;

public class Porto {


    private String NomePorto;
    private String Citta;
    private String Nazione;
    private int idPorto;



    public Porto(String nomePorto, String citta, String nazione, int idPorto) {
        NomePorto = nomePorto;
        Citta = citta;
        Nazione = nazione;
        this.idPorto=idPorto;
    }


    public String getNomePorto() {
        return NomePorto;
    }

    public String getCitta() {
        return Citta;
    }

    public String getNazione() {
        return Nazione;
    }

    public int getIdPorto() {
        return idPorto;
    }

}
