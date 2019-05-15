package serial;

import jssc.*;

/**
 *
 * @author lmessing
 */
public class PortCom implements Port
{

    private SerialPort port;

    private static final int DEFAULT_DATABITS = SerialPort.DATABITS_8;
    private static final int DEFAULT_STOPBITS = SerialPort.STOPBITS_1;
    private static final int DEFAULT_PARITY = SerialPort.PARITY_NONE;
    private static final int DEFAULT_BAUDRATE = 31250;   // baudrate of MIDI

    /**
     * @brief Default Baudrate is 31250 Default Databits is 8 Default Stopbits is 1 Default Parity is none
     *
     * @param port COM0, COM1, ...
     *
     * @throws jssc.SerialPortException
     */
    public PortCom(String port) throws SerialPortException
    {
        this.port = new SerialPort(port);
    }

    /**
     * @brief If port busy TYPE_PORT_BUSY exception will be thrown. If port not found TYPE_PORT_NOT_FOUND exception will be thrown.
     *
     * @throws SerialPortException
     */
    @Override
    public void openPort() throws SerialPortException
    {
        port.openPort();
    }

    @Override
    public void closePort() throws SerialPortException
    {
        port.closePort();
    }

    @Override
    public void sendString(String str) throws SerialPortException
    {
        port.writeString(str);
    }

    @Override
    public void sendBytes(byte[] bytes) throws SerialPortException
    {
        port.writeBytes(bytes);
    }

    @Override
    public void sendByte(byte singleByte) throws SerialPortException
    {
        port.writeByte(singleByte);
    }

    @Override
    public void setDefaultParams() throws SerialPortException
    {
        port.setParams(DEFAULT_BAUDRATE, DEFAULT_DATABITS, DEFAULT_STOPBITS, DEFAULT_PARITY);
    }

}
