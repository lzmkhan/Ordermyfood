package com.example.ordermyfood1;


import java.util.ArrayList;
import java.util.List;


public class CartOperation {	
	
	private List<Food> Cart = new ArrayList<Food>();

	
	public CartOperation()
	{
		
	}
	
	
	
	public void addtocart(Food food)
	{
		//adds food and quantity to list
		Cart.add(food);
	}
	
	
	
public void removefromcart(Food f)
	{
		//removes food and quantity from list
	int position =Cart.indexOf(f.getFood_title());
	
		Cart.remove(position);
	}
	

public List<Food> get_cart_content_transfer()
{
	return Cart;
}

public void setCart(List<Food> C)
{
	this.Cart =C;
}



public  List<Food> get_food_for_cart()
{
	//used to populate the ordersummary list view
	addplusatend(); //adds plus at end
	return Cart;
}
	
	public int chkifalrdyextsinlst(Food sFood)
	{
		// checks if the sFood is already present in Cart, if yes returns 1 and if no returns 0
		int j = Cart.size();
		Food f;
		for(int i=0;i<j;i++)
		{
		f=	Cart.get(i);
		if(sFood.getFood_title().equals(f.getFood_title()))
		{
			return 1;
		}
		}
		return 0;
	}
	
	public int returnposition(Food sFood)
	{
		int j = Cart.size();
		Food f;
		for(int i=0;i<j;i++)
		{
		f=	Cart.get(i);
		if(sFood.getFood_title().equals(f.getFood_title()))
		{
			return i;// returns position where the sfood is already stored
		}
		}
		return 0;
	}
	
	public void updatecart(int position, int qnty)
	{
		// gets the position and adds the quantity to already present quantity of the food in order summary
	Food f1= Cart.get(position);
	
	f1.setQnty(qnty);
		Cart.set(position,f1 );
		
		
	}
	
	
	public void addplusatend()
	{
		//adds the "+" icon at the end of the list.
		Food f2 = new Food("additem",0,0);
		Cart.add(f2);
				
	}
	
	public void delplusatend()
	{
		//deletes the "+" at the end of list.
		
	int pos = Cart.size();
	Cart.remove(pos);
	}

}
