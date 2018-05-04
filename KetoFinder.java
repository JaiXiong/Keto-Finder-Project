import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KetoFinder extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String args[])
	{	
		Map<String, List<String>> central = new HashMap<String, List<String>>();
		List<String> _meat_fatty = new ArrayList<>(Arrays.asList("beef", "pork", "organs", "egg", "salmon", "bacon"));
		List<String> _meat_lean = new ArrayList<>(Arrays.asList("fish", "chicken", "crab"));
		List<String> _drink = new ArrayList<>(Arrays.asList("water", "tea", "coffee", "dry wine", "spirits"));
		List<String> _dairy = new ArrayList<>(Arrays.asList("yogurt", "heavy cream", "sour cream", "mozzarella", "mayonnaise"));
		List<String> _nuts = new ArrayList<>(Arrays.asList("walnuts", "almonds", "macadamia nuts", "pecans", "nut butter"));
		List<String> _berries = new ArrayList<>(Arrays.asList("blackberries", "strawberries", "blueberries", "raspberries"));
		List<String> _vegetable_NS = new ArrayList<>(Arrays.asList("cabbage", "avocado", "cucumber", "asparagus", "romaine lettuce")); //non starchy
		List<String> _vegetable_LC = new ArrayList<>(Arrays.asList("tomato", "broccoli", "cauliflower", "bell pepper", "mushroom", "radish", "zucchini", "pumpkin")); //low carb
		List<String> _fat = new ArrayList<>(Arrays.asList("coconut oil", "garlic oil", "olive oil", "avocado oil", "butter", "grapeseed oil"));
		List<String> _spices = new ArrayList<>(Arrays.asList("mint", "parsley", "cilantro", "chilli powder", "salt", "pepper"));
		List<String> _nonKeto = new ArrayList<>(Arrays.asList("potatoes", "processed foods", "soda", "juice", "beans", "sugar", "fruit", "grains", "factory meat"));
		String [] names = {"Fatty Meats", "Lean Meats", "Drinks", "Dairy","Nuts","Berries","Non Starchy Vegetable",
							"Low Carb Vegetable", "Fats","Spices","Non Keto"};
		central.put("fatty meats", _meat_fatty);
		central.put("lean meats", _meat_lean);
		central.put("drink", _drink);
		central.put("dairy", _dairy);
		central.put("nuts", _nuts);
		central.put("berries", _berries);
		central.put("non starchy vegetables", _vegetable_NS);
		central.put("low carb vegetables", _vegetable_LC);
		central.put("fat", _fat);
		central.put("spices", _spices);
		central.put("nonKeto", _nonKeto);

		//p = new JPanel(new GridBagLayout());
		//		GridBagConstraints x = new GridBagConstraints();


				JButton tmpButton;
		
				JFrame f = new JFrame("Keto Finder");
				//		JPanel bottomSide = new JPanel(new BorderLayout());
				//		JPanel leftSide = new JPanel(new BorderLayout());
				//		JPanel rightSide = new JPanel(new BorderLayout());
				JPanel mainSide = new JPanel();
				JPanel leftSide = new JPanel();
				JPanel rightSide = new JPanel();
				JTextField console = new JTextField();
				mainSide.setLayout(new BorderLayout());
				leftSide = new JPanel(new GridLayout(11,1));
				rightSide = new JPanel(new GridLayout(1, 1));
				JButton menu = new JButton("Menu");
				JButton start = new JButton("Start");
				JLabel l = new JLabel("Type");
				JRadioButton name = new JRadioButton("meat");
		
				for (int i = 0; i < names.length; i++)
				{	
		
					tmpButton = new JButton(names[i]);
					leftSide.add(tmpButton, BorderLayout.EAST);
					//System.out.println(tmpButton);
				}
		
				f.setVisible(true);
				f.setSize(900, 900);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainSide.setBackground(Color.GRAY);
				mainSide.add(menu, BorderLayout.WEST);
				mainSide.add(start, BorderLayout.CENTER);
				//leftSide.add(name, BorderLayout.EAST);
				f.add(mainSide, BorderLayout.SOUTH);
				f.add(leftSide, BorderLayout.WEST);
				f.add(rightSide, BorderLayout.EAST);
				rightSide.add(console, BorderLayout.CENTER);
		



		Scanner userInput = new Scanner(System.in);

		System.out.println("Wecome to Keto Finder");



		Boolean active = true;

		while (active == true)
		{
			System.out.println("What kind of food would you like to inquire about? "+ "Enter a category: ");

			for(int i = 0; i < names.length; i++)
			{
				System.out.println(i +") " + names[i]);
			}

			String data = userInput.nextLine();
			
			if (!central.containsKey(data.toLowerCase()))
			{
				System.out.println("Enter food not a type of Keto or will soon be added to the database");
			}

			if (central.containsKey(data))
			{
				if (checkDupes(data, central, userInput) == null)
				{
					central.get(data);
				}
				else
				{
					checkDupes(data, central, userInput);
				}
			}
		}

	}

	public static List<String> checkDupes(String dataString, Map<String, List<String>> list, Scanner userInput )
	{
	//	Scanner inScanner = new Scanner(System.in);
		if (dataString == null) return null;
		
		if (dataString.contains("meat"))
		{
			System.out.println("You asked about a meat, would you like to see information about lean or fatty meats? ");
			String typeMeat = userInput.nextLine();
			if (typeMeat.equals("lean"))
			{
				System.out.println(list.get("lean meats"));
				return list.get("lean meats");
			}
			else
			{
				return list.get("fatty meats");
			}
		}

		if (dataString.contains("vegetable"))
		{
			System.out.println("You asked about a vegatable, would you like to see information about low carb or non starchy vegetables? ");
			String typeVeggie = userInput.nextLine();
			if(typeVeggie.equals("low carb"))
			{
				System.out.println(list.get("low carb vegetables"));
				return list.get("low carb vegetables");
			}
			else 
			{
				return list.get("non starchy vegetables");
			}
		}
		return null;
	}

	public List<String> searchThis()
	{

		return null;
	}
}