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
/*    */ 
/*    */ public class ItemFireFish
/*    */   extends ItemFood
/*    */ {
/*    */   public ItemFireFish(int par1, int par2, float par3, boolean par4) {
/* 21 */     super(par2, par3, par4);
/* 22 */     setAlwaysEdible();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 28 */     super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
/* 29 */     if (!par2World.isRemote)
/*    */     {
/* 31 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1200, 0));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 38 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemFireFish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */