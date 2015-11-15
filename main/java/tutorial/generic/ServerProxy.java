package tutorial.generic;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		System.out.println("I am a server");
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		System.out.println("I am a server");
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		System.out.println("I am a server");
	}
}