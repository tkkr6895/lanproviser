package lanproviser;
class string_extracter
{
	private String input;
	String [] tokeniser;
	
	public string_extracter(String n)
	{
		input = n;
		
	}
	public String lower()
	{
		if((input.charAt(input.length()-1)=='.') || (input.charAt(input.length()-1)=='\n'))
			input = input.substring(0,input.length()-1);

		return(input.toLowerCase() +" ");
	}

	//counts the number of words
	public int word_number() 
	{
		char ch_index;
		int word_num = 0;
		
		for (int i = 0; i < lower().length();i++)
		{
			ch_index = lower().charAt(i);
			if(ch_index == ' ')
			{
				word_num++;
			}
			
		}
		//System.out.println(word_num);
		return word_num;
	}



	//tokenizes the string using the white spaces and fullstops
	public String[] tokenize_string() 
	{
		
		int array_pointer = 0;
		String word = null;
		int j = 0;
		char ch_index;
		
		tokeniser = new String[word_number()];
		
		String lower_inp = lower();

		for(int i = 0; i <lower_inp.length();i++)
		{
			ch_index = lower_inp.charAt(i);
			if(ch_index == ' ')
			{
				word = lower_inp.substring(j,i);
				j = i+1;
				tokeniser[array_pointer] = word;
				++array_pointer;
			}
			
		}
		//for(int i = 0; i <tokeniser.length;i++)
		//	System.out.println(tokeniser[i]);
		
		return (tokeniser);
	}

}
