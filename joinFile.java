/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Lata
 */
public class joinFile {
    
    
    public static void join( String Name) {
        
        String FilePath = common.getinstance().filepath;
long leninfile = 0, leng = 0;
int count = 0, data = 0;
File requstedFileName=new File( common.getinstance().filepath, Name);

////search for files having name as filname.ext.001.0 and so on
/// then pass to decoder to generate filename.ext.001.recovered
/// join all these files to get filname.ext.recovered 
///down load the result as filename.ext
int cnt=1;
SampleDecoder sd = new SampleDecoder();

//while (true){
    while (cnt<7){
File partFile =new File(requstedFileName.getName() +String.format("%03d", cnt));
//if(partFile.exists())
//{
try{
sd.domain(partFile.getName());
}
catch(IOException ex)
{
    System.out.println("could not read " +requstedFileName.getName() +String.format("%03d", count));
}

cnt++;
//}
//else
//{
 //   break;
//}
}

////////////////join recoverd files 
while (true) {
//filename = new File(FilePath + count + ".sp");
requstedFileName = new File(FilePath +"\\" +Name +"." + String.format("%03d", count) );
if (requstedFileName.exists()) {


try {
File filenameOut = new File(FilePath + "\\" + Name + ".new");
File filename;

OutputStream outfile = new BufferedOutputStream(new FileOutputStream(filenameOut));
while (true) {
//filename = new File(FilePath + count + ".sp");
filename = new File(FilePath +"\\" +Name +"." + String.format("%03d", count )+".decoded" );
if (filename.exists()) {
InputStream infile = new BufferedInputStream(new FileInputStream(filename));
data = infile.read();
while (data != -1) {
outfile.write(data);
data = infile.read();
}
leng++;
infile.close();
count++;
} else {
break;
}
}
outfile.close();
} catch (Exception e) {
e.printStackTrace();
}
} //end if
System.out.println("deoded and joined successfully");
    
} // end while


    } //end join method
} //end class
