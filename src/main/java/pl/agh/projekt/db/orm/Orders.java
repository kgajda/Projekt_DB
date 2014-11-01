package pl.agh.projekt.db.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by karol on 31.10.14.
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "OrderID", nullable = false, length = 11)
    private Integer orderId;
    @Column(name = "CustomerID", nullable = false, length = 5)
    private String customerId;
    @Column(name = "EmployeeID", nullable = false, length = 11)
    private Integer employeeId;
    @Column(name = "OrderDate")
    private Date orderDate;
    @Column(name = "RequiredDate")
    private Date requiredDate;
    @Column(name = "ShippedDate")
    private Date shippedDate;
    @Column(name = "ShipVia", length = 11)
    private Integer shipVia;
    @Column(name = "Freight", length = 1)
    private Float freight;
    @Column(name = "ShipName", length = 40)
    private String shipName;
    @Column(name = "ShipAddress", length = 60)
    private String shipAddress;
    @Column(name = "ShipCity", length = 15)
    private String shipCity;
    @Column(name = "ShipRegion", length = 15)
    private String shipRegion;
    @Column(name = "ShipPostalCode", length = 10)
    private String shipPostalCode;
    @Column(name = "ShipCountry", length = 15)
    private String shipCountry;

    public Orders() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Integer getShipVia() {
        return shipVia;
    }

    public void setShipVia(Integer shipVia) {
        this.shipVia = shipVia;
    }

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }
}