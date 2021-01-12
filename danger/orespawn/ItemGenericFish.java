/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemGenericFish
/*    */   extends ItemFood
/*    */ {
/*    */   public ItemGenericFish(int par1, int par2, float par3, boolean par4) {
/* 20 */     super(par2, par3, par4);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 26 */     super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
/* 27 */     if (!par2World.isRemote)
/*    */     {
/* 29 */       if (par2World.rand.nextInt(4) == 1) par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 20, 0));
/*    */     
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 36 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemGenericFish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */