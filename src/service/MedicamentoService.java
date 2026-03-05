package service;

import model.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoService {

    private List<Medicamento> listaMedicamentos = new ArrayList<>();

    public MedicamentoService() {

        listaMedicamentos.add(new Medicamento("Dipirona ou Paracetamol", "febre", 6));
        listaMedicamentos.add(new Medicamento("Dipirona ou Paracetamol", "dor de cabeça", 6));
        listaMedicamentos.add(new Medicamento("Ibuprofeno ou Diclofenaco", "dor no corpo", 8));
        listaMedicamentos.add(new Medicamento("Ibuprofeno ou Diclofenaco", "inflamação", 8));
        listaMedicamentos.add(new Medicamento("Escopolamina (Buscopan)", "cólica", 8));
        listaMedicamentos.add(new Medicamento("Hidróxido de Alumínio ou Omeprazol", "azia", 12));
        listaMedicamentos.add(new Medicamento("Simeticona (Luftal)", "gases", 8));
        listaMedicamentos.add(new Medicamento("Metoclopramida (Plasil) ou Ondansetrona", "enjoo", 8));
        listaMedicamentos.add(new Medicamento("Metoclopramida (Plasil) ou Ondansetrona", "vômito", 8));
        listaMedicamentos.add(new Medicamento("Ciclobenzaprina ou Orfenadrina (Dorflex)", "dor muscular", 12));
        listaMedicamentos.add(new Medicamento("Loratadina ou Dexclorfeniramina (Polaramine)", "alergia", 24));
        listaMedicamentos.add(new Medicamento("Loratadina ou Dexclorfeniramina (Polaramine)", "coriza", 24));
        listaMedicamentos.add(new Medicamento("Cetoprofeno ou Benzidamina (Flanax/Ciflogex)", "dor de garganta", 12));
        listaMedicamentos.add(new Medicamento("Loperamida (Imosec) ou Floratil", "diarreia", 8));
    }

    public Medicamento buscarPorSintoma(String sintoma) {

        for (Medicamento m : listaMedicamentos) {
            if (m.getSintoma().equalsIgnoreCase(sintoma)) {
                return m;
            }
        }

        return null;
    }
}