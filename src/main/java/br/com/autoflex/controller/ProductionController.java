package br.com.autoflex.controller;

import br.com.autoflex.service.ProductionService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/production")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ProductionController {

    ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GET
    @Path("/suggestion")
    public Response getProductionSuggestion() {
        return Response.ok(productionService.calculateProductionSuggestion()).build();
    }
}