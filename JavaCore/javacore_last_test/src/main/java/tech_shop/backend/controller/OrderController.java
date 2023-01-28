package tech_shop.backend.controller;

import tech_shop.backend.model.Feedback;
import tech_shop.backend.model.Order;
import tech_shop.backend.service.OrderService;

import java.util.List;

public class OrderController {
    OrderService orderService=new OrderService();
    public int getIdoder() {
        return orderService.getIdOrder();
    }

    public List<Order> getOrder(String email) {
        return orderService.getOrder(email);
    }

    public void creatOrder(Order order) {
        orderService.creatOrder(order);
    }

    public List<Order> allOrder() {
        return orderService.allOder();
    }

    public void cancelOrder(int code) {
        orderService.cancelOrder(code);
    }

    public List<Order> getOrderDelivering(String email) {
        return orderService.getOrderDelivering(email);
    }

    public List<Order> getOrderCancel(String email) {
        return orderService.getOrderCancel(email);
    }

    public List<Order> getOrderReiceved(String email) {
        return orderService.getOrderReiceved(email);
    }

    public void receivedOrd(int code) {
        orderService.reicevedOrd(code);
    }

    public List<Order> getOr() {
       return orderService.getOr();
    }

    public void approveAll() {
        orderService.approveAll();
    }

    public void creatFeedback(Feedback feedback) {
        orderService.creatFeedback(feedback);
    }

    public Order findOrByid(int code) {
        return orderService.findOrById(code);
    }

    public List<Feedback> getfeedback() {
        return orderService.getFeedback();
    }

    public int getCount() {
        return orderService.getCount();
    }

    public int getMoneyD() {
        return orderService.getMoneyD();
    }

    public int getCountM() {
        return orderService.getCountM();
    }

    public int getMoneyM() {
        return orderService.getMoneyM();
    }
}
