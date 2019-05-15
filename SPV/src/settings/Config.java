package settings;

import gui.Settings;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmessing
 */
public class Config
{

    private static Config CONFIG = null;

    private final String directoryPath = System.getProperty("user.home") + "\\Documents\\SPV";
    private final String filename = "SPV.properties";
    private final String filePath = directoryPath + "\\" + filename;

    private Properties properties;
    private PropertyChangeListener listener = null;

    private static final String VALUE_TRUE = "true";
    private static final String VALUE_FALSE = "false";

    private static final String WINDOW_MODE_NORMAL = String.valueOf(Frame.NORMAL);
    private static final String WINDOW_MODE_MAX_BOTH = String.valueOf(Frame.MAXIMIZED_BOTH);
    private static final String WINDOW_MODE_MAX_HORIZ = String.valueOf(Frame.MAXIMIZED_HORIZ);
    private static final String WINDOW_MODE_MAX_VERT = String.valueOf(Frame.MAXIMIZED_VERT);

    private static final String KEY_WINDOW_SIZE_X = "WINDOW_SIZE_X";
    private static final String KEY_WINDOW_SIZE_Y = "WINDOW_SIZE_Y";
    private static final String KEY_WINDOW_LOCATION_X = "WINDOW_LOCATION_X";
    private static final String KEY_WINDOW_LOCATION_Y = "WINDOW_LOCATION_Y";
    private static final String KEY_WINDOW_MODE = "WINDOW_MODE";
    private static final String KEY_ACTIVE_CONFIG_PANEL = "ACTIVE_CONFIG_PANEL";
    private static final String KEY_SERIAL_PORT = "SERIAL_PORT";

    private static final String KEY_WINDOW_SIZE_X_DEFAULT = "1400";
    private static final String KEY_WINDOW_SIZE_Y_DEFAULT = "800";
    private static final String KEY_WINDOW_LOCATION_X_DEFAULT = "0";
    private static final String KEY_WINDOW_LOCATION_Y_DEFAULT = "0";
    private static final String KEY_WINDOW_MODE_DEFAULT = WINDOW_MODE_NORMAL;
    private static final String KEY_ACTIVE_CONFIG_PANEL_DEFAULT = "0";
    private static final String KEY_SERIAL_PORT_DEFAULT = "COM0";

