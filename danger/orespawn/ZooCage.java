/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZooCage
/*     */   extends Item
/*     */ {
/*  28 */   private int cage_size = 2;
/*     */ 
/*     */   
/*     */   public ZooCage(int i, int j) {
/*  32 */     this.maxStackSize = 16;
/*  33 */     setCreativeTab(CreativeTabs.tabDecorations);
/*  34 */     this.cage_size = j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer Player, World world, int cposx, int cposy, int cposz, int par7, float par8, float par9, float par10) {
/*  49 */     int bid = 0;
/*     */     
/*  51 */     int dirx = 0, dirz = 0;
/*     */     
/*  53 */     int length = this.cage_size / 2 + 1, width = length, height = width;
/*     */ 
/*     */ 
/*     */     
/*  57 */     if (cposx < 0) dirx = -1; 
/*  58 */     if (cposz < 0) dirz = -1; 
/*  59 */     int x = (int)(Player.posX + 0.99D * dirx);
/*  60 */     int y = (int)Player.posY - 1;
/*  61 */     int z = (int)(Player.posZ + 0.99D * dirz);
/*     */ 
/*     */     
/*  64 */     Player.worldObj.playSoundAtEntity((Entity)Player, "random.explode", 1.0F, 1.5F);
/*     */     
/*  66 */     if (world.isRemote)
/*     */     {
/*     */       
/*  69 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  73 */     for (int i = -width; i <= width; i++) {
/*     */       
/*  75 */       for (int j = -length; j <= length; j++) {
/*     */         
/*  77 */         for (int k = 0; k <= height + 1; k++) {
/*     */           
/*  79 */           if (k == height + 1) {
/*  80 */             world.setBlock(x + i, y + k, z + j, Blocks.quartz_block);
/*  81 */           } else if (k == 0) {
/*  82 */             world.setBlock(x + i, y + k, z + j, Blocks.quartz_block);
/*  83 */           } else if (i == width || j == length || i == -width || j == -length) {
/*  84 */             world.setBlock(x + i, y + k, z + j, Blocks.glass);
/*     */           } else {
/*  86 */             world.setBlock(x + i, y + k, z + j, Blocks.air);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  94 */     if (!Player.capabilities.isCreativeMode)
/*     */     {
/*  96 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 106 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ZooCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */