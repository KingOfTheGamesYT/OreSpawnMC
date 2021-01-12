/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemExperienceTreeSeed
/*    */   extends Item
/*    */ {
/*    */   public ItemExperienceTreeSeed(int i) {
/* 27 */     this.maxStackSize = 1;
/* 28 */     setCreativeTab(CreativeTabs.tabDecorations);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
/* 35 */     if (!world.isRemote) {
/*    */ 
/*    */       
/* 38 */       Block bid = world.getBlock(x, y, z);
/* 39 */       if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/* 40 */         return false;
/*    */       }
/*    */       
/* 43 */       world.setBlock(x, y + 1, z, OreSpawnMain.MyExperiencePlant, 0, 2);
/*    */     } else {
/*    */       
/* 46 */       for (int j1 = 0; j1 < 10; j1++)
/*    */       {
/*    */         
/* 49 */         world.spawnParticle("happyVillager", (x + world.rand.nextFloat()), y + 1.0D + world.rand.nextFloat(), (z + world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 54 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*    */     {
/* 56 */       par1ItemStack.stackSize--;
/*    */     }
/*    */     
/* 59 */     return true;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 64 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemExperienceTreeSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */