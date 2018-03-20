/*
 * The code is licensed under the GPL Version 3 license https://www.gnu.org/licenses/quick-guide-gplv3.html.
 *
 * Copyright (c)2017, Telenav, Inc. All Rights Reserved
 */
package org.openstreetmap.josm.plugins.geohash.gui;

import static org.openstreetmap.josm.tools.I18n.tr;
import java.awt.event.ActionEvent;
import org.openstreetmap.josm.actions.JosmAction;
import org.openstreetmap.josm.gui.dialogs.LayerListDialog.LayerListModel;
import org.openstreetmap.josm.gui.dialogs.layer.DeleteLayerAction;
import org.openstreetmap.josm.gui.help.HelpUtil;
import org.openstreetmap.josm.plugins.geohash.util.PreferenceManager;
import org.openstreetmap.josm.tools.ImageProvider;

/**
 *
 * @author laurad
 * @version $Revision$
 */
public class GeohashLayerDeleteAction extends JosmAction {

    private static final long serialVersionUID = 2317473279328069599L;
    private final DeleteLayerAction deleteAction;

    public GeohashLayerDeleteAction(final LayerListModel model) {
        new ImageProvider("dialogs", "delete").getResource().attachImageIcon(this, true);
        putValue(SHORT_DESCRIPTION, tr("Delete the selected layers."));
        putValue(NAME, tr("Delete"));
        putValue("help", HelpUtil.ht("/Dialog/LayerList#DeleteLayer"));
        deleteAction = new DeleteLayerAction(model);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        PreferenceManager.getInstance().setLayerOpenedFlag(false);
        deleteAction.actionPerformed(e);
    }
}