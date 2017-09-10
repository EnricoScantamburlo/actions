package it.scantamburloenrico.actions.impl;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.DynamicMenuContent;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;
import org.openide.util.actions.Presenter;

/**
 *
 * @author Enrico Scantamburlo <scantamburlo at streamsim.com>
 */
public class Multiple extends AbstractAction implements ContextAwareAction, Presenter.Popup {

    private Lookup lkp;

    public Multiple() {

    }

    private Multiple(Lookup lkp) {
        super("Multiple");
        this.lkp = lkp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Does not work!");
    }

    @Override
    public Action createContextAwareInstance(Lookup actionContext) {
        return new Multiple(actionContext);
    }

    @Override
    public JMenuItem getPopupPresenter() {
        return new MultipleMenu(lkp);
    }

    private static class MultipleMenu extends JMenuItem implements DynamicMenuContent {

        private final Lookup lkp;

        private MultipleMenu(Lookup lkp) {
            this.lkp = lkp;
        }

        @Override
        public JComponent[] getMenuPresenters() {
            JMenuItem[] presenters = new JMenuItem[3];
            presenters[0] = new JMenuItem("First");
            presenters[0].addActionListener((ae) -> {
                DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Action1"));
            });
            presenters[1] = new JMenuItem("Second");
            presenters[1].addActionListener((ae) -> {
                DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Action2"));
            });
            presenters[2] = new JMenuItem("Third");
            presenters[2].addActionListener((ae) -> {
                DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Action3"));
            });
            return presenters;
        }

        @Override
        public JComponent[] synchMenuPresenters(JComponent[] arg0) {
            // No idea what this does
            return arg0;
        }

    }

}
