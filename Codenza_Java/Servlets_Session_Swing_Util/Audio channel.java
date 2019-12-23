Audio channel

import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.BooleanControl;


// IDEA: can this class be derived from AudioStream??
public class AudioChannel
extends  Thread
{
private static final boolean DEBUG = true;
private static final int BUFFER_SIZE = 16384;

private List   m_audioStreamQueue;
private SourceDataLine  m_line;
private byte[]   m_dataArray;



/*
 * Uses the passed Mixer.
 */
public AudioChannel(SourceDataLine line)
{
 super("AudioChannel");
 /*  Setting this thread to daemon means that this thread
  doesn't prevent the VM from exiting even if it is
  still running.
  */
 setDaemon(true);
 // TODO: check if priority makes sense
 setPriority(9);
 m_line = line;
 m_audioStreamQueue = new ArrayList();
 // TODO: make size configurable
 int nBufSizeInFrames = 0;
 if (m_line.getBufferSize() > 0)
 {
  nBufSizeInFrames = m_line.getBufferSize() / 2;
 }
 else
 {
  nBufSizeInFrames = 4096;
 }
 m_dataArray = new byte[nBufSizeInFrames];
}



public AudioFormat getFormat()
{
 return m_line.getFormat();
}


public boolean addAudioInputStream(AudioInputStream audioStream)
{
 if (DEBUG) { out("AudioChannel.addAudioInputStream(): called."); }
 if (!getFormat().matches(audioStream.getFormat()))
 {
  if (DEBUG) { out("AudioChannel.addAudioInputStream(): audio formats do not match, trying to convert."); }
  AudioInputStream asold = audioStream;
  audioStream = AudioSystem.getAudioInputStream(getFormat(), asold);
  if (audioStream == null)
  {
   out("###  AudioChannel.addAudioInputStream(): could not convert.");
   return false;
  }
  if (DEBUG) { out(" converted"); }
 }
 synchronized (m_audioStreamQueue)
 {
  m_audioStreamQueue.add(audioStream);
  m_audioStreamQueue.notifyAll();
 }
 if (DEBUG) { out("AudioChannel.addAudioInputStream(): enqueued " + audioStream); }
 return true;
}


// TODO: termination of loop
public void run()
{
 if (DEBUG)
 {
  out("AudioChannel.run(): starting");
 }
 while (true)
 {
  AudioInputStream audioStream = null;
  synchronized (m_audioStreamQueue)
  {
   while (m_audioStreamQueue.size() == 0)
   {
    try
    {
     m_audioStreamQueue.wait();
    }
    catch (InterruptedException e)
    {
     e.printStackTrace();
    }
   }
   audioStream = (AudioInputStream) m_audioStreamQueue.remove(0);
  }
  if (DEBUG)
  {
   out("AudioChannel.run(): playing " + audioStream);
  }
  int nBytesRead;
  while (true)
  {
   try
   {
    nBytesRead = audioStream.read(m_dataArray);
    if (nBytesRead == -1)
    {
     // m_line.write(null, 0, 0);
     break;
    }
    int nBytesWritten = m_line.write(m_dataArray, 0, nBytesRead);
    // Contract.check(nBytesWritten == nBytesRead);
   }
   catch (IOException e)
   {
    e.printStackTrace();
    break;
   }
  }
 }
}


public void closeChannel()
{
 // TODO:
}


public void startChannel()
{
 // TODO:
 m_line.start();
 super.start();
}



// should not block, but trigger the termination
public void stopChannel()
{
 // TODO: do some mystery to
 // a) stop the line (without interupting current plays)
 // b) stop the Thread
}



private static void out(String strMessage)
{
 System.out.println(strMessage);
}
}

/*** AudioChannel.java ***/

Built by Text2Html 
