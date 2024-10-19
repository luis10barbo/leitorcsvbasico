package org.leitorcsv.utils;

import org.leitorcsv.model.ColunaDadosSimulacao;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeitorCSV {

    private boolean eValorNulo(String valor) {
        return valor.strip().equals("-");
    }

    private String valorStringOuNulo(String valor) {
        if (eValorNulo(valor)) {
            return null;
        }

        // TODO: adicionar validacao para data e fazer conversao
        // string
        return valor;
    }

    private Float valorFloatOuNulo(String valor) {
        if (eValorNulo(valor)) {
            return null;
        }


        // Check if float
        try {
            return Float.parseFloat(valor);
        } catch(NumberFormatException e) {
            // Not float
        }
        return null;
    }

    private Integer valorIntOuNulo(String valor) {
        if (eValorNulo(valor)) {
            return null;
        }

        // Check if int
        try {
            return Integer.parseInt(valor);
        } catch(NumberFormatException e) {
            // Not int
        }
        return null;
    }
    private List<ColunaDadosSimulacao> records = new ArrayList<>();

    public List<ColunaDadosSimulacao> getValores() {
        return records;
    }

    public LeitorCSV(String caminhoArquivoCSV) throws IOException {
        int numLinha = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoCSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                // IGNORAR AS 6 PRIMEIRAS LINHAS, SEM DADOS UTEIS.
                if (numLinha < 6) {
                    numLinha++;
                    continue;
                }
                String[] values = line.split(";");
                records.add(
                        new ColunaDadosSimulacao(
                                valorStringOuNulo(values[0]),
                                valorStringOuNulo(values[1]),
                                valorStringOuNulo(values[2]),
                                valorStringOuNulo(values[3]),
                                valorIntOuNulo(values[4]),
                                valorIntOuNulo(values[5]),
                                valorFloatOuNulo(values[6]),
                                valorFloatOuNulo(values[7]),
                                valorFloatOuNulo(values[8]),
                                valorFloatOuNulo(values[9]),
                                valorFloatOuNulo(values[10]),
                                valorFloatOuNulo(values[11]),
                                valorFloatOuNulo(values[12]),
                                valorIntOuNulo(values[0]),
                                valorIntOuNulo(values[0]),
                                null,
                                null,
                                null

                        )
                );
            }
        }
    }
}
