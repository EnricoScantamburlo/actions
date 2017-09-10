package it.scantamburloenrico.actions;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.Action;
import javax.swing.JLabel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.ListView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//it.scantamburloenrico.actions//Action//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ActionTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "it.scantamburloenrico.actions.ActionTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ActionAction",
        preferredID = "ActionTopComponent"
)
@Messages({
    "CTL_ActionAction=Action",
    "CTL_ActionTopComponent=Action Window",
    "HINT_ActionTopComponent=This is a Action window"
})
public final class ActionTopComponent extends TopComponent implements ExplorerManager.Provider {

    private final ExplorerManager manager = new ExplorerManager();

    public ActionTopComponent() {
        initComponents();
        setName(Bundle.CTL_ActionTopComponent());
        setToolTipText(Bundle.HINT_ActionTopComponent());

        // I create the view
        jPanel1.add(new JLabel("Action Test"), BorderLayout.NORTH);
        jPanel1.add(new ListView(), BorderLayout.CENTER);
        final Children.Array children = new Children.Array();

        children.add(new Node[]{new ActionNode()});
        // I create the root node
        AbstractNode rootNode = new AbstractNode(children);

        manager.setRootContext(rootNode);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return this.manager;
    }

    private static class ActionNode extends AbstractNode {

        public ActionNode() {
            super(Children.LEAF);
        }

        @Override
        public String getName() {
            return "ActionNode";
        }

        @Override
        public String getDisplayName() {
            return "Right Click Me";
        }

        @Override
        public Action[] getActions(boolean context) {
            // I read the actions from the layer.xml
            List<? extends Action> actions = Utilities.actionsForPath("Actions/NodeActions");
            return actions.toArray(new Action[actions.size()]);
        }

    }
}
