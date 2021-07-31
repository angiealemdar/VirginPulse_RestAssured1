package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Pet;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by inhab on 3/2/2020.
 */

public class PetsController {

    private final RequestSpecification request = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .addHeader("api_key", "12345")
            .build();

    public Response postPet(Object pet) {
        return given(request)
                .when()
                .body(pet)
                .post();
    }

    public Response getPetsById(String id) {
        return given(request)
                .when()
                .get(id)
                .then()
                .extract().response();
    }


    public Response uploadPet(Object petId) {
        return given(request)
                .pathParam("petId", petId)
                .contentType("multipart/form-data")
                .accept("application/json")
                .multiPart(new File("/Users/bkaya/Downloads/9720361844786.jpeg"))
                .when().post("/{petId}/uploadImage");
    }


}
