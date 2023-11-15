package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Bike;
import br.com.fiap.conexao.ConexaoFactory;

public class BikeDAO {

    public List<Bike> selecionar() throws SQLException, ClassNotFoundException {
        List<Bike> bikes = new ArrayList<>();
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM BIKE");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Bike bike = new Bike();
                bike.setChassi(rs.getString("chassi"));
                bike.setMarca(rs.getString("marca"));
                bike.setModelo(rs.getString("modelo"));
                bike.setCor(rs.getString("cor"));
                bike.setAro(rs.getDouble("aro"));
                bike.setQuadro(rs.getString("quadro"));
                bike.setPeso(rs.getDouble("peso"));
                bike.setModalidade(rs.getString("modalidade"));
                bike.setValorTotal(rs.getDouble("vl_total")); // Corrigido o nome da coluna
                bike.setClienteCpf(rs.getString("cliente_cpf_clie")); // Corrigido o nome da coluna

                bikes.add(bike);
            }
        }

        return bikes;
    }

    public void cadastrar(Bike bike) throws SQLException, ClassNotFoundException {
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(
                "INSERT INTO BIKE (chassi, marca, modelo, cor, aro, quadro, peso, modalidade, vl_total, cliente_cpf_clie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, bike.getChassi());
            stmt.setString(2, bike.getMarca());
            stmt.setString(3, bike.getModelo());
            stmt.setString(4, bike.getCor());
            stmt.setDouble(5, bike.getAro());
            stmt.setString(6, bike.getQuadro());
            stmt.setDouble(7, bike.getPeso());
            stmt.setString(8, bike.getModalidade());
            stmt.setDouble(9, bike.getValorTotal());
            stmt.setString(10, bike.getClienteCpf());

            stmt.executeUpdate();
        }
    }

    public void atualizar(Bike bike) throws SQLException, ClassNotFoundException {
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(
                "UPDATE BIKE SET marca = ?, modelo = ?, cor = ?, aro = ?, quadro = ?, peso = ?, modalidade = ?, vl_total = ?, cliente_cpf_clie = ? WHERE chassi = ?")) {

            stmt.setString(1, bike.getMarca());
            stmt.setString(2, bike.getModelo());
            stmt.setString(3, bike.getCor());
            stmt.setDouble(4, bike.getAro());
            stmt.setString(5, bike.getQuadro());
            stmt.setDouble(6, bike.getPeso());
            stmt.setString(7, bike.getModalidade());
            stmt.setDouble(8, bike.getValorTotal());
            stmt.setString(9, bike.getClienteCpf());
            stmt.setString(10, bike.getChassi());

            stmt.executeUpdate();
        }
    }

    public void deletar(String chassi) throws SQLException, ClassNotFoundException {
        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement("DELETE FROM BIKE WHERE chassi = ?")) {

            stmt.setString(1, chassi);
            stmt.executeUpdate();
        }
    }
}
