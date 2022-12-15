package sia.lumicloud;
import java.util.Date;
import java.util.List;
//end::allButValidation[]
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
// tag::allButValidation[]
import lombok.Data;


@Data
public class Taco {

    private Long id;
    private Date createdAt = new Date();
    // end::allButValidation[]
   // @NotNull
   // @Size(min=5, message="Name must be at least 5 characters long")
    // tag::allButValidation[]
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    // end::allButValidation[]
   // @Size(min=1, message="You must choose at least 1 ingredient")
    // tag::allButValidation[]
    @NotNull
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;

}
