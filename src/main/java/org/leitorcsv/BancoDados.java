package org.leitorcsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {
    public static Connection db;
    private static void criarSchema(Connection db) throws SQLException {
        String schema = """
                CREATE TABLE IF NOT EXISTS DadosIndice  (
                    idDado INT PRIMARY KEY, 
                    abertura TEXT,
                    fechamento TEXT,
                    tempoOperacaoSecs INT,
                    qntCompra INT,
                    qntVenda INT,
                    precoCompra REAL,
                    precoVenda REAL,
                    precoMercado REAL,
                    medio REAL,
                    resIntervalo REAL,
                    resIntervaloPorcentagem REAL,
                    resOperacao,
                    resOperacaoPorcentagem REAL,
                    total INT,
                    TET INT,
                    nomePapel TEXT,
                    taxa REAL,
                    tempo TEXT
                ) 
                """;
        Statement stmt = db.createStatement();
        stmt.execute(schema);
    }

    private static void conectar() throws SQLException {
        db = DriverManager.getConnection("jdbc:sqlite:database.db");
        criarSchema(db);
    }
    public static Connection adquirir() throws SQLException {
        if (db == null) {
            conectar();
        }
        return db;
    }
}
