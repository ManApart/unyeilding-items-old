package org.iceburg.unyielding;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class PickupItemEventHandler {
	
	@SubscribeEvent
	public void onPickupItem(EntityItemPickupEvent event) {
		EntityItem item = event.getItem();
		ItemStack stack = item.getEntityItem();
//		System.out.println(item.getEntityId() +": " + stack.getUnlocalizedName() + " picked up.");
		if (shouldRepair(stack)){		
			System.out.println("Healing " + stack.getUnlocalizedName()+ " on pickup");
//			stack.getItem().setMaxDamage(1000000);
			stack.setItemDamage(1);			
		}
	}
	
	@SubscribeEvent
	public void onSwing(BreakEvent event) {
		EntityPlayer player = event.getPlayer();
		for (EnumHand hand : EnumHand.values()){
			repairItemInHand(player, hand);
		}
	}

	private void repairItemInHand(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (shouldRepair(stack)){
			System.out.println("Healing " + stack.getDisplayName() + " on swing");
			stack.setItemDamage(1);
		}
	}

	private boolean shouldRepair(ItemStack stack) {
		if (stack != null){ 
			return stack.isItemStackDamageable() ||
					(stack.getItem() != null && stack.getItem().isRepairable());
		}
		return false;
	}

	@SubscribeEvent
	public void onGetHurt(LivingHurtEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		if (entity instanceof EntityPlayer){
			System.out.println("Player hurt");
			EntityPlayer player = (EntityPlayer) entity;
			
			for (ItemStack stack : player.getArmorInventoryList()){
//					System.out.println("Player is wearing " + stack.getUnlocalizedName());
				System.out.println("Healing " + stack.getDisplayName() + " on hurt");
				stack.setItemDamage(1);
			}
			
//			System.out.println("Healing " + stack.getUnlocalizedName()+ "on getting hurt");
		}
		
		
	}

}
