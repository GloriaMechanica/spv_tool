package serial;

import jssc.*;

/**
 *
 * @author lmessing
 */
public class PortSim implements Port
{

    public PortSim(String port)
    {
        //throw new UnsupportedOperationException("PortSim.PortSim not implemented");
    }

    @Override
    public void openPort() throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.openPort not implemented");
    }

    @Override
    public void closePort() throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.closePort not implemented");
    }

    @Override
    public void sendString(String str) throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.sendString not implemented");
    }

    @Override
    public void sendBytes(byte[] bytes) throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.sendBytes not implemented");
    }

    @Override
    public void sendByte(byte singleBytes) throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.sendBytes not implemented");
    }

    @Override
    public void setDefaultParams() throws SerialPortException
    {
        //throw new UnsupportedOperationException("PortSim.setDefaultParams not implemented");
    }

}