    private Config()
    {
        properties = new Properties(getDefaultProperties());

        try
        {

            properties = loadProperties(filePath);

            properties.list(System.out);

            saveSettingsToFile(directoryPath, filename);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Config getInstance()
    {
        if(CONFIG == null)
        {
            CONFIG = new Config();
        }

        return CONFIG;
    }

    public void save()
    {
        try
        {
            saveSettingsToFile(directoryPath, filename);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load()
    {
        try
        {
            loadProperties(filePath);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setListener(PropertyChangeListener listener)
    {
        this.listener = listener;
    }

    public int getWindowSizeX()
    {
        return Integer.parseInt(properties.getProperty(KEY_WINDOW_SIZE_X, KEY_WINDOW_SIZE_X_DEFAULT));
    }

    public int getWindowSizeY()
    {
        return Integer.parseInt(properties.getProperty(KEY_WINDOW_SIZE_Y, KEY_WINDOW_SIZE_Y_DEFAULT));
    }

    public Dimension getWindowDimension()
    {
        int x = getWindowSizeX();
        int y = getWindowSizeY();

        return new Dimension(x, y);
    }

    public void storeWindowSizeX(int x)
    {
        properties.setProperty(KEY_WINDOW_SIZE_X, String.valueOf(x));
        save();
    }

    public void storeWindowSizeY(int y)
    {
        properties.setProperty(KEY_WINDOW_SIZE_Y, String.valueOf(y));
        save();
    }

    public void storeWindowSize(int x, int y)
    {
        properties.setProperty(KEY_WINDOW_SIZE_X, String.valueOf(x));
        properties.setProperty(KEY_WINDOW_SIZE_Y, String.valueOf(y));
        save();
    }

    public void storeWindowLocationX(int x)
    {
        storeInteger(KEY_WINDOW_LOCATION_X, x, false);
        save();
    }

    public void storeWindowLocationY(int y)
    {
        storeInteger(KEY_WINDOW_LOCATION_Y, y, false);
        save();
    }

    public void storeWindowLocation(int x, int y)
    {
        storeInteger(KEY_WINDOW_LOCATION_X, x, false);
        storeInteger(KEY_WINDOW_LOCATION_Y, y, false);
        save();
    }

    public void storeWindowLocation(Point point)
    {
        storeWindowLocation(point.x, point.y);
    }

    public Point getWindowLocation()
    {
        int x = getInteger(KEY_WINDOW_LOCATION_X);
        int y = getInteger(KEY_WINDOW_LOCATION_Y);

        return new Point(x, y);
    }

    public int getWindowMode()
    {
        int mode = Integer.parseInt(properties.getProperty(KEY_WINDOW_MODE, KEY_WINDOW_MODE_DEFAULT));

        if(mode != Frame.NORMAL
                && mode != Frame.MAXIMIZED_BOTH
                && mode != Frame.MAXIMIZED_HORIZ
                && mode != Frame.MAXIMIZED_VERT)
        {
            mode = Frame.NORMAL;
            storeWindowMode(mode);
        }

        return mode;
    }

    public void storeWindowMode(int mode)
    {
        if(mode != Frame.NORMAL
                && mode != Frame.MAXIMIZED_BOTH
                && mode != Frame.MAXIMIZED_HORIZ
                && mode != Frame.MAXIMIZED_VERT)
        {
            mode = Frame.NORMAL;
        }

        properties.setProperty(KEY_WINDOW_MODE, String.valueOf(mode));

    }

    private static Properties getDefaultProperties()
    {
        Properties defaultProps = new Properties();

        defaultProps.setProperty(KEY_WINDOW_SIZE_X, KEY_WINDOW_SIZE_X_DEFAULT);
        defaultProps.setProperty(KEY_WINDOW_SIZE_Y, KEY_WINDOW_SIZE_Y_DEFAULT);
        defaultProps.setProperty(KEY_WINDOW_LOCATION_X, KEY_WINDOW_LOCATION_X_DEFAULT);
        defaultProps.setProperty(KEY_WINDOW_LOCATION_Y, KEY_WINDOW_LOCATION_Y_DEFAULT);
        defaultProps.setProperty(KEY_WINDOW_MODE, KEY_WINDOW_MODE_DEFAULT);
        defaultProps.setProperty(KEY_ACTIVE_CONFIG_PANEL, KEY_ACTIVE_CONFIG_PANEL_DEFAULT);
        defaultProps.setProperty(KEY_SERIAL_PORT, KEY_SERIAL_PORT_DEFAULT);

        return defaultProps;
    }

    private void saveSettingsToFile(String path, String filename) throws IOException
    {
        File directory = new File(path);
        File file = new File(path + "\\" + filename);

        //System.out.println(file.toString());
        directory.mkdir();
        file.createNewFile();

        OutputStream output = new FileOutputStream(file, false);

        properties.store(output, "\n WINDOW_MODE   0-normal, 6-maximized\n");

    }

    private static Properties loadProperties(String filePath) throws FileNotFoundException, IOException
    {
        Properties prop = new Properties(getDefaultProperties());
        File file = new File(filePath);

        if(file.exists())
        {
            FileInputStream inputStream = new FileInputStream(file);
            prop.load(inputStream);
        }
        else
        {
            throw new FileNotFoundException();
        }
        return prop;
    }

    public void revertSettings()
    {
        System.out.println("Settings reverting!");
        properties = getDefaultProperties();
        save();

    }

    public int getActiveConfigPanel()
    {
        return Integer.parseInt(properties.getProperty(KEY_ACTIVE_CONFIG_PANEL, KEY_ACTIVE_CONFIG_PANEL_DEFAULT));
    }

    public String getActiveConfigPanelKey()
    {
        return KEY_ACTIVE_CONFIG_PANEL;
    }

    public void storeActiveConfigPanel(int panelIndex, boolean notify)
    {
        storeInteger(KEY_ACTIVE_CONFIG_PANEL, panelIndex, notify);
    }

    public String getSerialPort()
    {
        return (String) properties.getProperty(KEY_SERIAL_PORT, KEY_SERIAL_PORT_DEFAULT);
    }

    public void storeSerialPort(String port, boolean notify)
    {
        storeString(KEY_SERIAL_PORT, port, notify);
    }

    private int getInteger(String key)
    {
        return Integer.parseInt(properties.getProperty(key));
    }

    private String getString(String key)
    {
        return (String) properties.getProperty(key);
    }

    private void storeInteger(String key, int value, boolean notify)
    {
        String str = String.valueOf(value);
        int old_value = Integer.parseInt((String) properties.setProperty(key, str));

        if(notify)
        {
            notifyListener(key, old_value, value);
        }
    }

    private void storeString(String key, String value, boolean notify)
    {
        String old_value = (String) properties.setProperty(key, value);

        if(notify)
        {
            notifyListener(key, old_value, value);
        }
    }

    private void notifyListener(String property, Object old_value, Object new_value)
    {
        PropertyChangeEvent event = new PropertyChangeEvent(this, property, old_value, new_value);

        listener.propertyChange(event);
    }

}
