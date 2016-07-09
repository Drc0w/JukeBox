package view;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class TabsView extends JTabbedPane implements Observer {
    private static final TabsView TABS_VIEW = new TabsView();

    private TabsView() {
        super();
    }

    public static TabsView getTabsView() {
        return TABS_VIEW;
    }

    @Override
    public void update(Observable observable, Object o) {
        this.repaint();
        this.revalidate();
    }
}
