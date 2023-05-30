package com.bestbuy.crudtest;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetProductCrudTest extends TestBase {
    @Test
    public void getAllProductsInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "8bc13c20a8ab19fdf152065554a0e38e1545013fd1c3feb811568f9a151005f7")
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }

    @Test
    public void getSingleProductInfo() {
        Response response = given()
                .pathParam("id", 43900)
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Treadmill");
        productPojo.setType("HardGood");
        productPojo.setPrice(17.98);
        productPojo.setShipping(1);
        productPojo.setUpc("044563424019");
        productPojo.setDescription("Compatible with any body types and electronic devices; 240V size; " +
                "DURALOCK Power Preserve technology");
        productPojo.setManufacturer("PureGym");
        productPojo.setModel("MN2400DBZ");
        productPojo.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900." +
                "p?id=1051384074145&skuId=43900&cmp=RMXCC");
        productPojo.setImage("https://static.wixstatic.com/media/6011fb_b48414e4c7f446c4a90e02e04056f9cf~mv2.png/v1/fill" +
                "/w_1362,h_1368,al_c,q_90,enc_auto/BeHealthy.png");
    }
}



