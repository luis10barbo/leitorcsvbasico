package org.leitorcsv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {
    public static Connection dbInseguro;
    private static void criarSchema(Connection db) throws SQLException {
        String schema = """
                CREATE TABLE IF NOT EXISTS Pesquisa (
                    idPesquisa INTEGER PRIMARY KEY AUTOINCREMENT
                );
                CREATE TABLE IF NOT EXISTS DadosIndice  (
                    idDado INTEGER PRIMARY KEY AUTOINCREMENT,
                    idPesquisa INTEGER NOT NULL,
                    abertura TEXT,
                    fechamento TEXT,
                    tempoOperacaoSecs INTEGER,
                    qntCompra INTEGER,
                    qntVenda INTEGER,
                    precoCompra REAL,
                    precoVenda REAL,
                    precoMercado REAL,
                    medio REAL,
                    resIntervalo REAL,
                    resIntervaloPorcentagem REAL,
                    resOperacao,
                    resOperacaoPorcentagem REAL,
                    total INTEGER,
                    TET INTEGER,
                    nomePapel TEXT,
                    taxa REAL,
                    tempo TEXT,
                    FOREIGN KEY idPesquisa REFERENCES Pesquisa(idPesquisa)
                ) 
                """;
        Statement stmt = db.createStatement();
        stmt.execute(schema);
    }

    public static void limparBanco() throws SQLException {
        Connection db = adquirir();
        Statement stmt = db.createStatement();
        stmt.execute("DELETE FROM DadosIndice;");
    }

    private static Connection conectar() throws SQLException {
        dbInseguro = DriverManager.getConnection("jdbc:sqlite:database.db");
        criarSchema(dbInseguro);
        return dbInseguro;
    }
    public static Connection adquirir() throws SQLException {
        Connection db = dbInseguro;
        if (dbInseguro == null) {
            db = conectar();
        }
        return db;
    }
}
