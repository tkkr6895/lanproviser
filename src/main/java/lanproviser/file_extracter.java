package lanproviser;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.awt.*;

class file_extracter
{
	BufferedReader in;
	Pattern p;
	Matcher m;
	private HashMap<String, Integer> map = new HashMap<String, Integer>();

	public file_extracter(String file)throws IOException,FileNotFoundException
	{
		in = new BufferedReader(new FileReader(file));
		p = Pattern.compile("\\w+");


		for( String line = ""; line != null; line = in.readLine())
		{
			m = p.matcher(line.toLowerCase());
			while(m.find())
			{
				 map.put((line = m.group()), map.containsKey(line) ? map.get(line) + 1 : 1);
			}
		}

	}


		public ArrayList<String> corrector_edits(String word) throws IOException,FileNotFoundException
	{
		ArrayList <String> result = new ArrayList <String>();
	
		for(int i=0; i < word.length(); ++i) 
			result.add(word.substring(0, i) + word.substring(i+1));
		for(int i=0; i < word.length()-1; ++i) 
			result.add(word.substring(0, i) + word.substring(i+1, i+2) + word.substring(i, i+1) + word.substring(i+2));
		for(int i=0; i < word.length(); ++i) 
			for(char c='a'; c <= 'z'; ++c) 
				result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i+1));
		for(int i=0; i <= word.length(); ++i) 
			for(char c='a'; c <= 'z'; ++c) 
				result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
		return result;

	}

	public String corrector(String word)throws IOException,FileNotFoundException,NullPointerException
	{

	 	if(map.containsKey(word))
	 		return word;
	 	
	 	ArrayList<String> list = corrector_edits(word);

	 	HashMap <Integer, String> double_check = new HashMap<Integer, String>();

	 	for(int i = 0;i < list.size();i++)
	 	{
	 		if(map.containsKey(list.get(i))) 
	 			double_check.put(map.get(list.get(i)),list.get(i));	
	 	}

	 	if(double_check.size() > 0) 
	 		return double_check.get(Collections.max(double_check.keySet()));

	 	for(int i = 0;i < list.size();i++)
		{
			ArrayList<String> w = corrector_edits(list.get(i));
			
			for(int j = 0; j < w.size(); j++)
			{
		 		if(map.containsKey(w.get(j))) 
	 				double_check.put(map.get(w.get(j)),w.get(j));
			}
		}

		if(double_check.size() > 0) 
	 		return double_check.get(Collections.max(double_check.keySet()));

	 	else
	 		return word;

	}


}