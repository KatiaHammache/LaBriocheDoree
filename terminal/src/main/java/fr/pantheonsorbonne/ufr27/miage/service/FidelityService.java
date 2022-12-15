package fr.pantheonsorbonne.ufr27.miage.service;

import java.util.List;

public interface FidelityService {

    Integer getTotalPoints (Integer client_id);

    List<Integer> sendPointsToClientAccount(Integer pointsToAdd,Integer clientId);

    List<Integer> sendFidelityInformation(Integer pointsToAdd, Integer clientId);
}
