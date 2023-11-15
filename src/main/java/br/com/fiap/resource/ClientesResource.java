package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.beans.Cliente;
import br.com.fiap.bo.ClienteBO;

@Path("/clientes")
public class ClientesResource {

    private ClienteBO clienteBO;

    public ClientesResource() {
        this.clienteBO = new ClienteBO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {
        return clienteBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        clienteBO.cadastrarBo(cliente);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        clienteBO.atualizarBo(cliente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{cpf}")
    public Response deleteCliente(@PathParam("cpf") String cpf) throws SQLException, ClassNotFoundException {
        clienteBO.deletarBo(cpf);
        return Response.ok().build();
    }
}
