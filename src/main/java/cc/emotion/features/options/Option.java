package cc.emotion.features.options;

public abstract class Option<T> {
    protected String name;
    protected String displayName;
    protected T value;

    public Option(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
