package view;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class TabsView extends JTabbedPane implements Observer {

    /**
     * Singleton design pattern implementation
     */
    private static final TabsView TABS_VIEW = new TabsView();

    /**
     * Default constructor of the class
     */
    private TabsView() {
        super();
    }

    /**
     * Singleton design pattern access
     *
     * @return Rturns the running TabsView instance
     */
    public static TabsView getTabsView() {
        return TABS_VIEW;
    }

    /**
     * The function that is called when one of the observed object changed
     *
     * @param observable The observable that changed
     * @param o          This parameter is ignored at the moment
     */
    @Override
    public void update(Observable observable, Object o) {
        this.repaint();
        this.revalidate();
    }
}
