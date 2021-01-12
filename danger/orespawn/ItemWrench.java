/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemWrench
/*     */   extends Item
/*     */ {
/*     */   public ItemWrench(int i) {
/*  25 */     setCreativeTab(CreativeTabs.tabTools);
/*  26 */     setMaxDamage(100);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/*  44 */     if (entity != null && entity instanceof SpiderRobot && entity.riddenByEntity == null) {
/*  45 */       EntityLiving e = (EntityLiving)entity;
/*     */       
/*  47 */       float h = e.getMaxHealth() - e.getHealth();
/*  48 */       e.setDead();
/*  49 */       dropItem(player.worldObj, e, OreSpawnMain.SpiderRobotKit, 1, (int)h);
/*     */       
/*  51 */       for (int var3 = 0; var3 < 8; var3++) {
/*     */         
/*  53 */         float f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  54 */         float f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/*  55 */         float f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  56 */         player.worldObj.spawnParticle("smoke", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/*  57 */         f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  58 */         f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/*  59 */         f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  60 */         player.worldObj.spawnParticle("explode", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/*  61 */         f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  62 */         f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/*  63 */         f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  64 */         player.worldObj.spawnParticle("reddust", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/*     */       } 
/*  66 */       player.worldObj.playSoundAtEntity((Entity)player, "random.explode", 0.5F, 1.5F);
/*     */     
/*     */     }
/*  69 */     else if (entity != null && entity instanceof AntRobot && entity.riddenByEntity == null) {
/*  70 */       AntRobot e = (AntRobot)entity;
/*     */       
/*  72 */       if (e.getOwned() == 0) {
/*  73 */         if (e.getHealth() / e.getMaxHealth() > 0.5F) return false; 
/*  74 */         e.setOwned();
/*     */       } 
/*  76 */       float h = e.getMaxHealth() - e.getHealth();
/*  77 */       e.setDead();
/*  78 */       dropItem(player.worldObj, e, OreSpawnMain.AntRobotKit, 1, (int)h);
/*     */       
/*  80 */       for (int var3 = 0; var3 < 8; var3++) {
/*     */         
/*  82 */         float f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  83 */         float f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/*  84 */         float f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  85 */         player.worldObj.spawnParticle("smoke", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/*  86 */         f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  87 */         f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/*  88 */         f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  89 */         player.worldObj.spawnParticle("explode", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/*  90 */         f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  91 */         f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/*  92 */         f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/*  93 */         player.worldObj.spawnParticle("reddust", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/*     */       } 
/*  95 */       player.worldObj.playSoundAtEntity((Entity)player, "random.explode", 0.5F, 1.5F);
/*     */     } else {
/*     */       
/*  98 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 102 */     stack.damageItem(2, (EntityLivingBase)player);
/* 103 */     if (stack.stackSize <= 0)
/*     */     {
/* 105 */       player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItem(World world, EntityLiving e, Item index, int par1, int par2) {
/* 112 */     if (world.isRemote)
/* 113 */       return;  ItemStack is = new ItemStack(index, par1, 0);
/* 114 */     is.setItemDamage(par2);
/* 115 */     EntityItem var3 = new EntityItem(world, e.posX, e.posY + 1.0D, e.posZ, is);
/* 116 */     world.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 123 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemWrench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */