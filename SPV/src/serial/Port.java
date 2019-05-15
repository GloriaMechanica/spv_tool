/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

import jssc.SerialPortException;

/**
 *
 * @author lmessing
 */
public interface Port
{

    /**
     * @brief If port busy TYPE_PORT_BUSY exception will be thrown. If port not found TYPE_PORT_NOT_FOUND exception will be thrown.
     *
     * @throws SerialPortException
     */
    public void openPort() throws SerialPortException;

    public void closePort() throws SerialPortException;

    public void sendString(String str) throws SerialPortException;

    public void sendBytes(byte[] bytes) throws SerialPortException;

    public void sendByte(byte singleByte) throws SerialPortException;

    public void setDefaultParams() throws SerialPortException;
    
}
