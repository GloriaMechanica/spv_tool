
package gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jssc.SerialPortException;
import serial.Port;
import serial.PortCom;
import serial.PortSim;
import settings.Config;
import version.Version;

/**
 * This shows the general user interface and also includes various functions
 *
 * @author lmessing
 */
public class Gui extends javax.swing.JFrame
{

    private static final ImageIcon IMAGE_LOGO = new ImageIcon(Config.getInstance().getClass().getResource("/icons/violin128.png"));
    private static final ImageIcon IMAGE_BOX_CHECKED = new ImageIcon(Config.getInstance().getClass().getResource("/icons/check16.png"));
    private static final ImageIcon IMAGE_BOX_UNCHECKED = new ImageIcon(Config.getInstance().getClass().getResource("/icons/checkbox16.png"));

    private final Settings settings;
    private final Config CONFIG;
    private final PropertyChangeListener configChangeListener;

    private Port port;

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

        port = new PortCom();
        //port = new PortSim();

        port.setAvailablePorts(serialComboBox);

        //super.setLocationRelativeTo(null);
        System.out.println("Start Application SPV v" + Version.getVERSION());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        mainPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        playButton = new javax.swing.JButton();
        serialComboBox = new javax.swing.JComboBox<>();
        serialRefreshButton = new javax.swing.JButton();
        serialConnectButton = new javax.swing.JButton();
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

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/violin32.png"))); // NOI18N
        playButton.setText("Play");
        playButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        playButton.setFocusable(false);
        playButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        playButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                playButtonActionPerformed(evt);
            }
        });
        toolBar.add(playButton);

        serialComboBox.setMaximumRowCount(15);
        serialComboBox.setMaximumSize(new java.awt.Dimension(70, 20));
        toolBar.add(serialComboBox);

        serialRefreshButton.setText("Refresh");
        serialRefreshButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        serialRefreshButton.setFocusable(false);
        serialRefreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        serialRefreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        serialRefreshButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                serialRefreshButtonActionPerformed(evt);
            }
        });
        toolBar.add(serialRefreshButton);

        serialConnectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/checkbox16.png"))); // NOI18N
        serialConnectButton.setText("Connect");
        serialConnectButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        serialConnectButton.setFocusable(false);
        serialConnectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        serialConnectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        serialConnectButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                serialConnectButtonActionPerformed(evt);
            }
        });
        toolBar.add(serialConnectButton);

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

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_playButtonActionPerformed
    {//GEN-HEADEREND:event_playButtonActionPerformed

    }//GEN-LAST:event_playButtonActionPerformed

    private void serialConnectButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_serialConnectButtonActionPerformed
    {//GEN-HEADEREND:event_serialConnectButtonActionPerformed
        if(port.isOpen())
        {
            // try to close
            try
            {
                port.closePort();
                serialConnectButton.setIcon(IMAGE_BOX_UNCHECKED);
            }
            catch (SerialPortException ex)
            {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            // try to open
            try
            {
                port.openPort(serialComboBox.getSelectedItem().toString());
                serialConnectButton.setIcon(IMAGE_BOX_CHECKED);
            }
            catch (SerialPortException ex)
            {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_serialConnectButtonActionPerformed

    private void serialRefreshButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_serialRefreshButtonActionPerformed
    {//GEN-HEADEREND:event_serialRefreshButtonActionPerformed
        port.setAvailablePorts(serialComboBox);
    }//GEN-LAST:event_serialRefreshButtonActionPerformed

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

        java.awt.EventQueue.invokeLater(() ->
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
    private javax.swing.JButton playButton;
    private javax.swing.JComboBox<String> serialComboBox;
    private javax.swing.JButton serialConnectButton;
    private javax.swing.JButton serialRefreshButton;
    private javax.swing.JToolBar toolBar;
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

    private void openFile()
    {

    }

    private void configChangeEvent(PropertyChangeEvent event)
    {

    }

}
