package it.scantamburloenrico.actions.impl;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;

/**
 *
 * @author Enrico Scantamburlo <scantamburlo at streamsim.com>
 */
public class Icon extends AbstractAction implements ContextAwareAction {

    public Icon() {

    }

    private Icon(Lookup lkp) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Custom"));
    }

    @Override
    public Action createContextAwareInstance(Lookup actionContext) {
        return new Icon(actionContext);
    }

}
