package pl.as.produkty;

public enum Category {
    FOOD ("spożywcze"),
    HOUSEHOLD("domowe"),
    OTHER("inne");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
