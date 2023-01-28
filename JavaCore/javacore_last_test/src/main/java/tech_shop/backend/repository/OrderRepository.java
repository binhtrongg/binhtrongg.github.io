package tech_shop.backend.repository;

import tech_shop.backend.database.OrderDatabase;
import tech_shop.backend.exception.NotFoundException;
import tech_shop.backend.model.Feedback;
import tech_shop.backend.model.Order;
import tech_shop.backend.model.OrderStatus;
import tech_shop.backend.utils.FileUtils;

import java.util.ArrayList;

public class OrderRepository {
    public ArrayList<Order> findAll() {
        return OrderDatabase.allOders;
    }
    public ArrayList<Feedback> AllFb() {
        return OrderDatabase.allFb;
    }

    public void creatOrder(Order order) {
        findAll().add(order);
        FileUtils.saveDataToFile("order.json",findAll());
    }
    public Order findOrderById(int id){
        for (Order order:findAll()) {
            if (order.getId()==id){
                return order;
            }
        }
        throw new NotFoundException("Không Có Đơn Hàng Nào Có Mã "+id);
    }
    public void cancelOrder(int code) {
        Order order=findOrderById(code);
        order.setOrderStatus(OrderStatus.ĐÃ_HỦY);
        FileUtils.saveDataToFile("order.json",findAll());
    }

    public void reicevedOrd(int code) {
        Order order=findOrderById(code);
        order.setOrderStatus(OrderStatus.ĐÃ_NHẬN_HÀNG);
        FileUtils.saveDataToFile("order.json",findAll());
    }

    public void approveAll() {
        for (Order order:findAll()) {
            if (order.getOrderStatus().equals(OrderStatus.CHỜ_PHÊ_DUYỆT)){
                order.setOrderStatus(OrderStatus.ĐANG_GIAO);
            }
        }
        FileUtils.saveDataToFile("order.json",findAll());
    }

    public void creatFeedback(Feedback feedback) {
        AllFb().add(feedback);
        FileUtils.saveDataToFile("feedback.json",AllFb());
    }
}
