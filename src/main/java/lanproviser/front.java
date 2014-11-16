package lanproviser;
	import java.util.Scanner;
	import java.io.*;

	public class front
	{
		
		public static void main(String [] args)throws IOException
		{
			Scanner moo = new Scanner(System.in);

			file_extracter obj1 = new file_extracter("/Users/trishalkumar/Documents/workspace/lanproviser/src/main/resources/big.txt");
			System.out.println("enter a sentence here");
			String user_input = moo.nextLine();
			lanproviser in = new lanproviser();
			System.out.println("MENU:");
			System.out.println("1. Spelling Corrector");
			System.out.println("2. Grammar Corrector");
			System.out.print("Please enter in te tsk you would like to perform: ");
			int choice = moo.nextInt();
			
			
			switch(choice)
			{
				case 1: 			
					string_extracter obj2 = new string_extracter(user_input);

					String sentence[];
					sentence = obj2.tokenize_string();
					
					for(int i = 0; i <sentence.length; i++)
					{
						System.out.print(obj1.corrector(sentence[i])+" ");
					}
					//System.out.print('\b');
					//System.out.println(".");
					moo.close();
					break;
				case 2 : in.grammar(user_input);
				break;
				default: System.out.println("Invalid choice");
					
			}

		}
	}


