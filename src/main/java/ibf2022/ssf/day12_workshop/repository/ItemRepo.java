package ibf2022.ssf.day12_workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ibf2022.ssf.day12_workshop.model.Item;
import lombok.Data;

@Data
@Repository
public class ItemRepo {

    private List<Item> itemList;

    public List<Item> getCartItems() {
        itemList = new ArrayList<Item>();
     

        Item itm = new Item();
        itm.setItemName("Chanel");
        itm.setQuantity(6);
        itemList.add(itm);

        itm = new Item();
        itm.setItemName("LV");
        itm.setQuantity(10);
        itemList.add(itm);

        itm = new Item();
        itm.setItemName("Gucci");
        itm.setQuantity(12);
        itemList.add(itm);

        return itemList;
    }
}
