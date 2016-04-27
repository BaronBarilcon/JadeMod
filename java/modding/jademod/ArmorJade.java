package modding.jademod;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorJade extends ItemArmor{
	public ArmorJade(int type){
		super(JadeMod.JADEARMOR, 0, type);
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type){
		return JadeMod.MODID + ":" + "textures/models/armor/jade_layer_" + ((this.armorType == 2)? 2 : 1) + ".png";
	}
}
