package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.PasswordIncorrectException;
import fr.pantheonsorbonne.ufr27.miage.exception.SoldUnsifficientException;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("payment")
public class PaymentResource {

    @Inject
    PaymentService paymentService;

    @Location("paymentTemplate.html")
    Template paymentTemplate;

    @Location("doneTemplate.html")
    Template doneTemplate;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(){
        return paymentTemplate.instance();
    }

    @Path("authentification")
    @POST
    @Consumes(MediaType.TEXT_HTML)
    public Response cardPayment(@FormParam("clientId") Integer clientId, @FormParam("password") Integer password)  {
        try {

            return Response.accepted(paymentService.cardPayment(clientId,password)).build();

        } catch (ClientNotFoundException e) {
            throw new WebApplicationException(404);
        } catch (PasswordIncorrectException e) {
            throw new WebApplicationException(404);
        } catch (SoldUnsifficientException e) {
            throw new WebApplicationException(404);
        }
    }
//
//    @Path("client/{clientId}/password/{password}")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response cardPayment(@PathParam("clientId") Integer clientId, @PathParam("password") Integer password) throws ClientNotFoundException, SoldUnsifficientException, PasswordIncorrectException {
//        return Response.ok(paymentService.cardPayment(clientId,password)).build();
//    }

}
