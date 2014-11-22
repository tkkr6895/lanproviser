package lanproviser;
	import java.io.*;
import javax.swing.*;

	public class front
	{
		
		public static void main(String [] args)throws IOException,NullPointerException,FileNotFoundException
		{
			int ch;
			do{
			
			Object[] options = {"Relative Spell Check", "Grammar Check"};
			int n = JOptionPane.showOptionDialog(null, "Please enter choice of operation to be performed", "Lanproviser-Operation Choice",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
			
			String user_input = JOptionPane.showInputDialog("enter a sentence here","Lanproviser-Input");
			lanproviser in = new lanproviser();
			
			
			
			
			
			switch(n)
			{
				case 0: 	
					String path = JOptionPane.showInputDialog("Enter the path of the diciotnary");
					file_extracter obj1 = new file_extracter(path);
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
			Object[] options1 = {"Yes", "No"};
			 ch = JOptionPane.showOptionDialog(null, "Would you like to start over", "Lanproviser-Operation Choice",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1,options1[0]);
			}while(ch!=1);

		}
	}


