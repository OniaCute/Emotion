package cc.emotion.features.event;

public class Event {
    private Stage stage;
    private boolean cancel;

    public Event() {
        this.cancel = false;
    }

    public Event(Stage stage) {
        this.cancel = false;
        this.stage = stage;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public void cancel() {
        this.cancel = true;
    }

    public boolean isCancelled() {
        return cancel;
    }
    public boolean isCancel() {
        return cancel;
    }

    public Stage getStage() {
        return stage;
    }
    public boolean isPost() {
        return stage == Stage.Post;
    }

    public boolean isPre() {
        return stage == Stage.Pre;
    }


    public enum Stage{
        Pre, Post
    }
}
