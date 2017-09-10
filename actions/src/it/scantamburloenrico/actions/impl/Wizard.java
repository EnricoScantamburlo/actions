package it.scantamburloenrico.actions.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.*;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "MyActions",
        id = "it.scantamburloenrico.actions.impl.Wizard"
)
@ActionRegistration(
        displayName = "#CTL_Wizard"
)
// Added to create a reference to the action
@ActionReference(path = "Actions/NodeActions", position = 100)
@Messages("CTL_Wizard=WizardAction")
public final class Wizard implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Wizard"));
    }
}
