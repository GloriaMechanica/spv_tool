package violin;

import java.util.ArrayList;
import midi.MIDI;

/**
 *
 * @author lmessing
 */
public class Violin
{

    private MIDI midi;

    public final Note A;
    public final Note B;
    public final Note C;

    public Violin(String port)
    {
        this.midi = new MIDI(port, false);

        A = new Note("A", 56);
        B = new Note("B", 58);
        C = new Note("C", 60);

    }

    public void startNote(Note note)
    {
        if(!note.isPlaying())
        {
            midi.startNote(note);
            note.setPlaying(true);
        }
    }

    public void stopNote(Note note)
    {
        if(note.isPlaying())
        {
            midi.stopNote(note);
            note.setPlaying(false);
        }
    }

}
