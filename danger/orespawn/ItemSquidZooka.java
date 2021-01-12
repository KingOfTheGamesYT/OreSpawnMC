/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemSquidZooka
/*     */   extends Item
/*     */ {
/*     */   public ItemSquidZooka(int i) {
/*  21 */     this.maxStackSize = 1;
/*  22 */     setMaxDamage(100);
/*  23 */     setCreativeTab(CreativeTabs.tabCombat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  33 */     if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
/*  34 */       return par1ItemStack;
/*     */     }
/*     */     
/*  37 */     par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.explode", 0.5F, 0.5F);
/*     */     
/*  39 */     if (!par2World.isRemote) {
/*  40 */       double xzoff = 2.5D;
/*  41 */       double yoff = 1.65D;
/*     */       
/*  43 */       this; Entity e = spawnCreature(par2World, "Attack Squid", par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians((par3EntityPlayer.rotationYawHead + 15.0F))), par3EntityPlayer.posY + yoff, par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians((par3EntityPlayer.rotationYawHead + 15.0F))));
/*     */ 
/*     */       
/*  46 */       if (e instanceof AttackSquid) {
/*  47 */         AttackSquid a = (AttackSquid)e;
/*  48 */         a.setWasShot();
/*     */       } 
/*     */       
/*  51 */       float f = 3.6F;
/*  52 */       e.motionX = (-MathHelper.sin(par3EntityPlayer.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(par3EntityPlayer.rotationPitch / 180.0F * 3.1415927F) * f);
/*  53 */       e.motionZ = (MathHelper.cos(par3EntityPlayer.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(par3EntityPlayer.rotationPitch / 180.0F * 3.1415927F) * f);
/*  54 */       e.motionY = (-MathHelper.sin(par3EntityPlayer.rotationPitch / 180.0F * 3.1415927F) * f);
/*     */       
/*  56 */       e.motionX += (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05D;
/*  57 */       e.motionY += (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05D;
/*  58 */       e.motionZ += (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05D;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     par3EntityPlayer.swingItem();
/*     */     
/*  66 */     par3EntityPlayer.addVelocity(Math.cos(Math.toRadians((par3EntityPlayer.rotationYawHead - 90.0F))) * 0.45D, 0.1D, Math.sin(Math.toRadians((par3EntityPlayer.rotationYawHead - 90.0F))) * 0.45D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
/*  76 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/*  86 */     Entity var8 = null;
/*  87 */     var8 = EntityList.createEntityByName(par1, par0World);
/*  88 */     if (var8 != null) {
/*     */ 
/*     */       
/*  91 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/*  94 */       par0World.spawnEntityInWorld(var8);
/*     */     } 
/*  96 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMaterialName() {
/* 105 */     return "Unknown";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 110 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemSquidZooka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */