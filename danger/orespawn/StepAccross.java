/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
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
/*     */ public class StepAccross
/*     */   extends Item
/*     */ {
/*     */   public StepAccross(int i) {
/*  29 */     this.maxStackSize = 16;
/*  30 */     setCreativeTab(CreativeTabs.tabTools);
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
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer Player, World world, int cposx, int cposy, int cposz, int par7, float par8, float par9, float par10) {
/*  43 */     int deltax = 0, deltaz = 0;
/*     */ 
/*     */     
/*  46 */     int length = 33;
/*     */     
/*  48 */     int x = cposx, y = cposy + 1, z = cposz;
/*     */     
/*  50 */     float f = Player.rotationYawHead;
/*  51 */     f += 22.5F;
/*  52 */     f %= 360.0F;
/*  53 */     f /= 45.0F;
/*  54 */     switch ((int)f) {
/*     */       case 0:
/*  56 */         deltax = 0;
/*  57 */         deltaz = 1;
/*     */         break;
/*     */       case 1:
/*  60 */         deltax = -1;
/*  61 */         deltaz = 1;
/*     */         break;
/*     */       case 2:
/*  64 */         deltax = -1;
/*  65 */         deltaz = 0;
/*     */         break;
/*     */       case 3:
/*  68 */         deltax = -1;
/*  69 */         deltaz = -1;
/*     */         break;
/*     */       case 4:
/*  72 */         deltax = 0;
/*  73 */         deltaz = -1;
/*     */         break;
/*     */       case 5:
/*  76 */         deltax = 1;
/*  77 */         deltaz = -1;
/*     */         break;
/*     */       case 6:
/*  80 */         deltax = 1;
/*  81 */         deltaz = 0;
/*     */         break;
/*     */       case 7:
/*  84 */         deltax = 1;
/*  85 */         deltaz = 1;
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/*  90 */     if (deltax == 0 && deltaz == 0) return false;
/*     */     
/*  92 */     Player.worldObj.playSoundAtEntity((Entity)Player, "random.explode", 1.0F, 1.5F);
/*     */     
/*  94 */     if (world.isRemote) {
/*     */       
/*  96 */       for (int var3 = 0; var3 < 6; var3++) {
/*     */         
/*  98 */         world.spawnParticle("largesmoke", (x + world.rand.nextFloat() - world.rand.nextFloat()), (y + world.rand.nextFloat()), (z + world.rand.nextFloat() - world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/*  99 */         world.spawnParticle("largeexplode", (x + world.rand.nextFloat() - world.rand.nextFloat()), (y + world.rand.nextFloat()), (z + world.rand.nextFloat() - world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/* 100 */         world.spawnParticle("reddust", (x + world.rand.nextFloat() - world.rand.nextFloat()), (y + world.rand.nextFloat()), (z + world.rand.nextFloat() - world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */       
/* 103 */       return true;
/*     */     } 
/*     */     
/* 106 */     for (int k = 1; k < length; ) {
/* 107 */       Block bid = world.getBlock(x + k * deltax, y - 1, z + k * deltaz);
/* 108 */       if (bid == Blocks.air) {
/* 109 */         world.setBlock(x + k * deltax, y - 1, z + k * deltaz, Blocks.cobblestone, 0, 2);
/*     */ 
/*     */ 
/*     */         
/* 113 */         if ((k - 1) % 8 == 0) {
/* 114 */           bid = world.getBlock(x + k * deltax, y, z + k * deltaz);
/* 115 */           if (bid == Blocks.air) {
/* 116 */             world.setBlock(x + k * deltax, y, z + k * deltaz, OreSpawnMain.ExtremeTorch, 0, 2);
/*     */           }
/*     */         } 
/*     */         k++;
/*     */       } 
/*     */     } 
/* 122 */     if (!Player.capabilities.isCreativeMode)
/*     */     {
/* 124 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 133 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\StepAccross.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */