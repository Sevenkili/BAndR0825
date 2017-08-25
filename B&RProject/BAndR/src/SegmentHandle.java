import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.NlpAnalysis;

public class SegmentHandle {
   /**
    * @author qichenglin
    * @param sb
    * @return
    */
	public static Result getNlpSegResult(StringBuffer sb){
	 	  return NlpAnalysis.parse(sb.toString());
	}
	

}
