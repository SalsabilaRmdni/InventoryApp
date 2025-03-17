import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends Item> {
    private List<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public T findItemByName(String name) {
        for (T item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}