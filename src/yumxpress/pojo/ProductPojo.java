/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

import java.awt.Image;

/**
 *
 * @author harsh
 */
public class ProductPojo {

    @Override
    public String toString() {
        return "ProductPojo{" + "productId=" + productId + ", compnayId=" + compnayId + ", productName=" + productName + ", productPrice=" + productPrice + ", productImage=" + productImage + ", productImageType=" + productImageType + '}';
    }
    private String productId;
    private String compnayId;
    private String productName;
    private Double productPrice;
    private Image productImage;
    private String productImageType;

    public String getProductId() {
        return productId;
    }

    public ProductPojo() {

    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCompnayId() {
        return compnayId;
    }

    public void setCompnayId(String compnayId) {
        this.compnayId = compnayId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Image getProductImage() {
        return productImage;
    }

    public void setProductImage(Image productImage) {
        this.productImage = productImage;
    }

    public String getProductImageType() {
        return productImageType;
    }

    public void setProductImageType(String productImageType) {
        this.productImageType = productImageType;
    }

}
