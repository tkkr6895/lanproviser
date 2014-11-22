package lanproviser;
import java.io.IOException;
import javax.swing.*;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

class lanproviser {

	public void grammar(String moo) throws IOException{
		// TODO Auto-generated method stub

		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		langTool.activateDefaultPatternRules();
		List<RuleMatch> matches = langTool.check(moo);
		
		if(matches.isEmpty()){
			JOptionPane.showMessageDialog(null, "Whoo! No errors!");
		}
		else{
		 for ( RuleMatch match : matches) 
		{
			
		  JOptionPane.showMessageDialog(null,"Input Text is\n"+moo+"\nErrors found at line " +
		  match.getLine() + ", column " +match.getColumn() + ": " + match.getMessage() +"\nSuggested correction " +match.getSuggestedReplacements());
		}
		}
		
		 
	}

}
