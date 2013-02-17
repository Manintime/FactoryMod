package com.github.manintime.FactoryModPlugin.recipes;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

//Code based on MCP decomp'd minecraft
public class Recipe
{
    /** How many horizontal slots this recipe is wide. */
    private int recipeWidth;

    /** How many vertical slots this recipe uses. */
    private int recipeHeight;
    private ItemStack recipeItems[];

    /** Is the ItemStack that you get when craft the recipe. */
    private Object recipeOutput;


    public Recipe(int w, int h, ItemStack items[], Object output)
    {
        recipeWidth = w;
        recipeHeight = h;
        recipeItems = items;
        recipeOutput = output;
    }


    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(Inventory inv)
    {
        for (int i = 0; i <= 3 - recipeWidth; i++)
        {
            for (int j = 0; j <= 3 - recipeHeight; j++)
            {
                if (checkMatch(inv, i, j, true))
                {
                    return true;
                }

                if (checkMatch(inv, i, j, false))
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if the region of a crafting inventory is match for the recipe.
     */
    private boolean checkMatch(Inventory inv, int w, int h, boolean bool)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                int k = i - w;
                int l = j - h;
                ItemStack itemstack = null;

                if (k >= 0 && l >= 0 && k < recipeWidth && l < recipeHeight)
                {
                    if (bool)
                    {
                        itemstack = recipeItems[(recipeWidth - k - 1) + l * recipeWidth];
                    }
                    else
                    {
                        itemstack = recipeItems[k + l * recipeWidth];
                    }
                }

                ItemStack itemstack1 = getStackInRowAndColumn(inv, i, j);

                if (itemstack1 == null && itemstack == null)
                {
                    continue;
                }

                if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
                {
                    return false;
                }

                if (itemstack.getTypeId() != itemstack1.getTypeId())
                {
                    return false;
                }

                if (itemstack.getDurability() != -1 && itemstack.getDurability() != itemstack1.getDurability())
                {
                    return false;
                }
            }
        }

        return true;
    }
    
    ItemStack getStackInRowAndColumn(Inventory inv, int row, int col)
    {
        if (row < 0 || row >= 9)
        {
            return null;
        }
        else
        {
            int i = row + col * 9;
            return inv.getItem(i);
        }
    }
}