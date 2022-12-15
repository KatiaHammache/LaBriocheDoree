package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import fr.pantheonsorbonne.ufr27.miage.service.FidelityService;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FidelityGateway {


    @Inject
    OrderService orderService;

    @Inject
    FidelityService fidelityService;

    @Inject
    CamelContext camelContext;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Handler
    void setClientId(ClientDTO client){
        orderService.setClient(client.getClient_id());
    }

    public void sendFidelityInformation(Integer pointsToAdd, Integer clientId){
        try (ProducerTemplate producer = camelContext.createProducerTemplate()){
            List<Integer> sendingList = fidelityService.sendPointsToClientAccount(pointsToAdd,clientId);
            System.out.println("sendinglist" + fidelityService.sendPointsToClientAccount(pointsToAdd,clientId));
            producer.sendBody("direct:sendFidelity", sendingList);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Integer> sendPointsToClientAccount(Integer pointsToAdd, Integer clientId){
        return fidelityService.sendPointsToClientAccount(pointsToAdd,clientId);
    }
}
