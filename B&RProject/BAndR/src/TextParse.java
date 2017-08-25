
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;





/**文本处理的各种操作
 * @author QiChenglin
 *
 */
public class TextParse {
//private static ArrayList<String> textList; 
//public final int TITLE_WEIGHT = 10;
//public final int FIRST_PARA_WEIGHT = 2;
//public final int OTHER_PARA_WEIGHT = 1;


	public List<Dictionary> getDicList(){
		//Property p = new Property();
		String path ="/Users/qichenglin/Documents/workspace/Ansj/library/customerdic_policy.txt"; 
		String encode = "utf-8";
		String str = "";
		StringBuffer sb1 = new StringBuffer();
		List<Dictionary> wordItemList = new ArrayList<Dictionary>();
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(path), encode);
			BufferedReader bufferedIn = new BufferedReader(isr);
			while ((str = bufferedIn.readLine()) != null) {
				if(str.equals(""));
				else{
					String[] array = str.split("\t");
					Dictionary dic = new Dictionary(array[0],array[1], Integer.parseInt(array[2]));
					wordItemList.add(dic);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordItemList;
	}
	
	/**
	 * @author qichenglin
	 * @param path
	 * @param encode
	 * @return
	 */
	public static StringBuffer setTxt(String path,String encode){
		StringBuffer sb = new StringBuffer();
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(path), encode);
			BufferedReader bufferedIn = new BufferedReader(isr);
			String str = "";
			while((str = bufferedIn.readLine()) != null){
				if(!str.equals("")){
					sb.append(str);
				}
					
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	public static void getAllFilePath(String rootPath,List<String> fileList) {
	
		//List<String> listTemp = new ArrayList<String>();
	    File file = new File(rootPath);
	    if (file.exists()) {
	        File[] files = file.listFiles();
	        if (files.length == 0) {
	            System.out.println("文件夹是空的!");
	            return;
	        } else {
	            for (File file2 : files) {
	                if (file2.isDirectory()) {
	                   // System.out.println("文件夹:" + file2.getAbsolutePath());
	                    getAllFilePath(file2.getAbsolutePath(),fileList);
	                } else {
	                   // System.out.println("文件:" + file2.getAbsolutePath());
	                    fileList.add(file2.getAbsolutePath());
	                }
	            }
	        }
	    } else {
	        System.out.println("文件不存在!");
	    }
	    
	}
	
	
	
	
	
		public static String getTextIterm(ArrayList<String> list,int i){
			//list.clear();
			String list_str = list.get(i);
			return list_str;
		}
	
		/** 
		 * 创建文件 
		 * @param fileName    fileName = new File(PATH);
		 * @return 
		 */  
		public static boolean createFile(File fileName)throws Exception{  
		 boolean flag=false;  
		 if(!fileName.getParentFile().exists()) {  
	         //如果目标文件所在的目录不存在，则创建父目录  
	         System.out.println("目标文件所在目录不存在，准备创建它！");  
	         if(!fileName.getParentFile().mkdirs()) {  
	        	 System.out.println(fileName.getParentFile());
	             System.out.println("创建目标文件所在目录失败！");  
	             return false;  
	         }  
	     } 
		 try{  
		  if(!fileName.exists()){  
		   fileName.createNewFile();  
		   flag=true;  
		  }  
		 }catch(Exception e){  
		  e.printStackTrace();  
		 }  
		 return flag;  
		}   
	    /**
	     * 创建目录
	     * @param destDirName
	     * @return
	     */
		public static boolean createDir(String destDirName) {  
	        File dir = new File(destDirName);  
	        if (dir.exists()) {  
	            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");  
	            return false;  
	        }  
	        if (!destDirName.endsWith(File.separator)) {  
	            destDirName = destDirName + File.separator;  
	        }  
	        //创建目录  
	        if (dir.mkdirs()) {  
	            System.out.println("创建目录" + destDirName + "成功！");  
	            return true;  
	        } else {  
	            System.out.println("创建目录" + destDirName + "失败！");  
	            return false;  
	        }  
	    }  
		
		  /**
		   *  向指定路径的文件写入内容
		   * @param path
		   * @param content
		   * @return
		   * @throws Exception
		   */
		public static boolean txtWriter(String path,String content) throws Exception{
			File fileName = new File(path);
			boolean flag = false;
			createFile(fileName);
				FileOutputStream fos = new FileOutputStream(path,true);
				fos.write(content.getBytes());
				fos.close();
				flag = true;
			//}
			return flag;
		}
		


}
