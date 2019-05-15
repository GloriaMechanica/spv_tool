package midi;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;
import serial.Port;
import serial.PortCom;
import serial.PortSim;
import violin.Note;

/**
 *
 * @author lmessing
 */
public class MIDI
{

    /*
   0x80     Note Off
   0x90     Note On
   0xA0     Aftertouch
   0xB0     Continuous controller
   0xC0     Patch change
   0xD0     Channel Pressure
   0xE0     Pitch bend
   0xF0     (non-musical commands)
    
    
Command	Meaning	# parameters	param 1	param 2
0x80	Note-off	2	key	velocity
0x90	Note-on	2	key	veolcity
0xA0	Aftertouch	2	key	touch
0xB0	Continuous controller	2	controller #	controller value
0xC0	Patch change	2	instrument #	
0xD0	Channel Pressure	1	pressure
0xE0	Pitch bend	2	lsb (7 bits)	msb (7 bits)
0xF0	(non-musical commands)	
    
    http://fmslogo.sourceforge.net/manual/midi-table.html
    
     */
    private final Port port;

    private static final byte CMD_NOTE_OFF = (byte) 0x80;
    private static final byte CMD_NOTE_ON = (byte) 0x90;

    public MIDI(String port, boolean simulate)
    {
        try
        {
            if(simulate)
                this.port = new PortSim(port);
            else
                this.port = new PortCom(port);

            this.port.openPort();
            this.port.setDefaultParams();
        }
        catch (SerialPortException ex)
        {
            throw new IllegalArgumentException(ex);
        }

    }

    public void startNote(Note note)
    {
        try
        {
            byte[] cmd = buildCommand(CMD_NOTE_ON, note.getKey(), note.getVelocity());
            port.sendBytes(cmd);
            printCommand(cmd);
        }
        catch (SerialPortException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void stopNote(Note note)
    {
        try
        {
            byte[] cmd = buildCommand(CMD_NOTE_OFF, note.getKey(), note.getVelocity());
            port.sendBytes(cmd);
            printCommand(cmd);
        }
        catch (SerialPortException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private byte[] buildCommand(byte cmd, byte key, byte velocity)
    {
        byte[] bytes =
        {
            cmd, key, velocity
        };

        return bytes;
    }

    private String getHex(byte singleByte)
    {
        return String.format("0x%02X", singleByte);
    }

    private void printCommand(byte[] cmd)
    {
        System.out.println("CMD: " + getHex(cmd[0]) + " " + getHex(cmd[1]) + " " + getHex(cmd[2]));
    }

}
