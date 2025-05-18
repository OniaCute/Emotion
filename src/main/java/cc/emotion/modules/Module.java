package cc.emotion.modules;

import cc.emotion.features.options.Option;
import cc.emotion.util.interfaces.Wrapper;

import java.util.ArrayList;
import java.util.List;

public class Module implements Wrapper {
    public String name;
    public String displayName;
    public Category category;
    public boolean status = false; // default disabled
    public List<Option<?>> options = new ArrayList<>();

    public Category getCategory() {
        return category;
    }

    public boolean getStatus() {
        return status;
    }

    public List<Option<?>> getOptionsList() {
        return options;
    }

    public static ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(Category.CLIENT);
        categories.add(Category.COMBAT);
        categories.add(Category.MISC);
        categories.add(Category.EXPLOIT);
        categories.add(Category.MOVEMENT);
        categories.add(Category.PLAYER);
        categories.add(Category.RENDER);
        categories.add(Category.HUD);
        return categories;
    }
    public enum Category {
        CLIENT, COMBAT, MISC, EXPLOIT, MOVEMENT, PLAYER, RENDER, HUD
    }
}
