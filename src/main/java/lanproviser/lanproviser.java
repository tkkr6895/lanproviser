package lanproviser;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

public class lanproviser {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner moo = new Scanner(System.in);
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		langTool.activateDefaultPatternRules();
		System.out.println("Enter text for proof reading plis");
		String input = moo.nextLine();
		List<RuleMatch> matches = langTool.check(input);
		 for (RuleMatch match : matches) 
		{
		  System.out.println("YUDODIS, Plis check for error at" +
		  match.getLine() + ", column " +match.getColumn() + ": " + match.getMessage());
		  System.out.println("Corrections suggested: " +match.getSuggestedReplacements());
		}
	}

}
