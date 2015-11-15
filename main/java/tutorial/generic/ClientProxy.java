package tutorial.generic;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.naxder.naxdermod.client.render.blocks.BlockRenderRegister;
import com.naxder.naxdermod.items.ItemRenderRegister;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		System.out.println("I am a client");
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		System.out.println("I am a client");
		ItemRenderRegister.registerItemRenderer();
		BlockRenderRegister.registerBlockRenderer();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		System.out.println("I am a client");
	}
}