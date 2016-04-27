package modding.jademod;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	private static final String KEY_ENABLE_JADE_ORE_WORLD_GEN = "enableJadeOreWorldGen";
	private static final boolean DEFAULT_ENABLE_JADE_ORE_WORLD_GEN = true;

	private boolean enableJadeOreWorldGen;

	public void init(File configFile){
		Configuration config = new Configuration(configFile);
		config.load();

		enableJadeOreWorldGen = config.get(Category.FEATURES.getKey(),
				KEY_ENABLE_JADE_ORE_WORLD_GEN,
				DEFAULT_ENABLE_JADE_ORE_WORLD_GEN,
				"Generates Jade Ore in Overworld.")
				.getBoolean();

		config.save();
	}

	public boolean isEnableJadeOreWorldGen(){
		return enableJadeOreWorldGen;
	}

	private enum Category{
		FEATURES("features");

		private String key;

		private Category(String key){
			this.key = key;
		}

		public String getKey(){
			return key;
		}
	}
}
