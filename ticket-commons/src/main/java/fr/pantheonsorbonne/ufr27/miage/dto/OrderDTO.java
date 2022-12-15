package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Collection;
import java.util.Date;

public class OrderDTO {

    Integer orderId;

    Date localDate;

    Float orderPrice;

    Integer employeeId;

    Integer clientId;

    double totalPrice;

    Collection<OrderItemDTO> orderItemDTOS;

    public OrderDTO(Integer orderId, Date localDate, Float orderPrice, Integer employeeId, Integer clientId, double totalPrice, Collection<OrderItemDTO> productDTO) {
        this.orderId = orderId;
        this.localDate = localDate;
        this.orderPrice = orderPrice;
        this.employeeId = employeeId;
        this.clientId = clientId;
        this.totalPrice = totalPrice;
        this.orderItemDTOS = productDTO;
    }

    public OrderDTO(Integer orderId, Date localDate, Float orderPrice, Integer employeeId, double totalPrice, Collection<OrderItemDTO> orderItemDTOS) {
        this.orderId = orderId;
        this.localDate = localDate;
        this.orderPrice = orderPrice;
        this.employeeId = employeeId;
        this.totalPrice = totalPrice;
        this.orderItemDTOS = orderItemDTOS;
    }

    Collection<OrderItemDTO> productDTO;

    public OrderDTO() {
    }


    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Collection<OrderItemDTO> getOrderItemDTOS() {
        return orderItemDTOS;
    }

    public void setOrderItemDTOS(Collection<OrderItemDTO> orderItemDTOS) {
        this.orderItemDTOS = orderItemDTOS;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", localDate=" + localDate +
                ", orderPrice=" + orderPrice +
                ", employeeId=" + employeeId +
                ", clientId=" + clientId +
                ", productDTO=" + orderItemDTOS +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
