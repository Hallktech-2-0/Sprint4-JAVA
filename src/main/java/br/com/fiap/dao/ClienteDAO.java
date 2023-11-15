package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cliente;
import br.com.fiap.conexao.ConexaoFactory;

public class ClienteDAO {

    public List<Cliente> selecionar() throws SQLException, ClassNotFoundException {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM CLIENTE");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf_clie"));
                cliente.setNome(rs.getString("nome_clie"));
                cliente.setDataNascimento(rs.getDate("dt_nasc"));
                cliente.setSexo(rs.getString("sexo_clie").charAt(0));
                cliente.setTelefone(rs.getString("tel_clie"));
                cliente.setEndereco(rs.getString("endereco_clie"));
                cliente.setEmail(rs.getString("email_clie"));
                cliente.setSenha(rs.getString("senha"));

                clientes.add(cliente);
            }
        }

        return clientes;
    }

    public void cadastrar(Cliente cliente) throws SQLException, ClassNotFoundException {
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(
                "INSERT INTO CLIENTE (cpf_clie, nome_clie, dt_nasc, sexo_clie, tel_clie, endereco_clie, email_clie, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(4, String.valueOf(cliente.getSexo()));
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEndereco());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getSenha());

            stmt.executeUpdate();
        }
    }

    public void atualizar(Cliente cliente) throws SQLException, ClassNotFoundException {
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(
                "UPDATE CLIENTE SET nome_clie = ?, dt_nasc = ?, sexo_clie = ?, tel_clie = ?, endereco_clie = ?, email_clie = ?, senha = ? WHERE cpf_clie = ?")) {

            stmt.setString(1, cliente.getNome());
            stmt.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(3, String.valueOf(cliente.getSexo()));
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getSenha());
            stmt.setString(8, cliente.getCpf());

            stmt.executeUpdate();
        }
    }

    public void deletar(String cpf) throws SQLException, ClassNotFoundException {
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement("DELETE FROM CLIENTE WHERE cpf_clie = ?")) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();
        }
    }
}
