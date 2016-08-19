package tutorial.generic;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


/**
 * http://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-8/first-item/
 * @author jen and naxder
 *
 */
@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	
	@SidedProxy(clientSide="tutorial.generic.ClientProxy", serverSide="tutorial.generic.ServerProxy")
	public static CommonProxy proxy;

    public static final String MODID = "naxder_mod";
    public static final String MODNAME = "Naxder's mod";
    public static final String VERSION = "1.0.0";

    @Instance
    public static Main instance = new Main();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		System.out.println("Naxder Called method: [preInit]");
		this.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
		System.out.println("Naxder Called method: [init]");
		this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
		System.out.println("Naxder Called method: [postInit]");
		this.proxy.postInit(e);
    }
}