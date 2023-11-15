package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class ClienteBO {

    private ClienteDAO clienteDao;

    public ClienteBO() {
        this.clienteDao = new ClienteDAO();
    }

    // Selecionar
    public List<Cliente> selecionarBo() throws SQLException, ClassNotFoundException {
        return clienteDao.selecionar();
    }

    public void cadastrarBo(Cliente cliente) throws ClassNotFoundException, SQLException {
        clienteDao.cadastrar(cliente);
    }

    public void atualizarBo(Cliente cliente) throws ClassNotFoundException, SQLException {
        clienteDao.atualizar(cliente);
    }

    public void deletarBo(String cpf) throws ClassNotFoundException, SQLException {
        clienteDao.deletar(cpf);
    }
}
