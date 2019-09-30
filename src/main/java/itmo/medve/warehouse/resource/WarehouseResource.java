package itmo.medve.warehouse.resource;


import itmo.medve.warehouse.model.ItemClass;
import itmo.medve.warehouse.repository.ItemClassRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/warehouse")
public class WarehouseResource {

    ItemClassRepository itemClassRepository;

    public WarehouseResource(ItemClassRepository itemClassRepository) {
        this.itemClassRepository = itemClassRepository;
    }

    @RequestMapping("/itemClasses")
    public List<ItemClass> getAvailableItemClasses() {
        List<ItemClass> itemClasses = new ArrayList<>();
        for( ItemClass i: itemClassRepository.findAll()){
            itemClasses.add(i);
        }
       return itemClasses;
    }

    @RequestMapping(value ="/isOfferable", method = POST,  consumes = "application/json")
    public Boolean isOfferable(@RequestBody ItemClass itemClass){
        return itemClassRepository.findById(itemClass.getId()).get().getAmount() > itemClass.getAmount();
    }

    @RequestMapping("/{ICid}")
    public ItemClass getItemClassById(@PathVariable("ICid") Long ICid){
        ItemClass itc = itemClassRepository.findById(ICid).isPresent() ? itemClassRepository.findById(ICid).get(): null;
        return itc;
    }

    @RequestMapping("/itemClassesIDs")
    public List<Long> getAvailableItemsClassesIDs() {
        List<Long> itemClasses = new ArrayList<>();
        for( ItemClass i: itemClassRepository.findAll()){
            itemClasses.add(i.getId());
        }
        return itemClasses;
    }

    @RequestMapping(value ="/addNewClass", method = POST,  consumes = "application/json")
    public void addNewItemClass(@RequestBody ItemClass itemClass){
        itemClassRepository.save(itemClass);
    }


}
