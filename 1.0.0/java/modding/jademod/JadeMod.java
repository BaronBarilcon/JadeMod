package modding.jademod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

@Mod(name = JadeMod.MODNAME, modid = JadeMod.MODID, version = JadeMod.VERSION)
public class JadeMod {
	public static final String MODID = "jademod";
	public static final String MODNAME = "Jade Mod";
	public static final String VERSION = "1.0.0";

	public static Item.ToolMaterial JADE;
	public static ArmorMaterial JADEARMOR;

	public static Item gemJade;
	public static Block blockJade;
	public static Block oreJade;

	public static Item swordJade;
	public static Item pickaxeJade;
	public static Item shovelJade;
	public static Item axeJade;
	public static Item hoeJade;

	public static Item helmetJade;
	public static Item chestplateJade;
	public static Item leggingsJade;
	public static Item bootsJade;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		//■Jade（翡翠）の追加
		gemJade = new Item();
		gemJade.setUnlocalizedName("gemJade");
		gemJade.setCreativeTab(CreativeTabs.tabMaterials);
		gemJade.setTextureName(MODID + ":" + "gemJade");
		GameRegistry.registerItem(gemJade, "gemJade");

		//■Jade Block（翡翠ブロック）の追加
		blockJade = new BlockJade();
		blockJade.setBlockName("blockJade");
		blockJade.setCreativeTab(CreativeTabs.tabBlock);
		blockJade.setBlockTextureName(MODID + ":" + "blockJade");
		GameRegistry.registerBlock(blockJade, "blockJade");
		GameRegistry.addRecipe(new ItemStack(blockJade, 1),
				new Object[] {"XXX", "XXX", "XXX", 'X', gemJade});
		GameRegistry.addShapelessRecipe(new ItemStack(gemJade, 9),
				blockJade);

		//■Jade Ore（翡翠鉱石）の追加
		oreJade = new OreJade();
		oreJade.setBlockName("oreJade");
		oreJade.setCreativeTab(CreativeTabs.tabBlock);
		oreJade.setBlockTextureName(MODID + ":" + "oreJade");
		GameRegistry.registerBlock(oreJade, "oreJade");

		//■ToolMaterial JADE の登録
		JADE = EnumHelper.addToolMaterial("JADE", 3, 250, 8.0F, 3.0F, 10);
		JADE.customCraftingMaterial = gemJade;

		//■Jade Sword（翡翠の剣）の追加
		swordJade = new ItemSword(JADE);
		swordJade.setUnlocalizedName("swordJade");
		swordJade.setCreativeTab(CreativeTabs.tabCombat);
		swordJade.setTextureName(MODID + ":" + "swordJade");
		GameRegistry.registerItem(swordJade, "swordJade");
		GameRegistry.addRecipe(new ItemStack(swordJade, 1),
				new Object[] {"X", "X", "Y", 'X', gemJade, 'Y', Items.stick});

		//■Jade Pickaxe（翡翠のツルハシ）の追加
		pickaxeJade = new PickaxeJade(JADE);
		pickaxeJade.setUnlocalizedName("pickaxeJade");
		pickaxeJade.setCreativeTab(CreativeTabs.tabTools);
		pickaxeJade.setTextureName(MODID + ":" + "pickaxeJade");
		GameRegistry.registerItem(pickaxeJade, "pickaxeJade");
		GameRegistry.addRecipe(new ItemStack(pickaxeJade, 1),
				new Object[] {"XXX", " Y ", " Y ", 'X', gemJade, 'Y', Items.stick});

		//■Jade Spade（翡翠のシャベル）の追加
		shovelJade = new ItemSpade(JADE);
		shovelJade.setUnlocalizedName("shovelJade");
		shovelJade.setCreativeTab(CreativeTabs.tabTools);
		shovelJade.setTextureName(MODID + ":" + "shovelJade");
		GameRegistry.registerItem(shovelJade, "shovelJade");
		GameRegistry.addRecipe(new ItemStack(shovelJade, 1),
				new Object[] {"X", "Y", "Y", 'X', gemJade, 'Y', Items.stick});

		//■Jade Axe（翡翠の斧）の追加
		axeJade = new AxeJade(JADE);
		axeJade.setUnlocalizedName("axeJade");
		axeJade.setCreativeTab(CreativeTabs.tabTools);
		axeJade.setTextureName(MODID + ":" + "axeJade");
		GameRegistry.registerItem(axeJade, "axeJade");
		GameRegistry.addRecipe(new ItemStack(axeJade, 1),
				new Object[] {"XX", "XY", " Y", 'X', gemJade, 'Y', Items.stick});

		//■Jade Hoe（翡翠のクワ）の追加
		hoeJade = new ItemSpade(JADE);
		hoeJade.setUnlocalizedName("hoeJade");
		hoeJade.setCreativeTab(CreativeTabs.tabTools);
		hoeJade.setTextureName(MODID + ":" + "hoeJade");
		GameRegistry.registerItem(hoeJade, "hoeJade");
		GameRegistry.addRecipe(new ItemStack(hoeJade, 1),
				new Object[] {"XX", " Y", " Y", 'X', gemJade, 'Y', Items.stick});

		JADEARMOR = EnumHelper.addArmorMaterial("JADEARMOR", 15, new int[] {3, 8, 6, 3}, 10);

		//■Jade Helmet（翡翠のヘルメット）の追加
		helmetJade = new ArmorJade(0);
		helmetJade.setUnlocalizedName("helmetJade");
		helmetJade.setCreativeTab(CreativeTabs.tabCombat);
		helmetJade.setTextureName(MODID + ":" + "helmetJade");
		GameRegistry.registerItem(helmetJade, "helmetJade");
		GameRegistry.addRecipe(new ItemStack(helmetJade, 1),
				new Object[] {"XXX", "X X", 'X', gemJade});

		//■Jade Chestplate（翡翠のチェストプレート）の追加
		chestplateJade = new ArmorJade(1);
		chestplateJade.setUnlocalizedName("chestplateJade");
		chestplateJade.setCreativeTab(CreativeTabs.tabCombat);
		chestplateJade.setTextureName(MODID + ":" + "chestplateJade");
		GameRegistry.registerItem(chestplateJade, "chestplateJade");
		GameRegistry.addRecipe(new ItemStack(chestplateJade, 1),
				new Object[] {"X X", "XXX", "XXX", 'X', gemJade});


		//■Jade Leggings（翡翠のレギンス）の追加
		leggingsJade = new ArmorJade(2);
		leggingsJade.setUnlocalizedName("leggingsJade");
		leggingsJade.setCreativeTab(CreativeTabs.tabCombat);
		leggingsJade.setTextureName(MODID + ":" + "leggingsJade");
		GameRegistry.registerItem(leggingsJade, "leggingsJade");
		GameRegistry.addRecipe(new ItemStack(leggingsJade, 1),
				new Object[] {"XXX", "X X", "X X", 'X', gemJade});


		//■Jade Boots（翡翠のブーツ）の追加
		bootsJade = new ArmorJade(3);
		bootsJade.setUnlocalizedName("bootsJade");
		bootsJade.setCreativeTab(CreativeTabs.tabCombat);
		bootsJade.setTextureName(MODID + ":" + "bootsJade");
		GameRegistry.registerItem(bootsJade, "bootsJade");
		GameRegistry.addRecipe(new ItemStack(bootsJade, 1),
				new Object[] {"X X", "X X", 'X', gemJade});

	}

	@EventHandler
	public void init(FMLInitializationEvent e){
		GameRegistry.registerWorldGenerator(new GeneratorOreJade(), 0);
	}
}
