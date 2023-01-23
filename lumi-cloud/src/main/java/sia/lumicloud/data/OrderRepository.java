package sia.lumicloud.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import sia.lumicloud.Ingredient;
import sia.lumicloud.TacoOrder;
import java.util.UUID;


public interface OrderRepository extends CrudRepository<TacoOrder,String> {

}
