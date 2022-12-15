package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.camel.FidelityGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FidelityServiceImpl implements FidelityService {

    @Inject
    OrderDAO orderDao;

    @Inject
    PaymentService paymentService;

    @Inject
    FidelityGateway fidelityGateway;

    Integer clientId;

    @Override
    public Integer getTotalPoints(Integer client_id) {
        return null;
    }

    @Override
    public List<Integer> sendPointsToClientAccount(Integer pointsToAdd, Integer clientId) {
        pointsToAdd = pointsToAdd * 10;
        this.clientId = paymentService.getClientId();
        List<Integer> messageBody = new ArrayList<>();
        messageBody.add(pointsToAdd);
        messageBody.add(this.clientId);
        return messageBody;
    }

    @Override
    public List<Integer> sendFidelityInformation(Integer pointsToAdd, Integer clientId) {
        fidelityGateway.sendPointsToClientAccount(pointsToAdd,clientId);
        return null;
    }


}
