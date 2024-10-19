package org.leitorcsv;

import org.leitorcsv.model.ColunaDadosSimulacao;
import org.leitorcsv.utils.BancoDados;
import org.leitorcsv.utils.LeitorCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        // ao iniciar programa, abrir conexao com banco de dados
        Connection db = BancoDados.adquirir();

        // Abrir GUI aqui
        // ler dados CSV
        List<ColunaDadosSimulacao> valoresCSV = new LeitorCSV("/home/luis/Downloads/dados.csv").getValores();
        for (ColunaDadosSimulacao dadoSimulacao: valoresCSV) {
            // inserir todos os dados em banco de dados
            dadoSimulacao.inserirEmBancoDeDados(db);
        }
        // Logica apos GUI aqui

        // ao finalizar programa, limpar banco de dados. Quando criar o GUI, talvez tenha que mover essa logica para outro canto
        // ex quando fechar o GUI
        BancoDados.limparBanco();
    }
}
