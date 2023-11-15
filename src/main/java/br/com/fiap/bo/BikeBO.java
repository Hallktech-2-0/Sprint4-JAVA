package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.Bike;
import br.com.fiap.dao.BikeDAO;

public class BikeBO {

    private BikeDAO bikeDao;

    public BikeBO() {
        this.bikeDao = new BikeDAO();
    }

    // Selecionar
    public List<Bike> selecionarBo() throws SQLException, ClassNotFoundException {
        return bikeDao.selecionar();
    }

    public void cadastrarBo(Bike bike) throws ClassNotFoundException, SQLException {
        bikeDao.cadastrar(bike);
    }

    public void atualizarBo(Bike bike) throws ClassNotFoundException, SQLException {
        bikeDao.atualizar(bike);
    }

    public void deletarBo(String chassi) throws ClassNotFoundException, SQLException {
        bikeDao.deletar(chassi);
    }
}
