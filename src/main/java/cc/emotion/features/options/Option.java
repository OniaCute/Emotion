package cc.emotion.features.options;

import java.util.function.Predicate;

public abstract class Option<T> {
    protected String name;
    protected String displayName;
    protected String description;
    protected Predicate<?> invisibility;
    protected T value;

    public Option(String name, Predicate<?> invisibility) {
        this.name = name;
        this.invisibility = invisibility;
    }

    public Option(String name, T value, Predicate<?> invisibility) {
        this.name = name;
        this.value = value;
        this.invisibility = invisibility;
    }

    public Option(String name, String description, Predicate<?> invisibility) {
        this.name = name;
        this.description = description;
        this.invisibility = invisibility;
    }

    public Option(String name, String description, T value, Predicate<?> invisibility) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.invisibility = invisibility;
    }

    public void setInvisibility(Predicate<T> invisibility) {
        this.invisibility = invisibility;
    }

    public Predicate<?> getInvisibility() {
        return invisibility;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract T getValue();

    public abstract void setValue(T value);
}
