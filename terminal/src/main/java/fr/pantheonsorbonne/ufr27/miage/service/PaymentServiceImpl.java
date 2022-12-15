package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    @Inject
    OrderDAO orderDao;

    String url;

    Integer clientId;

    @Override
    public Integer stockClientId(Integer clientId){
        this.clientId = clientId;
        return this.clientId;
    }
    @Override
    public Integer getClientId() {
        return clientId;
    }

    @Override
    public Float isAbleForPayment(Integer orderId) throws OrderNotFoundException{
        Order o = orderDao.findSingleOrder(orderId);
        if(o.getClient() != null){
            this.stockClientId(o.getClient().getId());
        }
        if (o.getOrderPrice() > 0){
            return o.getOrderPrice();
            //init payment
            //send msg to bank to tell her we want to pay
        } else {
            //throw exception total <= 0
            throw new OrderNotFoundException(orderId);
        }
    }


    @Override
    public String readyToPay(Float totalPrice) {
        this.url = null;
        return "ok "+totalPrice;
    }

    @Override
    @Handler
    public String receiveURL(String url) {
        this.url = url;
        return this.url;
    }
}
