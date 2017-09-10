package it.scantamburloenrico.actions.impl;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;
import org.openide.util.actions.Presenter;

/**
 *
 * @author Enrico Scantamburlo <scantamburlo at streamsim.com>
 */
public class SubMenu extends AbstractAction implements ContextAwareAction, Presenter.Popup {

    private Lookup lkp;

    public SubMenu() {

    }

    private SubMenu(Lookup lkp) {
        super("Menu");
        this.lkp = lkp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Does not work!");
    }

    @Override
    public Action createContextAwareInstance(Lookup actionContext) {
        return new SubMenu(actionContext);
    }

    @Override
    public JMenuItem getPopupPresenter() {
        JMenu menu = new JMenu("Menu");
        JMenuItem first = new JMenuItem("SubMenu1");
        first.addActionListener(a -> {
            DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("SubMenu1"));
        });
        JMenuItem second = new JMenuItem("SubMenu2");
        second.addActionListener(a -> {
            DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("SubMenu2"));
        });
        JMenuItem third = new JMenuItem("SubMenu3");
        third.addActionListener(a -> {
            DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("SubMenu3"));
        });

        menu.add(first);
        menu.add(second);
        menu.add(third);

        return menu;
    }

}
