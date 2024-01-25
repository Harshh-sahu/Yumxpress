/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.OrderPojo;
import yumxpress.pojo.PlaceOrderPojo;
import yumxpress.pojo.ProductPojo;

/**
 *
 * @author harsh
 */
public class OrderDAO {

    public static String getNewId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(order_id) from orders");
        rs.next();
        String id = rs.getString(1);
        String ordId = "";
        if (id != null) {
            id = id.substring(4);
            ordId = "ORD-" + (Integer.parseInt(id) + 1);
        } else {
            ordId = "ORD-101";
        }
        return ordId;
    }

    public static String placeOrder(PlaceOrderPojo placeOrder) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
        placeOrder.setOrderId(getNewId());
        ps.setString(1, placeOrder.getOrderId());
        ps.setString(2, placeOrder.getProductId());
        ps.setString(3, placeOrder.getCustomerId());
        ps.setString(4, placeOrder.getDeliveryStaffId());
        ps.setString(5, "");
        ps.setString(6, "ORDERED");
        ps.setString(7, placeOrder.getCompanyId());
        Random rand = new Random();
        int otp = rand.nextInt(1000);
        ps.setInt(8, otp);
        if (ps.executeUpdate() == 1) {
            return placeOrder.getOrderId();
        }
        return null;
    }

    public static OrderPojo getOrderDetailsByOrderId(String orderId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT c.customer_name, c.address, s.staff_name, c.mobile_no, co.company_name,co.email_id, p.product_name, p.product_price, o.otp "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "JOIN companies co ON o.company_id = co.company_id "
                + "JOIN customers c ON o.customer_id = c.customer_id "
                + "JOIN staff s ON o.staff_id = s.staff_id "
                + "WHERE o.order_id = ?";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, orderId);
        ResultSet rs = ps.executeQuery();
        OrderPojo order = null;
        if (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(orderId);

            order.setCustomerName(rs.getString("customer_name"));
            order.setCustomerAddress(rs.getString("address"));
            order.setDeliveryStaffName(rs.getString("staff_name"));
            order.setCustomerPhoneNo(rs.getString("mobile_no"));
            order.setCompanyName(rs.getString("company_name"));
            order.setCompanyEmailId(rs.getString("email_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));
            order.setOtp(rs.getInt("otp"));

        }
        return order;
    }

    public static List<OrderPojo> getNewOrdersForStaff(String staffId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT o.order_id, o.otp, p.product_name, p.product_price, c.customer_name, c.address, c.mobile_no "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "JOIN customers c ON o.customer_id = c.customer_id "
                + "WHERE o.staff_id = ? "
                + "  AND o.status = 'ORDERED' "
                + "ORDER BY o.order_id DESC";

        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, staffId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> orderList = new ArrayList<>();
        OrderPojo order = null;
        while (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setCustomerAddress(rs.getString("address"));
            order.setCustomerPhoneNo(rs.getString("mobile_no"));
            order.setOtp(rs.getInt("otp"));
            orderList.add(order);

        }
        return orderList;
    }

    public static boolean confirmOrder(String orderId) throws SQLException {

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update orders set status ='DELIVERED' where order_id=?");
        ps.setString(1, orderId);
        return ps.executeUpdate() == 1;

    }

    public static List<OrderPojo> getOrderHistory(String staffId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT P.PRODUCT_NAME, P.PRODUCT_PRICE, C.CUSTOMER_NAME, C.ADDRESS, O.REVIEW "
                + "FROM ORDERS O "
                + "JOIN PRODUCTS P ON O.PRODUCT_ID = P.PRODUCT_ID "
                + "JOIN CUSTOMERS C ON O.CUSTOMER_ID = C.CUSTOMER_ID "
                + "WHERE O.STATUS = 'DELIVERED' AND O.STAFF_ID = ? ";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, staffId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> orderHistoryList = new ArrayList<>();
        OrderPojo orderHistory = null;
        while (rs.next()) {
            orderHistory = new OrderPojo();
            orderHistory.setProductName(rs.getString("product_name"));
            orderHistory.setProductPrice(rs.getDouble("product_price"));
            orderHistory.setCustomerName(rs.getString("customer_name"));
            orderHistory.setCustomerAddress(rs.getString("address"));
            orderHistory.setReview(rs.getString("review"));
            orderHistoryList.add(orderHistory);

        }
        return orderHistoryList;
    }

    // customer can update review in the database 
    public static List<OrderPojo> getCustomerOrderHistory(String customerId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT O.ORDER_ID, P.PRODUCT_NAME, P.PRODUCT_PRICE, S.STAFF_NAME AS DELIVERY_STAFF, "
                + "C.COMPANY_NAME, CUST.ADDRESS, O.REVIEW "
                + "FROM ORDERS O "
                + "JOIN PRODUCTS P ON O.PRODUCT_ID = P.PRODUCT_ID "
                + "JOIN STAFF S ON O.STAFF_ID = S.STAFF_ID "
                + "JOIN COMPANIES C ON O.COMPANY_ID = C.COMPANY_ID "
                + "JOIN CUSTOMERS CUST ON O.CUSTOMER_ID = ? "
                + "WHERE O.STATUS = 'DELIVERED'";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, customerId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> CustomerorderHistoryList = new ArrayList<>();
        OrderPojo orderHistory = null;
        while (rs.next()) {
            orderHistory = new OrderPojo();
            orderHistory.setOrderId(rs.getString("order_id"));

            orderHistory.setProductName(rs.getString("product_name"));
            orderHistory.setProductPrice(rs.getDouble("product_price"));
            orderHistory.setDeliveryStaffName(rs.getString("delivery_staff"));
            orderHistory.setCompanyName(rs.getString("company_name"));
            orderHistory.setCustomerAddress(rs.getString("address"));
            orderHistory.setReview(rs.getString("review"));
            CustomerorderHistoryList.add(orderHistory);

        }
        return CustomerorderHistoryList;
    }

//Update Customer Review
    public static boolean Updatereview(String orderId, String newreview) throws SQLException {

        Connection conn = DBConnection.getConnection();

        String updateQuery = "UPDATE ORDERS SET REVIEW = ? WHERE ORDER_ID = ?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
        ps.setString(1, newreview);
        ps.setString(2, orderId);
        return ps.executeUpdate() == 1;

    }

    public static boolean CancelOrder(String orderId) throws SQLException {

        Connection conn = DBConnection.getConnection();

        String updateQuery = "DELETE FROM ORDERS WHERE ORDER_ID = ?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
        ps.setString(1, orderId);
        int rowsDeleted = ps.executeUpdate();
        return rowsDeleted > 0;

    }

    public static List<OrderPojo> getCustomerOrders(String customerId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT O.ORDER_ID, P.PRODUCT_NAME, P.PRODUCT_PRICE, S.STAFF_NAME AS DELIVERY_STAFF, CUST.ADDRESS "
                + "FROM ORDERS O "
                + "JOIN PRODUCTS P ON O.PRODUCT_ID = P.PRODUCT_ID "
                + "JOIN STAFF S ON O.STAFF_ID = S.STAFF_ID "
                + "JOIN CUSTOMERS CUST ON O.CUSTOMER_ID = ? "
                + "WHERE O.STATUS = 'ORDERED'";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, customerId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> CustomerorderList = new ArrayList<>();
        OrderPojo orderHistory = null;
        while (rs.next()) {
            orderHistory = new OrderPojo();
            orderHistory.setOrderId(rs.getString("order_id"));

            orderHistory.setProductName(rs.getString("product_name"));
            orderHistory.setProductPrice(rs.getDouble("product_price"));
            orderHistory.setDeliveryStaffName(rs.getString("delivery_staff"));
            orderHistory.setCustomerAddress(rs.getString("address"));

            CustomerorderList.add(orderHistory);

        }
        return CustomerorderList;
    }

    public static List<OrderPojo> getAllCompanyOrders(String companyId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT P.PRODUCT_NAME, P.PRODUCT_PRICE, CUST.CUSTOMER_NAME, "
                + "ST.STAFF_NAME AS DELIVERY_STAFF, CUST.ADDRESS, O.REVIEW, O.STATUS "
                + "FROM ORDERS O "
                + "JOIN PRODUCTS P ON O.PRODUCT_ID = P.PRODUCT_ID "
                + "JOIN CUSTOMERS CUST ON O.CUSTOMER_ID = CUST.CUSTOMER_ID "
                + "LEFT JOIN STAFF ST ON O.STAFF_ID = ST.STAFF_ID "
                + "WHERE (O.STATUS = 'ORDERED' OR O.STATUS = 'DELIVERED') "
                + "AND O.COMPANY_ID = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, companyId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> SellerorderList = new ArrayList<>();
        OrderPojo orderHistory = null;
        while (rs.next()) {
            orderHistory = new OrderPojo();

            orderHistory.setProductName(rs.getString("product_name"));
            orderHistory.setProductPrice(rs.getDouble("product_price"));
            orderHistory.setCustomerName(rs.getString("CUSTOMER_NAME"));

            orderHistory.setDeliveryStaffName(rs.getString("delivery_staff"));
            orderHistory.setCustomerAddress(rs.getString("address"));
            orderHistory.setReview(rs.getString("review"));
            orderHistory.setStatus(rs.getString("status"));

            SellerorderList.add(orderHistory);

        }

        return SellerorderList;
    }

    public static String OrderCart(PlaceOrderPojo placeOrder) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
        placeOrder.setOrderId(getNewId());
        ps.setString(1, placeOrder.getOrderId());
        ps.setString(2, placeOrder.getProductId());
        ps.setString(3, placeOrder.getCustomerId());
        ps.setString(4, placeOrder.getDeliveryStaffId());
        ps.setString(5, "");
        ps.setString(6, "cart");
        ps.setString(7, placeOrder.getCompanyId());
        Random rand = new Random();
        int otp = rand.nextInt(1000);
        ps.setInt(8, otp);
        if (ps.executeUpdate() == 1) {
            return placeOrder.getOrderId();
        }
        return null;
    }

    public static List<OrderPojo> getCustomerCartList(String customerId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT O.ORDER_ID, P.PRODUCT_NAME, P.PRODUCT_PRICE, S.STAFF_NAME AS DELIVERY_STAFF, CUST.ADDRESS "
                + "FROM ORDERS O "
                + "JOIN PRODUCTS P ON O.PRODUCT_ID = P.PRODUCT_ID "
                + "JOIN STAFF S ON O.STAFF_ID = S.STAFF_ID "
                + "JOIN CUSTOMERS CUST ON O.CUSTOMER_ID = ? "
                + "WHERE O.STATUS = 'cart'";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, customerId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> CustomerorderList = new ArrayList<>();
        OrderPojo orderHistory = null;
        while (rs.next()) {
            orderHistory = new OrderPojo();
            orderHistory.setOrderId(rs.getString("order_id"));

            orderHistory.setProductName(rs.getString("product_name"));
            orderHistory.setProductPrice(rs.getDouble("product_price"));
            orderHistory.setDeliveryStaffName(rs.getString("delivery_staff"));
            orderHistory.setCustomerAddress(rs.getString("address"));

            CustomerorderList.add(orderHistory);

        }
        return CustomerorderList;
    }

    public static boolean confirmOrderfromcart(String orderId) throws SQLException {

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update orders set status ='ORDERED' where order_id=?");
        ps.setString(1, orderId);
        return ps.executeUpdate() == 1;

    }

    public static String OrdertoCustomerId(String orderId) throws SQLException {

        Connection conn = DBConnection.getConnection();

        String compId = null;
        PreparedStatement ps = conn.prepareStatement("SELECT COMPANY_ID FROM ORDERS WHERE ORDER_ID = ?");
        ps.setString(1, orderId);
        try (ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                compId = resultSet.getString("COMPANY_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }

        return compId;

    }

}
