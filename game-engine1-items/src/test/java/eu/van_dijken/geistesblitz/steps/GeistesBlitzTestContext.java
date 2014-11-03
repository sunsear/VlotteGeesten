package eu.van_dijken.geistesblitz.steps;

public class GeistesBlitzTestContext {
    private static GeistesBlitzTestContext instance;

    public static GeistesBlitzTestContext getInstance() {
        if (instance==null){
            instance = new GeistesBlitzTestContext();
        }
        return instance;
    }
}
