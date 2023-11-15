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

import br.com.fiap.beans.Bike;
import br.com.fiap.bo.BikeBO;

@Path("/bikes")
public class BikeResource {
	

   private BikeBO bikeBO;

    public BikeResource() {
        this.bikeBO = new BikeBO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bike> getBikes() throws SQLException, ClassNotFoundException {
        return bikeBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBike(Bike bike) throws SQLException, ClassNotFoundException {
        bikeBO.cadastrarBo(bike);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBike(Bike bike) throws SQLException, ClassNotFoundException {
        bikeBO.atualizarBo(bike);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{chassi}")
    public Response deleteBike(@PathParam("chassi") String chassi) throws SQLException, ClassNotFoundException {
        bikeBO.deletarBo(chassi);
        return Response.ok().build();
    }
}


