/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.scantamburloenrico.actions.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.*;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "MyActions",
        id = "it.scantamburloenrico.actions.impl.Wizard"
)
@ActionRegistration(
        displayName = "#CTL_Wizard"
)
@Messages("CTL_Wizard=WizardAction")
public final class Wizard implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Wizard"));
    }
}
