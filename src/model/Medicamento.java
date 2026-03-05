package model;

public class Medicamento {

    private String nome;
    private String sintoma;
    private int intervaloHoras;

    public Medicamento(String nome, String sintoma, int intervaloHoras) {
        this.nome = nome;
        this.sintoma = sintoma;
        this.intervaloHoras = intervaloHoras;
    }

    public String getNome() {
        return nome;
    }

    public String getSintoma() {
        return sintoma;
    }

    public int getIntervaloHoras() {
        return intervaloHoras;
    }

    @Override
    public String toString() {
        return "Medicamento: " + nome +
               "\nSintoma: " + sintoma +
               "\nIntervalo: a cada " + intervaloHoras + " horas" +
               "\n⚠ Consulte um profissional de saúde.";
    }
}