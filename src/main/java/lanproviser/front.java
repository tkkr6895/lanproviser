package lanproviser;
	import java.util.Scanner;
	import java.io.*;
	import javax.swing.*;

	public class front
	{
		
		public static void main(String [] args)throws IOException,NullPointerException
		{
			Scanner moo = new Scanner(System.in);

			file_extracter obj1 = new file_extracter("/Users/trishalkumar/Documents/workspace/lanproviser/src/main/resources/big.txt");
			
			String user_input = JOptionPane.showInputDialog("enter a sentence here","Lanproviser-Input");
			lanproviser in = new lanproviser();
			Object[] options = {"Spelling Check", "Grammar Check"};
			int n = JOptionPane.showOptionDialog(null, "Please enter choice of operation to be performed", "Lanproviser-Operation Choice",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[0]);
			
			
			
			switch(n)
			{
				case 0: 			
					string_extracter obj2 = new string_extracter(user_input);

					String sentence[];
					sentence = obj2.tokenize_string();
					String[] out = new String[50];
					
					for(int i = 0; i <sentence.length; i++)
					{
					
						out[i] = obj1.corrector(sentence[i]+" ");
					}
					JList list = new JList(out);
					JOptionPane.showMessageDialog(null,list);
					
					//System.out.print('\b');
					//System.out.println(".");
					break;
				case 1 : in.grammar(user_input);
				break;
				default: System.out.println("Invalid choice");
					
			}

		}
	}


