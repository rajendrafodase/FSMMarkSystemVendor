package com.example.fsmsystemvender.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class ProductList {
   int  rid;
   String catcode;
   String code;
   String name;
   String stock;
   String remark;
   String company;
   String shopcode;
   String mRP;
   String rate;
   String deal;
   String free;
   String pRate;
   String is_Deleted;
   String curbatch;
   String exp;
   String gcode;
   String margCode;
   String conversion;
   String salt;
   String eNCODE;
   String remarks;
   String gcode6;
   String productCode;

    public ProductList(JSONObject jsonObject1) throws JSONException {
        this.rid=jsonObject1.getInt("rid");
        this.catcode=jsonObject1.getString("catcode");
        this.code=jsonObject1.getString("code");
        this.name=jsonObject1.getString("name");
        this.stock=jsonObject1.getString("stock");
        this.remark=jsonObject1.getString("remark");
        this.company=jsonObject1.getString("company");
        this.shopcode=jsonObject1.getString("shopcode");
        this.mRP=jsonObject1.getString("MRP");
        this.rate=jsonObject1.getString("Rate");
        this.deal=jsonObject1.getString("Deal");
        this.free=jsonObject1.getString("Free");
        this.pRate=jsonObject1.getString("PRate");
        this.is_Deleted=jsonObject1.getString("Is_Deleted");
        this.curbatch=jsonObject1.getString("curbatch");
        this.exp=jsonObject1.getString("exp");
        this.gcode=jsonObject1.getString("gcode");
        this.margCode=jsonObject1.getString("MargCode");
        this.conversion=jsonObject1.getString("Conversion");
        this.salt=jsonObject1.getString("Salt");
        this.eNCODE=jsonObject1.getString("ENCODE");
        this.remarks=jsonObject1.getString("remarks");
        this.gcode6=jsonObject1.getString("Gcode6");
        this.productCode=jsonObject1.getString("ProductCode");
    }



    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getCatcode() {
        return catcode;
    }

    public void setCatcode(String catcode) {
        this.catcode = catcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getShopcode() {
        return shopcode;
    }

    public void setShopcode(String shopcode) {
        this.shopcode = shopcode;
    }

    public String getmRP() {
        return mRP;
    }

    public void setmRP(String mRP) {
        this.mRP = mRP;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getpRate() {
        return pRate;
    }

    public void setpRate(String pRate) {
        this.pRate = pRate;
    }

    public String getIs_Deleted() {
        return is_Deleted;
    }

    public void setIs_Deleted(String is_Deleted) {
        this.is_Deleted = is_Deleted;
    }

    public String getCurbatch() {
        return curbatch;
    }

    public void setCurbatch(String curbatch) {
        this.curbatch = curbatch;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public String getMargCode() {
        return margCode;
    }

    public void setMargCode(String margCode) {
        this.margCode = margCode;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String geteNCODE() {
        return eNCODE;
    }

    public void seteNCODE(String eNCODE) {
        this.eNCODE = eNCODE;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGcode6() {
        return gcode6;
    }

    public void setGcode6(String gcode6) {
        this.gcode6 = gcode6;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
