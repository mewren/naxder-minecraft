package tutorial.generic;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.naxder.naxdermod.blocks.ModBlocks;
import com.naxder.naxdermod.crafting.ModCrafting;
import com.naxder.naxdermod.items.ModItems;
import com.naxder.naxdermod.world.TutorialWorldGen;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
		ModBlocks.createBlocks();		

		//ModBlocks.placeHelloWorld();
	}

	public void init(FMLInitializationEvent e) {
		ModCrafting.initCrafting();
		
	    GameRegistry.registerWorldGenerator(new TutorialWorldGen(), 0);
	    
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}