package br.com.autoflex.controller;

import java.util.UUID;

import br.com.autoflex.dto.request.ProductRawMaterialRequestDTO;
import br.com.autoflex.service.ProductRawMaterialService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/product-raw-materials")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ProductRawMaterialController {

    ProductRawMaterialService productRawMaterialService;

    public ProductRawMaterialController(ProductRawMaterialService productRawMaterialService) {
        this.productRawMaterialService = productRawMaterialService;
    }

    @POST
    public Response createAssociation(@Valid ProductRawMaterialRequestDTO dto) {
        return Response.status(Response.Status.CREATED)
                .entity(productRawMaterialService.createAssociation(dto))
                .build();
    }

    @GET
    public Response listAll() {
        return Response.ok(productRawMaterialService.listAll()).build();
    }

    @GET
    @Path("/product/{productId}")
    public Response listByProduct(@PathParam("productId") UUID productId) {
        return Response.ok(productRawMaterialService.listByProduct(productId)).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        return Response.ok(productRawMaterialService.getById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAssociation(@PathParam("id") UUID id, @Valid ProductRawMaterialRequestDTO dto) {
        return Response.ok(productRawMaterialService.updateAssociation(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAssociation(@PathParam("id") UUID id) {
        productRawMaterialService.deleteAssociation(id);
        return Response.noContent().build();
    }

}
