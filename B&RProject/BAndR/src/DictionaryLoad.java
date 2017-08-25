import java.io.IOException;
import java.util.List;
import org.ansj.library.UserDefineLibrary;

/**
 * 
 * @author qichenglin
 *
 */
public class DictionaryLoad {

	public DictionaryLoad() {
		// TODO Auto-generated constructor stub
	}

	/**加载Ansj自定义词典
	 * @author QiChenglin
	 * @throws IOException 
	 */
	public void loadAnsjDic() throws IOException {	
		TextParse tp = new TextParse();
		List<Dictionary> dic = tp.getDicList();
		for (int i = 0; i < dic.size(); i++) {		
			UserDefineLibrary.insertWord(dic.get(i).getWord(), dic.get(i).getPos(), dic.get(i).getFreq());		
		}	
	}

}
