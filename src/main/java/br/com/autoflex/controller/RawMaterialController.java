package br.com.autoflex.controller;

import java.util.UUID;

import br.com.autoflex.entity.RawMaterial;
import br.com.autoflex.service.RawMaterialService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/raw-materials")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class RawMaterialController {
    RawMaterialService rawMaterialService;

    public RawMaterialController(RawMaterialService rawMaterialService) {
        this.rawMaterialService = rawMaterialService;
    }

    @POST
    public Response newRawMaterial(RawMaterial rawMaterial) {
        return Response.status(Response.Status.CREATED).entity(rawMaterialService.newRawMaterial(rawMaterial)).build();
    }

    @GET
    public Response listRawMaterials(@QueryParam("pageSize") @DefaultValue("10") Integer pageSize,

            @QueryParam("pageNumber") @DefaultValue("0") Integer pageNumber) {
        return Response.ok(rawMaterialService.listRawMaterials(pageNumber, pageSize)).build();
    }

    @GET
    @Path("/{rawMaterialId}")
    public Response listRawMaterial(@PathParam("rawMaterialId") UUID rawMaterialId) {
        return Response.ok(rawMaterialService.listRawMaterial(rawMaterialId)).build();
    }

    @PUT
    @Path("/{rawMaterialId}")
    public Response updateRawMaterial(@PathParam("rawMaterialId") UUID rawMaterialId, RawMaterial updatedRawMaterial) {
        return Response.ok(rawMaterialService.updateRawMaterial(rawMaterialId, updatedRawMaterial)).build();
    }

    @DELETE
    @Path("/{rawMaterialId}")
    public Response deleteRawMaterial(@PathParam("rawMaterialId") UUID rawMaterialId) {
        rawMaterialService.deleteRawMaterial(rawMaterialId);
        return Response.noContent().build();

    }

}
