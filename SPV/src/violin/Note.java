package violin;

/**
 *
 * @author lmessing
 */
public class Note
{

    private boolean playing = false;
    private final String name;
    private final byte key;
    private byte velocity;

    public Note(String name, byte key, byte velocity)
    {
        this.name = name;

        if(key > 128)
            key = (byte) 128;

        if(velocity > 128)
            velocity = (byte) 128;

        this.key = key;
        this.velocity = velocity;
    }

    public Note(String name, int value)
    {
        this.name = name;
        this.key = (byte) value;
    }

    public boolean isPlaying()
    {
        return playing;
    }

    public void setPlaying(boolean playing)
    {
        this.playing = playing;
    }

    public String getName()
    {
        return name;
    }

    public byte getKey()
    {
        return key;
    }

    public byte getVelocity()
    {
        return velocity;
    }

}
