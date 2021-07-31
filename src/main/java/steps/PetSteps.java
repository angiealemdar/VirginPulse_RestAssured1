package steps;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import pojo.Pet;
import utility.PetsController;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetSteps extends PetsController{

    public PetSteps createPetSuccessfully(Pet pet) {
        Response response = postPet(pet);
        assertStatusCode(HttpStatus.SC_OK, response);
        Assertions.assertNotNull(response.getBody().jsonPath().get("id"));
        return this;
    }

    public Pet getPetById(String petId) {
        Response response = getPetsById(petId);
        assertStatusCode(HttpStatus.SC_OK, response);
        return response.as(Pet.class);
    }

    public PetSteps uploadImageToPet(String petId) {
        Response response = uploadPet(petId);
        assertStatusCode(HttpStatus.SC_OK, response);
        Assertions.assertTrue(response.jsonPath().getString("message").contains("9720361844786"));
        return this;
    }

    private void assertStatusCode(int ExpectedStatus, Response response) {
        assertThat(response.statusCode(), equalTo(ExpectedStatus));
    }

}
