package logic_handel;
import entity.Bill;
import entity.BillDetail;
import entity.Customer;
import entity.Service;
import java.util.*;

public class BillManagement {
    private List<Bill> bills;
    private CustomerManagement customerManagement;
    private ServiceManagement serviceManagement;


    public BillManagement(CustomerManagement customerManagement, ServiceManagement serviceManagement) {
        this.bills = new ArrayList<>();
        this.customerManagement = customerManagement;
        this.serviceManagement = serviceManagement;
    }

    public void logBill() {
        System.out.println("Bạn muốn lập hóa đơn cho bao nhiêu khách hàng");
        int cusNumber;
        do {
            try {
                cusNumber = new Scanner(System.in).nextInt();
                if (cusNumber > 0) break;
                System.out.println("Số lượng nhập vào phải lớn hơn 0. Nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
        for (int i = 0; i < cusNumber; i++) {
            System.out.println("Nhập ID của khách hàng thứ " + (i + 1) + " mà bạn muốn lập hóa đơn: ");
            int cusId;
            Customer customer;
            do {
                try {
                    cusId = new Scanner(System.in).nextInt();
                    customer = customerManagement.findById(cusId);
                    if (customer != null) break;
                    System.out.println("ID không tồn tại trong hệ thống. Vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Vui lòng nhập số");
                }
            } while (true);

            System.out.println("Khách hàng này sử dụng bao nhiêu dịch vụ:");
            int serviceNumber;
            do {
                try {
                    serviceNumber = new Scanner(System.in).nextInt();
                    if (serviceNumber > 0 && serviceNumber <= 5) break;
                    System.out.println("Số lượng dịch vụ nhập vào từ 1 tới 5, nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Vui lòng nhập số");
                }
            } while (true);

            List<BillDetail> billDetails = new ArrayList<>();
            for (int j = 0; j < serviceNumber; j++) {
                System.out.println("Nhập mã dịch vụ thứ " + (j + 1) + " mà khách hàng này sử dụng: ");
                int serviceId;
                Service service;
                do {
                    try {
                        serviceId = new Scanner(System.in).nextInt();
                        service = serviceManagement.findById(serviceId);
                        if (service != null) break;
                        System.out.println("ID không tồn tại trong hệ thống, vui lòng nhập lại: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("Vui lòng nhập số");
                    }
                } while (true);

                System.out.println("Khách hàng này sử dụng dịch vụ vừa nhập là bao nhiêu: ");
                int quantity;
                do {
                    try {
                        quantity = new Scanner(System.in).nextInt();
                        if (quantity > 0) break;
                        System.out.println("Số lượng dịch vụ nhập vào phải lớn hơn 0, nhập lại");
                    } catch (InputMismatchException ex) {
                        System.out.println("Vui lòng nhập số");
                    }
                } while (true);

                BillDetail billDetail = new BillDetail(service, quantity);
                billDetails.add(billDetail);
            }
            Bill bill = new Bill(customer, billDetails);
            bills.add(bill);
        }
        mergeBills();
    }


    public void sortByName() {
        Collections.sort(bills, (o1, o2) -> o1.getCustomer().getName().compareToIgnoreCase(o2.getCustomer().getName()));
        showInfor();
    }

    public void mergeBills() {
        // Tạo một Map lưu trữ thông tin của từng khách hàng
        Map<Integer, Map<Service, Integer>> customerServiceMap = new HashMap<>();
        for (Bill bill : bills) {
            Customer customer = bill.getCustomer();
            Map<Service, Integer> serviceMap = customerServiceMap.getOrDefault(customer.getId(), new HashMap<>());
            for (BillDetail billDetail : bill.getBillDetails()) {
                Service service = billDetail.getService();
                int quantity = billDetail.getQuantity();
                serviceMap.put(service, serviceMap.getOrDefault(service, 0) + quantity);
            }
            customerServiceMap.put(customer.getId(), serviceMap);
        }

        // Tạo danh sách mới để lưu trữ các hóa đơn đã được gộp
        List<Bill> mergedBills = new ArrayList<>();

        // Duyệt qua Map và tạo các hóa đơn mới đã được gộp
        for (Map.Entry<Integer, Map<Service, Integer>> entry : customerServiceMap.entrySet()) {
            Customer customer = CustomerManagement.findById(entry.getKey());
            Map<Service, Integer> serviceMap = entry.getValue();
            if (!serviceMap.isEmpty()) {
                // Tạo một danh sách các BillDetail từ Map này
                List<BillDetail> billDetails = new ArrayList<>();
                for (Map.Entry<Service, Integer> serviceEntry : serviceMap.entrySet()) {
                    billDetails.add(new BillDetail(serviceEntry.getKey(), serviceEntry.getValue()));
                }
                Bill mergedBill = new Bill(customer, billDetails);
                mergedBills.add(mergedBill);
            }
        }
        // Cập nhật danh sách hóa đơn
        this.bills = mergedBills;
        showInfor();
        // In danh sách hóa đơn sau khi gộp
    }

    public void showInfor() {
        bills.forEach(System.out::println);
    }

    public void sortBillsByServiceUsage() {
        bills.sort((o1, o2) -> {
            int totalUsage1 = 0;
            for (BillDetail detail : o1.getBillDetails()) {
                totalUsage1 += detail.getQuantity();
            }
            int totalUsage2 = 0;
            for (BillDetail detail : o2.getBillDetails()) {
                totalUsage2 += detail.getQuantity();
            }
            return Integer.compare(totalUsage2, totalUsage1);
        });
        showInfor();
    }

    public void calculateTotal() {
        Map<Customer, List<Bill>> cusBillMap = new HashMap<>();
        // Thêm danh sách hóa đơn cho từng khách hàng vào Map
        for (Bill bill : bills) {
            Customer customer = bill.getCustomer();
            List<Bill> billListForClient = cusBillMap.getOrDefault(customer, new ArrayList<>());
            billListForClient.add(bill);
            cusBillMap.put(customer, billListForClient);
        }

         // Tính tổng tiền phải trả cho từng khách hàng và in ra tên và số tiền tương ứng
        for (Customer customer : cusBillMap.keySet()) {
            double totalAmount = 0;
            for (Bill bill : cusBillMap.get(customer)) {
                for (BillDetail billDetail : bill.getBillDetails()) {
                    totalAmount += billDetail.getService().getPrice() * billDetail.getQuantity();
                }
            }
            System.out.println("Tên khách hàng: " + customer.getName() + ", Tổng tiền phải trả: " + totalAmount);
        }

    }
}
