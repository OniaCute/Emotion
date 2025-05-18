package cc.emotion.features.options;

public abstract class Option<T> {
    protected String name;
    protected String displayName;
    protected String description;
    protected T value;

    public Option(String name) {
        this.name = name;
    }

    public Option(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public Option(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Option(String name, String description, T value) {
        this.name = name;
        this.description = description;
        this.value = value;
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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
