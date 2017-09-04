/*
 * ImportDelimitedCommand.java
 *
 * Copyright (C) 2002-2017 Takis Diakoumis
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.executequery.actions.toolscommands;

import java.awt.event.ActionEvent;

import org.executequery.GUIUtilities;
import org.executequery.actions.OpenFrameCommand;
import org.executequery.gui.BaseDialog;
import org.executequery.gui.importexport.ImportExportDataProcess;
import org.executequery.gui.importexport.ImportExportDelimitedPanel;
import org.underworldlabs.swing.actions.BaseCommand;

/** 
 * <p>Execution for Export to Delimited File
 *
 * @author   Takis Diakoumis
 * @version  $Revision: 1780 $
 * @date     $Date: 2017-09-03 15:52:36 +1000 (Sun, 03 Sep 2017) $
 */
public class ImportDelimitedCommand extends OpenFrameCommand
                                    implements BaseCommand {
    
    public void execute(ActionEvent e) {

        if (!isConnected()) {
            return;
        }
        
        if (isActionableDialogOpen()) {
            GUIUtilities.acionableDialogToFront();
            return;
        }
        
        if (!isDialogOpen(bundledString("title"))) {
            GUIUtilities.showWaitCursor();
            try {
                BaseDialog dialog = 
                        createDialog(bundledString("title"), false, false);
                ImportExportDelimitedPanel panel = 
                        new ImportExportDelimitedPanel(dialog, ImportExportDataProcess.IMPORT);
                dialog.addDisplayComponent(panel);
                dialog.display();
            }
            finally {
                GUIUtilities.showNormalCursor();
            }
        }

    }
    
}

