package com.github.manintime.FactoryModPlugin.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

// Code based on MCP decomp'd minecraft
public class RecipeManager
{
	public RecipeManager()
	{
        addRecipe(null, new Object[] //A recipe example, the recipe will be: 
        {                            //      ###
        		"###",               //      &#&
        		"&#&",               //Where a '#' is dirt and a '&' is stone
        		"#", Material.DIRT,
        		"&", Material.STONE  
        });
	}
	
    void addRecipe(Object factoryType, Object par2ArrayOfObj[])
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String as[] = (String[])par2ArrayOfObj[i++];

            for (int l = 0; l < as.length; l++)
            {
                String s2 = as[l];
                k++;
                j = s2.length();
                s = (new StringBuilder()).append(s).append(s2).toString();
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s1 = (String)par2ArrayOfObj[i++];
                k++;
                j = s1.length();
                s = (new StringBuilder()).append(s).append(s1).toString();
            }
        }

        HashMap<Character, ItemStack> hashmap = new HashMap<Character, ItemStack>();

        for (; i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack = null;

            if (par2ArrayOfObj[i + 1] instanceof Material)
            {
                itemstack = new ItemStack((Material)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack);
        }

        ItemStack aitemstack[] = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; i1++)
        {
            char c = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c)));
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        recipes.add(new Recipe(j, k, aitemstack, null));
    }
    
    List<Recipe> recipes = new ArrayList<Recipe>();
}
