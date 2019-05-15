
package serial;

import javax.swing.JComboBox;
import jssc.*;

/**
 *
 * @author lmessing
 */
public class PortCom implements Port
{

    private SerialPort port = null;

    public PortCom()
    {
    }

    /**
     * @brief If port busy TYPE_PORT_BUSY exception will be thrown. If port not found
     * TYPE_PORT_NOT_FOUND exception will be thrown.
     *
     * @param portName COM1, COM2, ...
     *
     * @throws SerialPortException
     */
    @Override
    public void openPort(String portName) throws SerialPortException
    {
        closePort();   // only closes the port if it is actually open
        port = new SerialPort(portName);
        port.setParams(Port.DEFAULT_BAUDRATE, Port.DEFAULT_DATABITS, Port.DEFAULT_STOPBITS, Port.DEFAULT_PARITY);
        port.openPort();
    }

    @Override
    public void closePort() throws SerialPortException
    {
        if(port != null && port.isOpened())
            port.closePort();

    }

    @Override
    public void writeString(String str) throws SerialPortException
    {
        if(port != null && port.isOpened())
        {
            port.writeString(str);
        }
    }

    @Override
    public void writeBytes(byte[] bytes) throws SerialPortException
    {
        if(port != null && port.isOpened())
        {
            port.writeBytes(bytes);
        }
    }

    @Override
    public void writeByte(byte singleByte) throws SerialPortException
    {
        if(port != null && port.isOpened())
        {
            port.writeByte(singleByte);
        }
    }

    @Override
    public void setAvailablePorts(JComboBox<String> comboBox)
    {
        String[] portNames = SerialPortList.getPortNames();

        comboBox.removeAllItems();
        for(String portName : portNames)
        {
            comboBox.addItem(portName);
        }
    }

    @Override
    public boolean isOpen()
    {
        if(port != null)
            return port.isOpened();
        else
            return false;
    }

}
