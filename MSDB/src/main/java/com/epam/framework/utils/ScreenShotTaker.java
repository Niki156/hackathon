package com.epam.framework.utils;

import com.epam.framework.loggers.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import static com.epam.hackathon.constants.ConstantsSetUp.SCREENSHOTS_LOCATION;

public class ScreenShotTaker {
    private ScreenShotTaker(){}
    public static File takeScreenShot(WebDriver driver,String fileName) {
     File imagefile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     File targetFile=new File(SCREENSHOTS_LOCATION+fileName+".jpeg");
        try {
            FileUtils.copyFile(imagefile,targetFile);
        } catch (IOException e) {
            Log.logInfo(e);
        }
        return targetFile;
    }
    public static void highLightElementAndTakeScreenShot(WebDriver driver, WebElement element,String fileName){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);
        takeScreenShot(driver,fileName);
    }

    public static void main(String args[]) throws InterruptedException {
        int j=2601;
        File folder = new File("D:\\first\\Folder13(4713-5617)");
        File[] listOfFiles = folder.listFiles();

        Arrays.sort( listOfFiles, new Comparator<File>() {
            public int compare(File a, File b ) {
                String s =a.getName().substring(1,5);
                String s1 = b.getName().substring(1,5);
                return Integer.parseInt(s)-Integer.parseInt(s1);
            }
        });
        System.out.println(listOfFiles[0].getName());
        for(File file:listOfFiles)
             System.out.println(file.getName());
        Thread.sleep(10000);
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String prefix = listOfFiles[i].getName().substring(0, 1);
                File sourceFile = listOfFiles[i];
                File targetFile = new File("D:\\second\\Folder13(4713-5617)\\" + prefix + j++ + ".tif");
                try {
                    FileUtils.copyFile(sourceFile, targetFile);
                    sourceFile.delete();
                } catch (IOException e) {
                    Log.logInfo(e);
                }
            }
        }

         folder = new File("D:\\second\\Folder13(4713-5617)");
         listOfFiles = folder.listFiles();

        Arrays.sort( listOfFiles, new Comparator<File>() {
            public int compare(File a, File b ) {
                String s =a.getName().substring(1,5);
                String s1 = b.getName().substring(1,5);
                return Integer.parseInt(s)-Integer.parseInt(s1);
            }
        });
        for(File file:listOfFiles)
            System.out.println(file.getName());
    }


    private static void run(int i, int l) {
        File sourceFile = new File("D:\\first\\Folder13(4713-5617)\\1000"+i+".tif");
        File targetFile=new File("D:\\second\\Folder13(4713-5617)\\"+l+".tif");
        try {
            FileUtils.copyFile(sourceFile,targetFile);
            sourceFile.delete();
        } catch (IOException e) {
            Log.logInfo(e);
        }
    }

}
