package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.AccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.MaximumBonusPointsReachedException;
import fr.pantheonsorbonne.ufr27.miage.service.AccountService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.List;

@ApplicationScoped
public class FidelityGateway {

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    AccountService accountService;


    @Handler
    public Integer getTotalPoints(Integer client_id) throws AccountNotFoundException, javax.security.auth.login.AccountNotFoundException {
        return accountService.getTotalPoints(client_id);
    }

    @Handler
    void addPointsToAccount (List<Integer> clientInformation) throws AccountNotFoundException, MaximumBonusPointsReachedException, javax.security.auth.login.AccountNotFoundException {
        System.out.println(clientInformation);
        accountService.addPointsToAccount(clientInformation);
    }

    //@Handler
    public ClientDTO verifyAccount(Integer clientId) throws javax.security.auth.login.AccountNotFoundException {
        return accountService.verifyClientAccount(clientId);
    }
}
