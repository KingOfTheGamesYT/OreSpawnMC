/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemShoes
/*    */   extends Item
/*    */ {
/* 19 */   private int my_id = 0;
/*    */ 
/*    */   
/*    */   public ItemShoes(int i, int j) {
/* 23 */     this.my_id = j;
/* 24 */     this.maxStackSize = 64;
/* 25 */     setCreativeTab(CreativeTabs.tabDecorations);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 35 */     if (!par3EntityPlayer.capabilities.isCreativeMode)
/*    */     {
/* 37 */       par1ItemStack.stackSize--;
/*    */     }
/*    */     
/* 40 */     par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
/*    */     
/* 42 */     if (!par2World.isRemote)
/*    */     {
/* 44 */       par2World.spawnEntityInWorld((Entity)new Shoes(par2World, (EntityLivingBase)par3EntityPlayer, this.my_id));
/*    */     }
/*    */     
/* 47 */     return par1ItemStack;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 52 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemShoes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */