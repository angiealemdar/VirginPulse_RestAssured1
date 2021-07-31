import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import pojo.Pet;
import pojo.Status;
import pojo.Tag;
import pojo.Category;
import steps.PetSteps;
import java.util.*;

public class PetsTest extends BaseTest{

    private final PetSteps petSteps = new PetSteps();

    @Test
    public void testGetPetById() {
        petSteps.getPetById("2");
    }

    @Test
    public void testCreateNewPet() {
        petSteps.createPetSuccessfully(generatePet());
    }

    @Test
    public void testUploadImage() {
        petSteps.uploadImageToPet("2");
    }

    private static Pet generatePet() {
        return Pet.builder()
                .id(getRandomInt())
                .category(Category.builder().id(0).name("string").build())
                .name(getRandomString())
                .photoUrls(Arrays.asList("string"))
                .status(Status.available)
                .tags(Arrays.asList(Tag.builder().id(6).name("string").build()))
                .build();
    }

    private static Integer getRandomInt() {
        return new Random().nextInt((65536) - 32768);
    }

    private static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }

}