package lanproviser;
import java.io.IOException;
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
		 for (RuleMatch match : matches) 
		{
		  System.out.println("Errors found at" +
		  match.getLine() + ", column " +match.getColumn() + ": " + match.getMessage());
		  System.out.println("Suggested correction " +match.getSuggestedReplacements());
		}
		 
	}

}
