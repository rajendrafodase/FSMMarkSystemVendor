package com.example.fsmsystemvender.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class OrderList {
  int orderID;
  String orderNo;
  String customerID;
  String margID;
  String type;
  String sid;
  String productCode;
  String quantity;
  String free;
  String lat;
  String lng;
  String address;
  String gpsID;
  String userType;
  String points;
  String discounts;
  String transport;
  String delivery;
  String bankname;
  String bankAdd1;
  String bankAdd2;
  String shipname;
  String shipAdd1;
  String shipAdd2;
  String shipAdd3;
  String paymentmode;
  String paymentmodeAmount;
  String payment_remarks;
  String order_remarks;
  String custName;
  String custMobile;
  String companyCode;
  String orderFrom;
  String created_at;
  String updated_at;

    public OrderList(int orderID, String orderNo, String customerID, String margID, String type, String sid, String productCode, String quantity, String free, String lat, String lng, String address, String gpsID, String userType, String points, String discounts, String transport, String delivery, String bankname, String bankAdd1, String bankAdd2, String shipname, String shipAdd1, String shipAdd2, String shipAdd3, String paymentmode, String paymentmodeAmount, String payment_remarks, String order_remarks, String custName, String custMobile, String companyCode, String orderFrom, String created_at, String updated_at) {
        this.orderID = orderID;
        this.orderNo = orderNo;
        this.customerID = customerID;
        this.margID = margID;
        this.type = type;
        this.sid = sid;
        this.productCode = productCode;
        this.quantity = quantity;
        this.free = free;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.gpsID = gpsID;
        this.userType = userType;
        this.points = points;
        this.discounts = discounts;
        this.transport = transport;
        this.delivery = delivery;
        this.bankname = bankname;
        this.bankAdd1 = bankAdd1;
        this.bankAdd2 = bankAdd2;
        this.shipname = shipname;
        this.shipAdd1 = shipAdd1;
        this.shipAdd2 = shipAdd2;
        this.shipAdd3 = shipAdd3;
        this.paymentmode = paymentmode;
        this.paymentmodeAmount = paymentmodeAmount;
        this.payment_remarks = payment_remarks;
        this.order_remarks = order_remarks;
        this.custName = custName;
        this.custMobile = custMobile;
        this.companyCode = companyCode;
        this.orderFrom = orderFrom;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public OrderList(JSONObject jsonObject1) throws JSONException {
        this.orderID=jsonObject1.getInt("OrderID");
        this.orderNo=jsonObject1.getString("OrderNo");
        this.shipname=jsonObject1.getString("shipname");
        this.created_at=jsonObject1.getString("created_at");
        this.orderFrom=jsonObject1.getString("OrderFrom");
        this.free=jsonObject1.getString("Free");
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getMargID() {
        return margID;
    }

    public void setMargID(String margID) {
        this.margID = margID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGpsID() {
        return gpsID;
    }

    public void setGpsID(String gpsID) {
        this.gpsID = gpsID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
        this.discounts = discounts;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankAdd1() {
        return bankAdd1;
    }

    public void setBankAdd1(String bankAdd1) {
        this.bankAdd1 = bankAdd1;
    }

    public String getBankAdd2() {
        return bankAdd2;
    }

    public void setBankAdd2(String bankAdd2) {
        this.bankAdd2 = bankAdd2;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getShipAdd1() {
        return shipAdd1;
    }

    public void setShipAdd1(String shipAdd1) {
        this.shipAdd1 = shipAdd1;
    }

    public String getShipAdd2() {
        return shipAdd2;
    }

    public void setShipAdd2(String shipAdd2) {
        this.shipAdd2 = shipAdd2;
    }

    public String getShipAdd3() {
        return shipAdd3;
    }

    public void setShipAdd3(String shipAdd3) {
        this.shipAdd3 = shipAdd3;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public String getPaymentmodeAmount() {
        return paymentmodeAmount;
    }

    public void setPaymentmodeAmount(String paymentmodeAmount) {
        this.paymentmodeAmount = paymentmodeAmount;
    }

    public String getPayment_remarks() {
        return payment_remarks;
    }

    public void setPayment_remarks(String payment_remarks) {
        this.payment_remarks = payment_remarks;
    }

    public String getOrder_remarks() {
        return order_remarks;
    }

    public void setOrder_remarks(String order_remarks) {
        this.order_remarks = order_remarks;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
