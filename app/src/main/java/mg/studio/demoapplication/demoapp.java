package mg.studio.demoapplication;

/**
 *The Class to discribe the application object,
 * use which to record the information.
 * Include some origin info and other new info used for the App Running.
 */

public class demoapp {
    private String name;

    public demoapp(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
