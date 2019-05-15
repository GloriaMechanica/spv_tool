
package serial;

import javax.swing.JComboBox;
import jssc.*;

/**
 *
 * @author lmessing
 */
public class PortSim implements Port
{

    private boolean open = false;

    public PortSim()
    {
        //throw new UnsupportedOperationException("PortSim.PortSim not implemented");
    }

    @Override
    public void openPort(String portName) throws SerialPortException
    {
        open = true;
        //throw new UnsupportedOperationException("PortSim.openPort not implemented");
    }

    @Override
    public void closePort() throws SerialPortException
    {
        open = false;
        //throw new UnsupportedOperationException("PortSim.closePort not implemented");
    }

    @Override
    public void writeString(String str) throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.sendString not implemented");
    }

    @Override
    public void writeBytes(byte[] bytes) throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.sendBytes not implemented");
    }

    @Override
    public void writeByte(byte singleBytes) throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.sendBytes not implemented");
    }

    @Override
    public void setAvailablePorts(JComboBox<String> comboBox)
    {
        String[] portNames =
        {
            "COM1", "COM2", "COM20"
        };

        comboBox.removeAllItems();
        for(String portName : portNames)
        {
            comboBox.addItem(portName);
        }
    }

    @Override
    public boolean isOpen()
    {
        //throw new UnsupportedOperationException("PortSim.isOpen not implemented");
        return open;
    }

}
