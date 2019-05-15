/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

import javax.swing.JComboBox;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author lmessing
 */
public interface Port
{

    static final int DEFAULT_DATABITS = SerialPort.DATABITS_8;
    static final int DEFAULT_STOPBITS = SerialPort.STOPBITS_1;
    static final int DEFAULT_PARITY = SerialPort.PARITY_NONE;
    static final int DEFAULT_BAUDRATE = 115200;

    public void openPort(String portName) throws SerialPortException;

    public void closePort() throws SerialPortException;

    public boolean isOpen();

    public void writeString(String str) throws SerialPortException;

    public void writeBytes(byte[] bytes) throws SerialPortException;

    public void writeByte(byte singleByte) throws SerialPortException;

    public void setAvailablePorts(JComboBox<String> comboBox);

}
