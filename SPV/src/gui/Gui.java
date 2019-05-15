
package gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import settings.Config;
import version.Version;
import violin.Violin;

/**
 * This shows the general user interface and also includes various functions
 *
 * @author lmessing
 */
public class Gui extends javax.swing.JFrame
{

    private static final ImageIcon IMAGE_LOGO = new ImageIcon(Config.getInstance().getClass().getResource("/icons/violin128.png"));

    private final Settings settings;
    private final Config CONFIG;
    private final PropertyChangeListener configChangeListener;

    private Violin violin;

    /**
     * Creates the GUI
     *
     * @throws java.lang.Exception
     */
    public Gui() throws Exception
    {

        initComponents();

        CONFIG = Config.getInstance();
        configChangeListener = (PropertyChangeEvent evt) ->
        {
            configChangeEvent(evt);
        };
        CONFIG.setListener(configChangeListener);

        settings = new Settings(this, true);

        super.setTitle("SPV v" + Version.getVERSION());
        super.setMinimumSize(new Dimension(500, 400));
        super.setSize(CONFIG.getWindowDimension());
        super.setExtendedState(CONFIG.getWindowMode());

        super.setIconImage(IMAGE_LOGO.getImage());

        super.setLocation(CONFIG.getWindowLocation());

        enableNoteButtons(false);

        //super.setLocationRelativeTo(null);
        System.out.println("Start Application SPV v" + Version.getVERSION());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        mainPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        violinButton = new javax.swing.JButton();
        noteButtonA = new javax.swing.JButton();
        noteButtonB = new javax.swing.JButton();
        noteButtonC = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jFile = new javax.swing.JMenu();
        jMenuOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuSettings = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuClose = new javax.swing.JMenuItem();
        jHelp = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setLayout(new java.awt.BorderLayout());

        toolBar.setRollover(true);

        violinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/violin32.png"))); // NOI18N
        violinButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        violinButton.setFocusable(false);
        violinButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        violinButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        violinButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                violinButtonActionPerformed(evt);
            }
        });
        toolBar.add(violinButton);

        noteButtonA.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        noteButtonA.setText("A");
        noteButtonA.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        noteButtonA.setFocusable(false);
        noteButtonA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        noteButtonA.setMaximumSize(new java.awt.Dimension(39, 39));
        noteButtonA.setMinimumSize(new java.awt.Dimension(39, 39));
        noteButtonA.setPreferredSize(new java.awt.Dimension(39, 39));
        noteButtonA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        noteButtonA.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                noteButtonAMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                noteButtonAMouseReleased(evt);
            }
        });
        noteButtonA.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                noteButtonAActionPerformed(evt);
            }
        });
        toolBar.add(noteButtonA);

        noteButtonB.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        noteButtonB.setText("B");
        noteButtonB.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        noteButtonB.setFocusable(false);
        noteButtonB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        noteButtonB.setMaximumSize(new java.awt.Dimension(39, 39));
        noteButtonB.setMinimumSize(new java.awt.Dimension(39, 39));
        noteButtonB.setPreferredSize(new java.awt.Dimension(39, 39));
        noteButtonB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        noteButtonB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                noteButtonBActionPerformed(evt);
            }
        });
        toolBar.add(noteButtonB);

        noteButtonC.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        noteButtonC.setText("C");
        noteButtonC.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        noteButtonC.setFocusable(false);
        noteButtonC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        noteButtonC.setMaximumSize(new java.awt.Dimension(39, 39));
        noteButtonC.setMinimumSize(new java.awt.Dimension(39, 39));
        noteButtonC.setPreferredSize(new java.awt.Dimension(39, 39));
        noteButtonC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        noteButtonC.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                noteButtonCActionPerformed(evt);
            }
        });
        toolBar.add(noteButtonC);

        mainPanel.add(toolBar, java.awt.BorderLayout.NORTH);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        jFile.setText("File");

        jMenuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open16.png"))); // NOI18N
        jMenuOpen.setText("Open...");
        jMenuOpen.setEnabled(false);
        jMenuOpen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuOpenActionPerformed(evt);
            }
        });
        jFile.add(jMenuOpen);
        jFile.add(jSeparator1);

        jMenuSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_COMMA, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings16.png"))); // NOI18N
        jMenuSettings.setText("Settings");
        jMenuSettings.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuSettingsActionPerformed(evt);
            }
        });
        jFile.add(jMenuSettings);
        jFile.add(jSeparator2);

        jMenuClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove16.png"))); // NOI18N
        jMenuClose.setText("Close");
        jMenuClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuCloseActionPerformed(evt);
            }
        });
        jFile.add(jMenuClose);

        jMenuBar.add(jFile);

        jHelp.setText("Help");

        jMenuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/manual16.png"))); // NOI18N
        jMenuAbout.setText("About");
        jMenuAbout.setEnabled(false);
        jMenuAbout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuAboutActionPerformed(evt);
            }
        });
        jHelp.add(jMenuAbout);

        jMenuBar.add(jHelp);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuAboutActionPerformed
    {//GEN-HEADEREND:event_jMenuAboutActionPerformed

    }//GEN-LAST:event_jMenuAboutActionPerformed

  private void jMenuCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuCloseActionPerformed
  {//GEN-HEADEREND:event_jMenuCloseActionPerformed
      dispose();
  }//GEN-LAST:event_jMenuCloseActionPerformed

  private void jMenuSettingsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuSettingsActionPerformed
  {//GEN-HEADEREND:event_jMenuSettingsActionPerformed
      startProgSet();
  }//GEN-LAST:event_jMenuSettingsActionPerformed

  private void jMenuOpenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuOpenActionPerformed
  {//GEN-HEADEREND:event_jMenuOpenActionPerformed
      openFile();
  }//GEN-LAST:event_jMenuOpenActionPerformed

    private void noteButtonAActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_noteButtonAActionPerformed
    {//GEN-HEADEREND:event_noteButtonAActionPerformed

    }//GEN-LAST:event_noteButtonAActionPerformed

    private void violinButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_violinButtonActionPerformed
    {//GEN-HEADEREND:event_violinButtonActionPerformed
        violin = new Violin("COM11");
        enableNoteButtons(true);
    }//GEN-LAST:event_violinButtonActionPerformed

    private void noteButtonBActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_noteButtonBActionPerformed
    {//GEN-HEADEREND:event_noteButtonBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteButtonBActionPerformed

    private void noteButtonCActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_noteButtonCActionPerformed
    {//GEN-HEADEREND:event_noteButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteButtonCActionPerformed

    private void noteButtonAMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_noteButtonAMousePressed
    {//GEN-HEADEREND:event_noteButtonAMousePressed
        //System.out.println("BUTTON A PRESSED");
        violin.startNote(violin.A);
    }//GEN-LAST:event_noteButtonAMousePressed

    private void noteButtonAMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_noteButtonAMouseReleased
    {//GEN-HEADEREND:event_noteButtonAMouseReleased
        //System.out.println("BUTTON A RELEASED");
        violin.stopNote(violin.A);
    }//GEN-LAST:event_noteButtonAMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {

        final boolean useDefaultLookAndFeel = false;

        String lookAndFeelClassName;
        if(useDefaultLookAndFeel)
        {
            lookAndFeelClassName = javax.swing.UIManager.getCrossPlatformLookAndFeelClassName();
        }
        else
        {
            lookAndFeelClassName = javax.swing.UIManager.getSystemLookAndFeelClassName();
        }

        try
        {
            javax.swing.UIManager.setLookAndFeel(lookAndFeelClassName);
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(
                () ->
        {
            try
            {
                new Gui().setVisible(true);
            }
            catch (Exception ex)
            {
                ex.printStackTrace(System.err);
                JOptionPane.showMessageDialog(new JFrame(), ex.toString());
                System.exit(0);
            }
        }
        );

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jFile;
    private javax.swing.JMenu jHelp;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuClose;
    private javax.swing.JMenuItem jMenuOpen;
    private javax.swing.JMenuItem jMenuSettings;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton noteButtonA;
    private javax.swing.JButton noteButtonB;
    private javax.swing.JButton noteButtonC;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JButton violinButton;
    // End of variables declaration//GEN-END:variables


    /*
   * ---PUBLIC METHODS------------------------------------------
     */
    /**
     * Saves the config. Then shuts down the program.
     */
    @Override
    public void dispose()
    {

        if(this.getExtendedState() == Frame.NORMAL)
        {
            CONFIG.storeWindowSize(this.getWidth(), this.getHeight());
            CONFIG.storeWindowLocation(this.getLocation());
        }

        CONFIG.storeWindowMode(this.getExtendedState());
        CONFIG.save();

        super.dispose();
    }


    /*
   * ---PRIVATE METHODS------------------------------------------
     */
    /**
     * Shows an error message relative to the main GUI
     *
     * @param title   The Title of the Frame
     * @param message The displayed message
     */
    private void showErrorMessage(String title, String message)
    {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }


    /*
   * ---PRIVATE METHODS----------------------------------------
     */
    /**
     * Opens up the ProgSetDialog and saves the changes values. If the measurement is
     * already done the datasets will be updated.
     */
    private void startProgSet()
    {
        settings.setLocationRelativeTo(this);
        settings.setVisible(true);

    }

    @Override
    public void setVisible(boolean b)
    {
        super.setVisible(b);
        //startProgSet();   // for fast debugging
    }

    private void enableNoteButtons(boolean enable)
    {
        noteButtonA.setEnabled(enable);
        noteButtonB.setEnabled(enable);
        noteButtonC.setEnabled(enable);
    }

    private void openFile()
    {

    }

    private void configChangeEvent(PropertyChangeEvent event)
    {

    }

}
