package ibf2022.ssf.day12_workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.ssf.day12_workshop.model.Item;
import ibf2022.ssf.day12_workshop.service.ItemService;

@Controller
@RequestMapping(path={"/shoppingcart"})
public class ItemController {

    @Autowired
    ItemService itmSvc;

    @GetMapping(produces = "text/html")
    public String displayCart(Model model){
        List<Item> items = itmSvc.retriveItemList();
        model.addAttribute("cartItems", items);
        return "cartList";
    }

    @GetMapping("{itemname}")
    public String filteredCart(@PathVariable("itemname") String itemname, Model model){
        List<Item> items = itmSvc.retriveItemList();
        Item foundItem = items.stream().filter(i ->i.getItemName().equalsIgnoreCase(itemname)).findFirst().get();

        model.addAttribute("cartItems", foundItem);

        return "cartList";
    }
    
}
