package pojo;

import lombok.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private int id;
    private String name;
    private Status status;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Category category;
}





