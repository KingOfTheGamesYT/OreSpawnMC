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
/*    */ public class ItemSunFish
/*    */   extends ItemFood
/*    */ {
/*    */   public ItemSunFish(int par1, int par2, float par3, boolean par4) {
/* 20 */     super(par2, par3, par4);
/* 21 */     setAlwaysEdible();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 26 */     super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
/* 27 */     if (!par2World.isRemote && this == OreSpawnMain.MySunFish)
/*    */     {
/* 29 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
/*    */     }
/* 31 */     if (!par2World.isRemote && this == OreSpawnMain.MyButterCandy) {
/*    */       
/* 33 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000, 0));
/* 34 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 2000, 0));
/*    */     } 
/* 36 */     if (!par2World.isRemote && this == OreSpawnMain.MyBacon) {
/*    */       
/* 38 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2000, 0));
/* 39 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2000, 0));
/*    */     } 
/* 41 */     if (!par2World.isRemote && this == OreSpawnMain.MyCrystalApple) {
/*    */       
/* 43 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3000, 0));
/* 44 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 3000, 0));
/*    */     } 
/* 46 */     if (!par2World.isRemote && this == OreSpawnMain.MyLove) {
/*    */       
/* 48 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 3));
/* 49 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000, 2));
/* 50 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 2));
/* 51 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 1));
/* 52 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5000, 0));
/* 53 */       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 5000, 0));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 60 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemSunFish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */