package sia.lumicloud.data;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import sia.lumicloud.Ingredient;
import java.util.UUID;



@Component
public interface IngredientRepository extends CrudRepository<Ingredient,String> {


}


