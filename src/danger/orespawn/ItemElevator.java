/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.entity.player.EntityPlayer;
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
/*    */ public class ItemElevator
/*    */   extends Item
/*    */ {
/*    */   public ItemElevator(int par1) {
/* 27 */     this.maxStackSize = 1;
/* 28 */     setCreativeTab(CreativeTabs.tabTransport);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/* 33 */     if (par3World.isRemote) return true;
/*    */ 
/*    */     
/* 36 */     Elevator elevator = (Elevator)EntityList.createEntityByName("Hoverboard", par3World);
/* 37 */     elevator.setLocationAndAngles((par4 + 0.5F), (par5 + 1.2F), (par6 + 0.5F), par3World.rand.nextFloat() * 360.0F, 0.0F);
/* 38 */     par3World.spawnEntityInWorld((Entity)elevator);
/*    */     
/* 40 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*    */     {
/* 42 */       par1ItemStack.stackSize--;
/*    */     }
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 52 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemElevator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */