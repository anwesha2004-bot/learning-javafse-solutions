package Week1.DesignPatterns;

interface Prototype {
    Prototype clone();
}

class Document implements Prototype {
    private String title;
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Document(Document original) {
        this.title = original.title;
        this.content = original.content;
    }

    @Override
    public Prototype clone() {
        return new Document(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void show() {
        System.out.println("📄 Title: " + title);
        System.out.println("📝 Content: " + content);
        System.out.println("----------------------------");
    }
}

public class PrototypePatternExample {
    public static void main(String[] args) {

        Document original = new Document("UEM Rules", "No entry after 9:30 AM");
        original.show();

        Document copy = (Document) original.clone();
        copy.setTitle("Hostel Rules");
        copy.show();

        original.show();
    }
}
