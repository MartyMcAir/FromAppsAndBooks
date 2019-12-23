Audio channel player

import java.io.File;
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


public class AudioChannelPlayer
{
private static final boolean DEBUG = true;
private static final int BUFFER_SIZE = 16384;



public static void main(String[] args)
{
 // TODO: set AudioFormat after the first soundfile
 AudioFormat audioFormat = new AudioFormat(
  AudioFormat.Encoding.PCM_SIGNED,
  44100.0F, 16, 2, 4, 44100.0F, true);
 SourceDataLine  line = null;

 try
 {
  DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
  line = (SourceDataLine) AudioSystem.getLine(info);
  line.open(audioFormat, line.getBufferSize());
 }
 catch (LineUnavailableException e)
 {
  e.printStackTrace();
 }
 line.start();
 AudioChannel channel = new AudioChannel(line);
 channel.start();
 for (int nArgPos = 0; nArgPos < args.length; nArgPos++)
 {
  if (args[nArgPos].startsWith("-s"))
  {
   String strDuration = args[nArgPos].substring(2);
   int nDuration = Integer.parseInt(strDuration);
   handleSilence(nDuration, channel);
  }
  else
  {
   handleFile(args[nArgPos], channel);
  }

 }
 // TODO: instead of waiting a fixed amount of time, wait until the queue of AudioChannel is empty.
 try
 {
  Thread.sleep(10000);
 }
 catch (InterruptedException e)
 {
 }
}


private static void handleFile(String strFilename, AudioChannel channel)
{
 File audioFile = new File(strFilename);
 AudioInputStream audioInputStream = null;
 try
 {
  audioInputStream = AudioSystem.getAudioInputStream(audioFile);
 }
 catch (Exception e)
 {
  /*
   * In case of an exception, we dump the exception
   * including the stack trace to the console output.
   * Then, we exit the program.
   */
  e.printStackTrace();
  System.exit(1);
 }
 if (audioInputStream != null)
 {
  boolean bSuccessfull = channel.addAudioInputStream(audioInputStream);
  if (! bSuccessfull)
  {
   out("Warning: could not enqueue AudioInputStream; presumably formats don't match!");
  }
 }
}


private static void handleSilence(int nDuration, AudioChannel channel)
{
}



private static void out(String strMessage)
{
 System.out.println(strMessage);
}
}


/*** AudioChannelPlayer.java ***/

Built by Text2Html 
