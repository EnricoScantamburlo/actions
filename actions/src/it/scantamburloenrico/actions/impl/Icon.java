package it.scantamburloenrico.actions.impl;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.ContextAwareAction;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.actions.Presenter;

/**
 *
 * @author Enrico Scantamburlo <scantamburlo at streamsim.com>
 */
public class Icon extends AbstractAction implements ContextAwareAction, Presenter.Popup {

    private static final String ICON_PATH = "it/scantamburloenrico/actions/resources/information.png";
    private static final ImageIcon ICON = ImageUtilities.loadImageIcon(ICON_PATH, false);

    public Icon() {

    }

    private Icon(Lookup lkp) {
        super("Icon", ICON);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Icon"));
    }

    @Override
    public Action createContextAwareInstance(Lookup actionContext) {
        return new Icon(actionContext);
    }

    @Override
    public JMenuItem getPopupPresenter() {
        return new JMenuItem(this);
    }

}
