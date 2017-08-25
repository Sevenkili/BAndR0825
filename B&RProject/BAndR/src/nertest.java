import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

public class nertest {
	/**
	 * @author qichenglin
	 * @param args
	 */
	public static void main(String[] args) {
		String rootPath = "/Users/qichenglin/Documents/项目/B&RProject/countrytxt/";
		PersonEntityRecognize(getFileList(rootPath));
	}
	
	/**
	 * @author qichenglin
	 * @param rootPath
	 * @return
	 */
	public static List<String> getFileList(String rootPath){
		List<String> filePathList = new ArrayList<String>();
		TextParse.getAllFilePath(rootPath,filePathList);
		return filePathList;
	}
	
	/**
	 * @author qichenglin
	 * @param filePathList
	 */
	public static void  PersonEntityRecognize(List<String> filePathList){
		for(String txtPath : filePathList){
			if(!txtPath.contains("DS_Store")){
				System.out.println(txtPath);
				String[] arr = txtPath.split("\\/");
				String countryName = arr[arr.length-1];
				StringBuffer countryTxt = TextParse.setTxt(txtPath, "utf-8");
				Result result = SegmentHandle.getNlpSegResult(countryTxt);
				List<String> personNameList = new ArrayList<String>();
				Set<String> posSet = new HashSet<String>();
				posSet.add("nr");
				posSet.add("nr1");
				posSet.add("nr2");
				posSet.add("nrj");
				posSet.add("nrf");
				for(Term term : result){
					String[] arr1 = term.toString().split("/");
					//System.out.print(term.toString()+" ");
					if(arr1.length==2 && posSet.contains(arr1[1]))//
						personNameList.add(arr1[0]);
				}
				String targetPath = "/Users/qichenglin/Documents/项目/B&RProject/countryperson/"+countryName;
				StringBuffer personNameSb = new StringBuffer();
				for(String personName:personNameList){
					System.out.println(personName);
					personNameSb.append("https://baike.baidu.com/item/"+personName+"\r\n");
					
				}
				try {
					TextParse.txtWriter(targetPath,personNameSb.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
