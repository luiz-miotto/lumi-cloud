package sia.lumicloud.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

//import lombok.extern.slf4j.Slf4j;
import sia.lumicloud.Ingredient;
import sia.lumicloud.Ingredient.Type;
import sia.lumicloud.Taco;
import sia.lumicloud.TacoOrder;
import sia.lumicloud.data.IngredientRepository;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")


public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    public DesignTacoController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();


        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

        @ModelAttribute(name = "tacoOrder")
        public TacoOrder order(){
            return new TacoOrder();
        }

        @ModelAttribute(name = "taco")
        public Taco taco(){
            return new Taco();
        }

        @GetMapping
        public String showDesignForm(){
            return "design";
        }

        @PostMapping
        public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder){
        if(errors.hasErrors()){
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

        private Iterable<Ingredient> filterByType(
                Iterable<Ingredient> ingredients, Type type){
            return StreamSupport.stream(ingredients.spliterator(), false)
                    .filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList());

        }

    }



