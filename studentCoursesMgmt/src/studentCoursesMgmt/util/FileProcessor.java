package studentCoursesMgmt.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileProcessor {
	
    private static String filePath;
    FileWriter myFileWriter;
    /**
     * @param filePath
     */
    public FileProcessor(String filePath){
        this.filePath=filePath;
    }
    
    /**
     * @return Scanner Object
     */
    public Scanner getFileReader(){
        Scanner sc=null;
        try {
            sc=new Scanner(new File(filePath));
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Please enter a file to process on");
            e.printStackTrace();
            System.exit(0);
        }catch(FileNotFoundException e){
            System.err.println("PLease give the correct input file");
            e.printStackTrace();
            System.exit(0);
        }catch (NoSuchElementException e){
            System.err.println("Input File is Empty");
            e.printStackTrace();
            System.exit(0);
        }
        return sc;
    }
    /**
	 * @param filePath
	 * @return Map of courses as key and int [] of capacity and timing of the course
	 */
	public Map<Character, int[]> readFile(){
        Map<Character,int[]>courseInfo=new HashMap<>();
        Scanner sc;
        try {
            sc=getFileReader();
            while(sc.hasNextLine()){
                String[]temp=sc.nextLine().split(":");
                char name=temp[0].charAt(0);
                int a=Integer.parseInt(temp[1]);
                int b=Integer.parseInt(temp[2]);
                courseInfo.put(name, new int[]{a, b});
            }
            sc.close();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please enter a file to process on");
            e.printStackTrace();
            System.exit(0);
        }catch (NoSuchElementException e){
            System.out.println("Input File is Empty");
            e.printStackTrace();
            System.exit(0);
        }
        return courseInfo;
        
    }
    /**
     * @param scanner
     * @return String- return the line on which scanner has requested
     */
    public String[] readLine(Scanner scanner){
        String[] list=new String[10];
            for(int i=0;i<list.length;i++){
                list[i]=scanner.next();
            }
            return list;
    }
    /**
     * @param string
     */
    public void Write(String string){
       try {
        if(myFileWriter==null){
            myFileWriter=new FileWriter(filePath,false);
        }
            myFileWriter.write(string);
    } catch (IOException e) {
        System.err.println("File Path is not found for writing the file");
        e.printStackTrace();
        System.exit(0);
    }       
 }
     
    public void colseFileWriter(){
        try {
            if(myFileWriter==null) return;
            myFileWriter.close();
        } catch (IOException e) {
            System.err.println("Writer is not created to close it");
            e.printStackTrace();
            System.exit(0);
        }
     }
}
