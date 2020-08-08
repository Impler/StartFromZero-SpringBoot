package com.study.springboot;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  public static void main(String[] args) {
    File folder = new File("E:\\视频教学\\图灵VIP架构师");
//    File folder = new File("E:\\视频教学\\图灵VIP架构师");
    renameFile(folder);
  }

  public static void renameFile(File file) {
    if (null != file && file.isFile()) {
      String fileName = file.getName();
      Pattern p = Pattern.compile("\\[.*\\](.*)");
      Matcher match = p.matcher(fileName);
      if(match.matches()){
        System.out.println(fileName + ", " + match.group(1));
        file.renameTo(new File(file.getParent(), match.group(1)));
      }
    } else {
      File[] files = file.listFiles();
      for (File f : files) {
        renameFile(f);
      }
    }
  }
}
