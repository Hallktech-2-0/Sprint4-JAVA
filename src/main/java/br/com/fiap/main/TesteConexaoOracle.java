package br.com.fiap.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexaoOracle {

    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String usuario = "rm552525";
        String senha = "120505";

        // Testa a conexão
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem-sucedida!");
            conexao.close(); // Fechar a conexão após o teste
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
