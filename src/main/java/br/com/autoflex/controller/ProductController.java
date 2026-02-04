package br.com.autoflex.controller;

import java.util.UUID;

import br.com.autoflex.entity.Product;
import br.com.autoflex.service.ProductService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @POST
    public Response newProduct(Product product) {
        return Response.status(Response.Status.CREATED).entity(productService.newProduct(product)).build();
    }

    @GET
    public Response listProducts(@QueryParam("pageSize") @DefaultValue("10") Integer pageSize,

            @QueryParam("pageNumber") @DefaultValue("0") Integer pageNumber) {
        return Response.ok(productService.listProducts(pageNumber, pageSize)).build();
    }

    @GET
    @Path("/{productId}")
    public Response listProduct(@PathParam("productId") UUID productId) {
        return Response.ok(productService.listProduct(productId)).build();
    }

    @PUT
    @Path("/{productId}")
    public Response updateProduct(@PathParam("productId") UUID productId, Product updatedProduct) {
        return Response.ok(productService.updateProduct(productId, updatedProduct)).build();
    }

    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") UUID productId) {
        productService.deleteProduct(productId);
        return Response.noContent().build();
    }

}
