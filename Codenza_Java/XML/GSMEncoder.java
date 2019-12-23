GSMEncoder

import java.io.IOException;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

// not portable, but cannot be avoided currently
import org.tritonus.share.sampled.AudioFileTypes;
import org.tritonus.share.sampled.Encodings;


GSMEncoder.java


public class GSMEncoder
{
public static void main(String[] args)
{
 if (args.length != 2)
 {
  printUsageAndExit();
 }
 File pcmFile = new File(args[0]);
 File gsmFile = new File(args[1]);
 AudioInputStream ais = null;
 try
 {
  ais = AudioSystem.getAudioInputStream(pcmFile);
 }
 catch (Exception e)
 {
  e.printStackTrace();
 }
 if (ais == null)
 {
  out("cannot open audio file");
  System.exit(1);
 }
 AudioFormat.Encoding targetEncoding = Encodings.getEncoding("GSM0610");
 AudioInputStream gsmAIS = AudioSystem.getAudioInputStream(targetEncoding, ais);
 AudioFileFormat.Type fileType = AudioFileTypes.getType("GSM", ".gsm");
 int nWrittenFrames = 0;
 try
 {
  nWrittenFrames = AudioSystem.write(gsmAIS, fileType, gsmFile);
 }
 catch (IOException e)
 {
  e.printStackTrace();
 }
}



private static void printUsageAndExit()
{
  out("GSMEncoder: usage:");
  out("	java GSMEncoder ");
  System.exit(1);
}


private static void out(String strMessage)
{
 System.out.println(strMessage);
}
}


/*** GSMEncoder.java ***/

Built by Text2Html
