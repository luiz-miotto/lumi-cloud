package sia.lumicloud.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import sia.lumicloud.Ingredient;
import sia.lumicloud.TacoOrder;

public interface OrderRepository extends CrudRepository<Ingredient,String> {
    TacoOrder save(TacoOrder order);
}
