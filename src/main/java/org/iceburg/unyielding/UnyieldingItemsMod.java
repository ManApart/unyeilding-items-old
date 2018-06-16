package org.iceburg.unyielding;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = UnyieldingItemsMod.MODID, name = UnyieldingItemsMod.NAME, version = UnyieldingItemsMod.VERSION)
public class UnyieldingItemsMod {
	
	public static final String MODID = "ak unyielding items mod";
	public static final String NAME = "AK Unyielding Items";
	public static final String VERSION = "1.0";
    
	@Mod.Instance(MODID)
	public static UnyieldingItemsMod instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	//Handle blocks
    	System.out.println("Pre initializing Unyielding Items mod");
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
    	//guies, other stuff
    	System.out.println("Initializing Unyielding Items mod");
    	MinecraftForge.EVENT_BUS.register(new PickupItemEventHandler());
    	System.out.println("Registered pickup items");
    	
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	//wrap up
    	System.out.println("Post initializing Unyielding Items mod");
    }
    
    
}
