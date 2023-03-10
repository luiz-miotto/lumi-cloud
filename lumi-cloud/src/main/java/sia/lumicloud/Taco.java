package sia.lumicloud;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





import lombok.Data;


@Data

public class Taco {



    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;


    private Date createdAt = new Date();

    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();


    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

}
