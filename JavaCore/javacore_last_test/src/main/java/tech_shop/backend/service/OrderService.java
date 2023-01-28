package tech_shop.backend.service;

import tech_shop.backend.exception.NotFoundException;
import tech_shop.backend.model.Feedback;
import tech_shop.backend.model.Order;
import tech_shop.backend.model.OrderStatus;
import tech_shop.backend.repository.OrderRepository;
import tech_shop.backend.utils.FunctionUtils;

import java.lang.invoke.StringConcatException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderService {
    OrderRepository orderRepository=new OrderRepository();
    ArrayList<Order>orders=orderRepository.findAll();
    ArrayList<Feedback>feedbacks=orderRepository.AllFb();
    public int getIdOrder() {
        int max = 0;
        for (Order order : orders) {
            if (order.getId() > max) {
                max = order.getId();
            }
        }
        return max + 1;
    }

    public List<Order> getOrder(String email) {
        List<Order>orderList=new ArrayList<>();
        for (Order order:orders) {
            if (order.getEmail().equalsIgnoreCase(email)&&order.getOrderStatus().equals(OrderStatus.CHỜ_PHÊ_DUYỆT)){
                orderList.add(order);
            }
        }
        return orderList;
    }

    public void creatOrder(Order order) {
        orderRepository.creatOrder(order);
    }

    public List<Order> allOder() {
        return orders;
    }

    public void cancelOrder(int code) {
        orderRepository.cancelOrder(code);
    }

    public List<Order> getOrderDelivering(String email) {
        List<Order>orderDelivering=new ArrayList<>();
        for (Order order:allOder()) {
            if (order.getEmail().equalsIgnoreCase(email)&&order.getOrderStatus().equals(OrderStatus.ĐANG_GIAO)){
                orderDelivering.add(order);
            }
        }
        return orderDelivering;
    }

    public List<Order> getOrderCancel(String email) {
        List<Order>orderCancel=new ArrayList<>();
        for (Order order:allOder()) {
            if (order.getEmail().equalsIgnoreCase(email)&&order.getOrderStatus().equals(OrderStatus.ĐÃ_HỦY)){
                orderCancel.add(order);
            }
        }
        return orderCancel;
    }

    public List<Order> getOrderReiceved(String email) {
        List<Order>orderReiceved=new ArrayList<>();
        for (Order order:allOder()) {
            if (order.getEmail().equalsIgnoreCase(email)&&order.getOrderStatus().equals(OrderStatus.ĐÃ_NHẬN_HÀNG)){
                orderReiceved.add(order);
            }
        }
        return orderReiceved;
    }

    public void reicevedOrd(int code) {
        orderRepository.reicevedOrd(code);
    }

    public List<Order> getOr() {
        List<Order>Or=new ArrayList<>();
        for (Order order:allOder()) {
            if (order.getOrderStatus().equals(OrderStatus.CHỜ_PHÊ_DUYỆT)){
                Or.add(order);
            }
        }
        return Or;
    }

    public void approveAll() {
        orderRepository.approveAll();
    }

    public void creatFeedback(Feedback feedback) {
        orderRepository.creatFeedback(feedback);
    }

    public Order findOrById(int code) {
        for (Order order:allOder()) {
            if (order.getId()==code){
                return order;
            }
        }
        throw new NotFoundException("Không Có Đơn Hàng Nào Có Mã "+code);
    }

    public List<Feedback> getFeedback() {
        return feedbacks;
    }

    public int getCount() {
        int count=0;
        for (Order oder:allOder()) {
            String[] dateNow= FunctionUtils.salesDate().split("/");
            String[] dateInOr=oder.getTime().split("/");
            if (dateNow[1].equals(dateInOr[1])&&oder.getOrderStatus().equals(OrderStatus.ĐÃ_NHẬN_HÀNG)){
                count++;
            }
        }
        return count;
    }

    public int getMoneyD() {
        int money=0;
        for (Order oder:allOder()) {
            String[] dateNow= FunctionUtils.salesDate().split("/");
            String[] dateInOr=oder.getTime().split("/");
            if (dateNow[1].equals(dateInOr[1])&&oder.getOrderStatus().equals(OrderStatus.ĐÃ_NHẬN_HÀNG)){
                money+=FunctionUtils.totalOderMoney(oder);
            }
        }
        return money;
    }

    public int getCountM() {
        int count=0;
        for (Order oder:allOder()) {
            String[] dateNow= FunctionUtils.salesDate().split("/");
            String[] dateInOr=oder.getTime().split("/");
            if (dateNow[1].equals(dateInOr[1])&&oder.getOrderStatus().equals(OrderStatus.ĐÃ_NHẬN_HÀNG)){
                count++;
            }
        }
        return count;
    }

    public int getMoneyM() {
        int money=0;
        for (Order oder:allOder()) {
            String[] monthNow= FunctionUtils.salesM().split("/");
            String[] monthInOr=oder.getTime().split("/");
            if (monthNow[0].equals(monthInOr[1])&&oder.getOrderStatus().equals(OrderStatus.ĐÃ_NHẬN_HÀNG)){
                money+=FunctionUtils.totalOderMoney(oder);
            }
        }
        return money;
    }
}
