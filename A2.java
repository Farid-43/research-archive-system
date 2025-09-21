interface ResearchPaper {
    void view();

}

class FullResearchPaper implements ResearchPaper {
    private String title;
    private boolean loaded;

    public FullResearchPaper(String title) {
        this.title = title;
        loaded = false;
    }

    public void loadPdfContent() {
        if (!loaded) {
            System.out.println("Loading...");
            loaded = true;
            System.out.println("Loaded Successfully");
        }
    }

    @Override
    public void view() {
        loadPdfContent();
        System.out.println();
    }

    int getPublicationYear() {
        return 2000; // update from feature branch
    }
}

class proxy implements ResearchPaper {
    private String title;
    private FullResearchPaper p1;

    public proxy(String title) {
        this.title = title;
    }

    @Override
    public void view() {
        if (p1 == null) {
            System.out.println("Creating paper");
            p1 = new FullResearchPaper(title);
        }
        p1.view();
    }

}

public class A2 {
    public static void main(String[] args) {
        System.out.println("University Research Archive System");
        ResearchPaper p1 = new proxy("AAA");
        ResearchPaper p2 = new proxy("BBB");
        ResearchPaper p3 = new proxy("CCC");

        p1.view();
        p2.view();
        p3.view();
    }
}
